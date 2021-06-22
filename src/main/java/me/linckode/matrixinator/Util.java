package me.linckode.matrixinator;

import java.util.Scanner;

public class Util {

    public static char getMatrixNameFromUser() {

        System.out.println(Main.configuration.inputMatrixNameMessage);

        String tempString = new Scanner(System.in).nextLine();

        if (tempString.length() != 1) {
            System.out.println(Main.configuration.badMatrixNameLengthMessage);
            return getMatrixNameFromUser();
        }
        if (!Character.isLetter(tempString.charAt(0))) {
            System.out.println(Main.configuration.matrixNameNotLetterMessage);
            return getMatrixNameFromUser();
        }

        char name = Character.toUpperCase(tempString.charAt(0));

        for (Matrix matrix : Manager.matrices) {
            if (matrix.getName() == name) {
                System.out.println(Main.configuration.matrixAlreadyExistsMessage);
                return getMatrixNameFromUser();
            }
        }
        return name;
    }


}
