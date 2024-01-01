package it.unisa.IS_Project.Model.Service;

import it.unisa.IS_Project.Model.Entity.UtenteEntity;
import it.unisa.IS_Project.Model.Exception.GAC.Login.LoginPasswordsMismatchException;
import it.unisa.IS_Project.Model.Exception.GAC.Login.UserNotFound;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidEmailException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidNameException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.InvalidPasswordException;
import it.unisa.IS_Project.Model.Exception.GAC.Signup.SignupPasswordsMismatchException;
import it.unisa.IS_Project.Model.Repository.UtenteRepository;
import it.unisa.IS_Project.Utility.UtilityClass;
import it.unisa.IS_Project.Utility.ValidatorClass;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UtenteServiceImpl implements UtenteService{
    @Autowired
    private UtenteRepository utenteRepository;
    @Override
    @Transactional
    public void signup(String email, String nome, String password, String passwordRipetuta) throws NoSuchAlgorithmException, InvalidEmailException, InvalidNameException, InvalidPasswordException, SignupPasswordsMismatchException {
        UtenteEntity utenteEntity = new UtenteEntity();

        if(email == null || !ValidatorClass.emailValidator(email))
            throw new InvalidEmailException("Email non valida");

        if(nome == null || nome.length() == 0 || nome.length() > 32)
            throw new InvalidNameException("Nome non valido");

        if(password == null || !ValidatorClass.passwordValidator(password))
            throw new InvalidPasswordException("Password non valida");

        if(passwordRipetuta == null || !ValidatorClass.passwordValidator(passwordRipetuta))
            throw new InvalidPasswordException("Password ripetuta non valida");

        if(!password.equals(passwordRipetuta))
            throw new SignupPasswordsMismatchException("Le password non coincidono");

        String passwordCriptata = UtilityClass.cryptAlg(password);

        utenteEntity.setEmail(email);
        utenteEntity.setNome(nome);
        utenteEntity.setPassword(passwordCriptata);

        utenteRepository.save(utenteEntity);
    }

    @Override
    @Transactional
    public void login(String email, String password) throws NoSuchAlgorithmException, UserNotFound, LoginPasswordsMismatchException {
        UtenteEntity utente = utenteRepository.findByEmail(email);

        if(utente == null)
            throw new UserNotFound("Utente non registrato");

        String passwordCriptata = UtilityClass.cryptAlg(password);

        if(!passwordCriptata.equals(utente.getPassword()))
            throw new LoginPasswordsMismatchException("Le password non coincidono");
    }

    @Override
    @Transactional
    public UtenteEntity get(String email) {
        return utenteRepository.findByEmail(email);
    }
}
