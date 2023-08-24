package view;

import controller.RegistrationController;
import dao.UserDAO;
import security.PasswordEncryptor;
import util.EmailValidator;

import java.util.Scanner;

public class RegistrationView {
    public static void showRegistrationForm(UserDAO userDAO, PasswordEncryptor passwordEncryptor) {
        Scanner scanner = new Scanner(System.in);
        String email;

        System.out.println("\n---------- CADASTRANDO USUÁRIO ----------");
        System.out.print("Digite seu nickname: ");
        String nickname = scanner.nextLine();

        do{
            System.out.print("Digite seu e-mail: ");
            email = scanner.nextLine();
        } while (!EmailValidator.isValidEmail(email));

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        RegistrationController registrationController = new RegistrationController(userDAO, passwordEncryptor);
        registrationController.registerUser(email, password, nickname);
    }
}
