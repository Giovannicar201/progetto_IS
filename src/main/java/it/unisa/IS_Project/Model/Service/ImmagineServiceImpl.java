package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.ImmagineEntity;
import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Repository.ImmagineRepository;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
public class ImmagineServiceImpl implements ImmagineService{
    @Autowired
    private ImmagineRepository immagineRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    @Transactional
    public ImmagineEntity add(Part foto, String nomeFoto, String email) {

        UtenteEntity utenteEntity = utenteRepository.findByEmail(email);
        Blob fotoBlob;

        try {
            fotoBlob = convertPartToBlob(foto);
        } catch (IOException | SQLException e) {
            throw new RuntimeException("Errore durante la conversione di Part in Blob");
        }

        ImmagineEntity immagineEntity = new ImmagineEntity();
        immagineEntity.setFoto(fotoBlob);
        immagineEntity.setNome(this.getFileName(foto));
        immagineEntity.setEmail(utenteEntity);

        return immagineEntity;
    }

    private Blob convertPartToBlob(Part part) throws SQLException, IOException {
        try (InputStream inputStream = part.getInputStream()) {
            byte[] data = readAllBytes(inputStream);
            return new SerialBlob(data);
        }
    }

    private byte[] readAllBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        return outputStream.toByteArray();
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "unknown";
    }

    @Override
    @Transactional
    public ImmagineEntity get(String nomeFoto){
        ImmagineEntity immagineEntity=immagineRepository.findByNome(nomeFoto).get();
        return immagineEntity;
    }

    @Override
    @Transactional
    public ImmagineEntity update(ImmagineEntity newImmagineEntity,String nomeFoto) {
        ImmagineEntity immagineEntity=immagineRepository.findByNome(nomeFoto).get();
        newImmagineEntity.setNome(nomeFoto);
        immagineEntity.setFoto(newImmagineEntity.getFoto());
        immagineEntity.setNome(newImmagineEntity.getNome());
        ImmagineEntity saved=immagineRepository.save(immagineEntity);
        return saved;
    }

    @Override
    @Transactional
    public void delete(String nomeFoto) {
        immagineRepository.deleteByNome(nomeFoto);
    }

    @Override
    public List<ImmagineEntity> getAllImmagini(String email) {
        return immagineRepository.findAllByEmail(email);
    }
}
