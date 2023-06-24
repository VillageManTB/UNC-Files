package a8;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

        // your code below
        while (true) {
            System.out.println("Enter Master Password");
            while (!passwordManager.checkMasterPassword(scanner.nextLine())) {
                System.out.println("Enter Master Password");
            }
            String command1 = null;
            while (!"Exit".equals(command1)) {
                command1 = scanner.nextLine();
                if ("New password".equals(command1)) {
                    String website = scanner.nextLine();
                    String password = scanner.nextLine();
                    passwordManager.put(website,password);
                    System.out.println("New password added");
                } else if ("Get password".equals(command1)) {
                    String website = scanner.nextLine();
                    if (passwordManager.get(website) == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(passwordManager.get(website));
                    }
                } else if ("Delete account".equals(command1)) {
                    String website = scanner.nextLine();
                    if (passwordManager.remove(website) == null) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println("Account deleted");
                    }
                } else if ("Check duplicate password".equals(command1)) {
                    String password = scanner.nextLine();
                    if (passwordManager.checkDuplicate(password).isEmpty()) {
                        System.out.println("No account uses that password");
                    } else {
                        System.out.println("Websites using that password:");
                        for (int i=0; i< passwordManager.checkDuplicate(password).size();i++) {
                            System.out.println(passwordManager.checkDuplicate(password).get(i));
                        }
                    }
                } else if ("Get accounts".equals(command1)) {
                    System.out.println("Your accounts:");
                    System.out.println(passwordManager.keySet());
                } else if ("Generate random password".equals(command1)) {
                    int generate = scanner.nextInt();
                    System.out.println(passwordManager.generateRandomPassword(generate));
                } else {
                    System.out.println("Command not found");
                }
            }
        }
    }
}
