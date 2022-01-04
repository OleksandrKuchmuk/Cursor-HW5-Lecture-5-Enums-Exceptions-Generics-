package com.company;

import java.util.Scanner;

public class Authentication {

    public static boolean inputParameters() throws WrongLoginException, WrongPasswordException {
        System.out.println("\nEnter your Login");
        parametersOfInput();
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();

        System.out.println("\nEnter your Password");
        parametersOfInput();
        String password = scanner.nextLine();

        System.out.println("\nConfirm your Password");
        parametersConfirmPassword();
        String confirmPassword = scanner.nextLine();

        try {
            inputVerification(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            e.printStackTrace();
            System.out.println("\nWrong login, login does not match the parameters");
            return false;
        } catch (WrongPasswordException e2) {
            e2.printStackTrace();
            System.out.println("\nWrong password, or password Confirmation does not match the parameters" +
                    " or are not identical");
            return false;
        }
        return true;
    }

    public static void inputVerification(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String checkList = "(?=.[0-9a-zA-Z_]+$)(?=\\S+$).{0,20}";
        if (!login.matches(checkList)) {
            throw new WrongLoginException();
        }
        if (!password.matches(checkList)) {
            throw new WrongPasswordException();
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }
    }

    private static void parametersOfInput() {
        System.out.print("(Must consist of letters 'A-Z', letters 'a-z', figures 0-9 and a symbol '_'," +
                "\n and have 5-20 symbols): ");
    }

    private static void parametersConfirmPassword() {
        System.out.print("(Must be the same as the password): ");
    }
}
