package view;
import controller.AuthenticationController;
import dao.UserDAO;
import model.User;
import security.PasswordEncryptor;
import util.EmailValidator;

import java.util.Scanner;

public class AuthenticationView {
    public static void showAuthenticationForm(UserDAO userDAO, PasswordEncryptor passwordEncryptor) {
        Scanner scanner = new Scanner(System.in);
        String email;

        System.out.println("\n---------- LOGIN ----------");
        do{
            System.out.print("Digite seu e-mail: ");
            email = scanner.nextLine();

            if(!EmailValidator.isValidEmail(email)){
                System.out.println("\nForneça um e-mail válido!");
            }
        } while (!EmailValidator.isValidEmail(email));

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        AuthenticationController authenticationController = new AuthenticationController(userDAO, passwordEncryptor);


        if(authenticationController.authenticate(email, password)){
            User user = userDAO.getUserByEmail(email);
            System.out.println("Bem vindo de volta, " + user.getNickname() + "!\n");
        } else {
            System.out.println("Crendenciais inválidas!\n");
        }
    }
}
