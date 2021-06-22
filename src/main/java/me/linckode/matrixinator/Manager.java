package me.linckode.matrixinator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public static ArrayList<Matrix> matrices = new ArrayList<>();

    public static boolean listMatrices() {
        System.out.println();
        if (matrices.isEmpty()) {
            System.out.println(Main.configuration.noLoadedMatricesMessage);
            return false;
        }
        System.out.println(Main.configuration.listMatricesTitleMessage);
        for (Matrix matrix : matrices) {

            System.out.print(matrix.getName() + "(" + matrix.getLines() + "," + matrix.getColumns() + ")" + ((matrix.getIsResult() ? "*" : "")) + "; ");

        }
        System.out.println();
        return true;
    }

    public static void saveMatrix(Matrix matrix) throws IOException {
        File file = new File("matrices/" + matrix.getName() + ".mtx");
        MatrixFile.saveToFile(file, matrix);
    }

    public static void deleteMatrix(Matrix matrix) {
        File file = new File("matrices/" + matrix.getName() + ".mtx");
        file.delete();
        matrices.remove(matrix);
    }

    public static Matrix selectMatrix(char matrixName) throws Exception {

        matrixName = Character.toUpperCase(matrixName);

        for (Matrix matrix : matrices) {
            if (matrix.getName() == matrixName) {
                return matrix;
            }
        }

        throw new Exception(Main.configuration.matrixDoesntExistMessage);
    }

    public static void loadMatrices() {

        if (!(new File("matrices").exists())) {
            new File("matrices").mkdirs();
        }

        for (File file : new File("matrices").listFiles()) {
            try {
                matrices.add(MatrixFile.getFromFile(file));
            } catch (IOException ignored) {
            }
        }

    }

    public static void newMatrix() {
        Matrix matrix = Matrix.getFromKeyboard();
        matrices.add(matrix);

        matrix.print();

    }

    public static void presentMatrixChoice(Matrix matrix) throws Exception {

        matrix.print();

        System.out.println(Main.configuration.mainChoiceQuestionMessage);
        System.out.println();
        System.out.println("1. " + Main.configuration.matrixChoiceTransposeMessage);
        System.out.println("2. " + Main.configuration.matrixChoiceDeterminantMessage);
        System.out.println("3. " + Main.configuration.matrixChoiceMultiplyIntegerMessage);
        System.out.println("4. " + Main.configuration.matrixChoiceMultiplyMatrixMessage);
        System.out.println();
        System.out.println("5. " + Main.configuration.matrixChoiceSaveMessage);
        System.out.println("6. " + Main.configuration.matrixChoiceDeleteMessage);
        System.out.println();
        System.out.println("7. " + Main.configuration.matrixChoiceGoBackMessage);

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1 -> {
                Matrix temp = Operations.transpose(matrix);
                temp.print();
                Thread.sleep(2000);
                presentMatrixChoice(matrix);
            }
            case 2 -> {
                int determinant = Operations.determinant(matrix);
                System.out.println(Main.configuration.matrixResultDeterminantMessage + determinant);
                Thread.sleep(2000);
                presentMatrixChoice(matrix);
            }
            case 3 -> {

                System.out.println(Main.configuration.matrixIntegerInputMessage);
                int nr = new Scanner(System.in).nextInt();

                Matrix temp = Operations.multiplyByInteger(matrix, nr);
                temp.print();
                Thread.sleep(2000);
                presentMatrixChoice(matrix);
            }
            case 4 -> {

                System.out.println(Main.configuration.inputMatrixNameMessage);
                char name = new Scanner(System.in).nextLine().charAt(0);

                Matrix secondMatrix = selectMatrix(name);
                System.out.println("Result matrix: ");
                Matrix tempMatrix = Operations.multiplyByMatrix(matrix, secondMatrix);
                tempMatrix.print();
                Thread.sleep(2000);


                presentMatrixChoice(matrix);
            }
            case 5 -> {
                saveMatrix(matrix);
                presentMatrixChoice(matrix);
            }
            case 6 -> {
                deleteMatrix(matrix);
                presentMainChoices();
            }
            case 7 -> {
                presentMainChoices();
            }
        }

    }

    public static void presentMainChoices() throws Exception {

        listMatrices();

        System.out.println(Main.configuration.mainChoiceQuestionMessage);
        System.out.println();
        System.out.println("1. " + Main.configuration.mainChoiceSelectMatrix);
        System.out.println("2. " + Main.configuration.mainChoiceNewMatrix);
        System.out.println();
        System.out.println("3. " + Main.configuration.mainChoiceCloseApp);

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println(Main.configuration.inputMatrixNameMessage);
                char name = new Scanner(System.in).nextLine().charAt(0);
                if (checkMatrixExistence(name))
                    presentMatrixChoice(selectMatrix(name));
            }
            case 2 -> {
                newMatrix();
                presentMainChoices();
            }
            case 3 -> System.exit(0);
            default -> presentMainChoices();
        }


    }

    private static boolean checkMatrixExistence(char name) {
        boolean exists = false;

        name = Character.toUpperCase(name);

        for (Matrix matrix : matrices) {
            if (matrix.getName() == name) {
                exists = true;
                break;
            }
        }

        return exists;

    }


}
