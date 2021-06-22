package me.linckode.matrixinator;

public class Operations {

    public static Matrix multiplyByInteger(Matrix matrix, int nr) {

        Matrix tempMatrix = new Matrix(matrix);
        tempMatrix.setResult();

        tempMatrix.perItem((x, y) -> {
            tempMatrix.content[x][y] *= nr;
        });

        tempMatrix.setup();

        return tempMatrix;
    }

    public static Matrix transpose(Matrix matrix) {

        Matrix tempMatrix = new Matrix(matrix);
        tempMatrix.setResult();
        tempMatrix.setLines(matrix.getColumns());
        tempMatrix.setColumns(matrix.getLines());
        tempMatrix.setContent(new int[tempMatrix.getLines()][tempMatrix.getColumns()], false);

        tempMatrix.perItem(((x, y) -> {
            tempMatrix.content[x][y] = matrix.content[y][x];
        }));
        tempMatrix.setup();
        return tempMatrix;
    }

    public static Matrix multiplyByMatrix(Matrix matrix1, Matrix matrix2) throws Exception {

        if (matrix1.getLines() != matrix2.getColumns() || matrix1.getColumns() != matrix2.getLines()) {
            throw new Exception(Main.configuration.incompatibleMatricesMessage);
        }

        int matrixSize = matrix2.getColumns();
        int maxMI = matrix2.getLines();


        Matrix tempMatrix = new Matrix(Util.getMatrixNameFromUser(), matrixSize, matrixSize);
        tempMatrix.setResult();
        tempMatrix.setContent(new int[matrixSize][matrixSize], true);

        tempMatrix.perItem(((x, y) -> {
            int value = 0;
            for (int MI = 0; MI < maxMI; MI++) {
                value += (matrix1.content[x][MI] * matrix2.content[MI][y]);
            }
            tempMatrix.content[x][y] = value;
        }));

        tempMatrix.setup();
        return tempMatrix;
    }

    public static int determinant(Matrix matrix) throws Exception {

        if (!matrix.isSquare()) throw new Exception(Main.configuration.matrixNotSquareMessage);
        if (!(matrix.getLines() == 2 || matrix.getLines() == 3)) throw new Exception(Main.configuration.badMatrixSizeMessage);

        int determinant;

        if (matrix.getLines() == 2) {
            determinant = (matrix.content[0][0] * matrix.content[1][0]) - (matrix.content[0][1] * matrix.content[1][1]);
            return determinant;
        }

        determinant =
                matrix.content[0][0] * matrix.content[1][1] * matrix.content[2][2] +
                        matrix.content[1][0] * matrix.content[2][1] * matrix.content[0][2] +
                        matrix.content[2][0] * matrix.content[0][1] * matrix.content[1][2] -

                        matrix.content[0][2] * matrix.content[1][1] * matrix.content[2][0] -
                        matrix.content[1][2] * matrix.content[2][1] * matrix.content[0][0] -
                        matrix.content[2][2] * matrix.content[0][1] * matrix.content[1][0];


        return -determinant;
    }

}
