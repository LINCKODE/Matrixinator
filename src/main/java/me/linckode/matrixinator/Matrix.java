package me.linckode.matrixinator;

import java.util.Scanner;

public class Matrix {

    public int[][] content;
    private char name;
    private int lines, columns;
    private boolean square;
    private int min, max;
    private int maxNumberDigitCount;
    private boolean isResult = false;

    public Matrix(char name, int lines, int columns) {
        this.name = name;
        this.lines = lines;
        this.columns = columns;
    }

    public Matrix() {
    }

    public Matrix(Matrix matrix) {
        this(matrix.name, matrix.lines, matrix.columns);
        this.square = matrix.square;
        this.min = matrix.min;
        this.max = matrix.max;
        this.content = matrix.content;
        this.maxNumberDigitCount = matrix.maxNumberDigitCount;
        this.isResult = matrix.isResult;
    }

    public static Matrix getFromKeyboard() {

        Scanner scanner = new Scanner(System.in);

        char name = Util.getMatrixNameFromUser();
        System.out.println(Main.configuration.linesMessage);

        int lines = scanner.nextInt();
        scanner.nextLine();

        System.out.println(Main.configuration.columnsMessage);
        int columns = scanner.nextInt();
        scanner.nextLine();

        Matrix matrix = new Matrix(name, lines, columns);

        System.out.println(Main.configuration.matrixInputContentsMessage);

        int[][] content = new int[lines][columns];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(name + "(" + (i + 1) + "," + (j + 1) + "): ");
                content[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }

        matrix.setContent(content, true);

        return matrix;

    }

    public void print() {
        System.out.println();
        System.out.print(name + "(" + lines + "," + columns + ")" + ((isResult ? "*" : "")) + ": ");
        System.out.println();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(content[i][j] + calculateSpaceOffset(content[i][j]) + " ");
            }
            System.out.println();
        }

    }

    public void perItem(PerItemAction action) {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                action.execute(i, j);
            }
        }
    }

    private String calculateSpaceOffset(int nr) {
        int tempNr = nr, counter = 0;
        while (tempNr != 0) {
            tempNr /= 10;
            counter += 1;
        }

        StringBuilder temp = new StringBuilder();

        counter = maxNumberDigitCount - counter;

        for (int i = 0; i < counter; i++)
            temp.append(" ");
        return temp.toString();
    }

    private void calcMinMax() {

        //Calculate the minimum
        min = content[0][0];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (content[i][j] < min) min = content[i][j];
            }
        }

        //Calculate the maximum

        max = content[0][0];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (content[i][j] > max) max = content[i][j];
            }
        }

        int tempMax = max, counter = 0;

        while (tempMax != 0) {
            tempMax /= 10;
            counter += 1;
        }

        maxNumberDigitCount = counter;

    }

    public void setContent(int[][] content, boolean doSetup) {
        this.content = content;
        if (doSetup) setup();

    }

    public void setup() {
        calcMinMax();
        square = lines == columns;
    }

    public void setResult() {
        isResult = true;
    }

    public boolean getIsResult() {
        return isResult;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean isSquare() {
        return square;
    }

    public void setSquare(boolean square) {
        this.square = square;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int[][] getContent() {
        return content;
    }

    public int getMaxNumberDigitCount() {
        return maxNumberDigitCount;
    }

    public void setMaxNumberDigitCount(int maxNumberDigitCount) {
        this.maxNumberDigitCount = maxNumberDigitCount;
    }
}
