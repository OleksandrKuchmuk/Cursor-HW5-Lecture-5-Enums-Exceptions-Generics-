package com.company;

import java.util.Scanner;

public class Authentication {

    public static void inputParameters() throws WrongLoginException, WrongPasswordException {
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
            System.out.println("\nWrong login, login does not match the parameters");
            e.getStackTrace();
        } catch (WrongPasswordException e2) {
            System.out.println("\nWrong password, or password Confirmation does not match the parameters" +
                    " or are not identical");
            e2.getStackTrace();
        }
    }

    public static boolean inputVerification(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String checkList = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[_])(?=\\S+$).{5,20}";
        if (login.matches(checkList) && password.matches(checkList) && confirmPassword.equals(password)) {
            return true;
        } else if (!login.matches(checkList)) {
            throw new WrongLoginException();
        } else if (!password.matches(checkList)) {
            throw new WrongPasswordException();
        } else if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }
        return false;
    }

    private static void parametersOfInput() {
        System.out.print("(Must consist of letters 'A-Z', letters 'a-z' and a symbol '_'," +
                "\n and have 5-20 symbols): ");
    }

    private static void parametersConfirmPassword() {
        System.out.print("(Must be the same as the password): ");
    }


}
