import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String agency = requestAgency(scanner);
        int accountNumber = Integer.parseInt(requestInformation(scanner, "Por favor, digite o número da Conta:"));
        String clientName = requestInformation(scanner, "Por favor, digite o nome do Cliente:").toUpperCase();
        double balance = Double.parseDouble(requestInformation(scanner, "Por favor, digite o saldo:"));

        displayFinalMessage(clientName, agency, accountNumber, balance);

        scanner.close();
    }

    private static String requestInformation(Scanner scanner, String message) {
        clearConsole();
        System.out.println(message);
        return scanner.nextLine();
    }

    private static String requestAgency(Scanner scanner) {
        String regex = "\\d{3}-\\d{1}"; // Expressão regular para ###-#
        String agency;

        clearConsole();

        do {
            System.out.println("Por favor, digite o número da Agência (formato ###-#):");

            agency = scanner.nextLine();

            if (agency.matches(regex)) {
                break;
            }

            clearConsole();

            System.out.println("Formato de agência inválido. Digite novamente.");
        } while (true);

        return agency;
    }

    private static void displayFinalMessage(String clientName, String agency, int accountNumber, double balance) {
        clearConsole();
        String message = "Olá " + clientName + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agency + ", conta " + accountNumber + " e seu saldo " + balance + " já está disponível para saque.";
        System.out.println(message);
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
