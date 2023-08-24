package controller;


import dao.UserDAO;
import jakarta.persistence.NoResultException;
import model.User;
import security.PasswordEncryptor;

public class AuthenticationController {
    private final UserDAO userDAO;
    private final PasswordEncryptor passwordEncryptor;

    public AuthenticationController(UserDAO userDAO, PasswordEncryptor passwordEncryptor) {
        this.userDAO = userDAO;
        this.passwordEncryptor = passwordEncryptor;
    }

    public boolean authenticate(String email, String password) {
        try{
            User user = userDAO.getUserByEmail(email);
            return passwordEncryptor.isPasswordValid(password, user.getPassword());
        } catch (NoResultException erro){
            return false;
        }
    }
}
