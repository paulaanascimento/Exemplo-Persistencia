import dao.UserDAOImpl;
import security.BCryptPasswordEncryptor;
import security.PasswordEncryptor;
import view.AuthenticationView;
import view.RegistrationView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAOImpl userDAO = new UserDAOImpl();
        PasswordEncryptor passwordEncryptor = new BCryptPasswordEncryptor();

        while (true) {
            System.out.println("""
                    ---------- MENU ----------
                    1. Cadastrar
                    2. Login
                    3. Sair""");
            System.out.print("Digite o número correspondente a opção desejada: ");

            try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        RegistrationView.showRegistrationForm(userDAO, passwordEncryptor);
                        break;
                    case 2:
                        AuthenticationView.showAuthenticationForm(userDAO, passwordEncryptor);
                        break;
                    case 3:
                        System.out.println("\nEncerrando aplicação...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOpção inválida! Tente novamente!\n");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("\nEntrada inválida! Para inserir uma opção, digite um número inteiro!\n");
                scanner.next();
            }
        }
    }
}
