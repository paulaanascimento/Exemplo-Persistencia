package controller;

import dao.UserDAO;
import model.User;
import security.PasswordEncryptor;
import view.AuthenticationView;

public class RegistrationController {
    private final UserDAO userDAO;
    private final PasswordEncryptor passwordEncryptor;

    public RegistrationController(UserDAO userDAO, PasswordEncryptor passwordEncryptor) {
        this.userDAO = userDAO;
        this.passwordEncryptor = passwordEncryptor;
    }

    public void registerUser(String email, String password, String nickname) {
        if (!userDAO.emailExists(email)) {
            User newUser = new User(email, passwordEncryptor.encryptPassword(password), nickname);
            userDAO.createUser(newUser);
            System.out.println("Usuário Cadastrado com Sucesso!");
            AuthenticationView.showAuthenticationForm(userDAO, passwordEncryptor);

        } else {
            System.out.println("Email já cadastrado!\n");
        }
    }
}
