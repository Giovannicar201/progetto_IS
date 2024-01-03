package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Exception.GEN.GIM.CaricaImmagine.InvalidFileSizeException;
import it.unisa.IS_Project.Model.Repository.ImmagineRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Service
public class ImmagineServiceImpl implements ImmagineService{
    @Autowired
    private ImmagineRepository immagineRepository;
    @Autowired
    private UtenteService utenteService;

    @Override
    @Transactional
    public void caricaImmagine(MultipartFile foto, String email) throws SQLException, IOException, InvalidFileSizeException {

        ImmagineEntity immagineEntity = new ImmagineEntity();
        UtenteEntity utenteEntity = utenteService.get(email);

        if(!isImageSizeValid(foto))
            throw new InvalidFileSizeException("Dimensione dell'immagine non valida");

        Blob fotoBlob = convertMultipartFileToBlob(foto);

        String nomeFoto = foto.getOriginalFilename();
        immagineEntity.setFoto(fotoBlob);
        immagineEntity.setNome(nomeFoto);
        immagineEntity.setEmail(utenteEntity);

        immagineRepository.save(immagineEntity);
    }

    private static Blob convertMultipartFileToBlob(MultipartFile multipartFile) throws SQLException {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();

            return new SerialBlob(bytes);
        } catch (Exception e) {
            throw new SQLException("Errore durante la conversione di MultipartFile in Blob");
        }
    }

    private static boolean isImageSizeValid(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());

        return image.getWidth() == 32 && image.getHeight() == 32;
    }

    @Override
    @Transactional
    public void integraPixelArt(MultipartFile foto, String nomeFoto, String email) {
        /*TO-DO*/ //integrazione immagine
    }

    @Override
    @Transactional
    public ImmagineEntity get(String nomeFoto){
        return immagineRepository.findByNome(nomeFoto);
    }

    @Override
    public String visualizzaListaImmagini(String email) throws SQLException {
        JSONObject immaginiJSON = new JSONObject();
        JSONArray blobImmagini = new JSONArray();

        List<ImmagineEntity> immagini = immagineRepository.findAllByEmail(email);

        for(ImmagineEntity immagineEntity : immagini) {
            JSONObject immagineJSON = new JSONObject();

            Blob immagine = immagineEntity.getFoto();
            byte[] bytes = immagine.getBytes(1, (int) immagine.length());

            immagineJSON.put(immagineEntity.getNome(),Base64.getEncoder().encodeToString(bytes));

            blobImmagini.add(immagineJSON);
        }

        immaginiJSON.put("blobImmagini", blobImmagini);

        return immaginiJSON.toString();
    }
}
