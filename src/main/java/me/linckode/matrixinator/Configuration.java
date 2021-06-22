package me.linckode.matrixinator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

public class Configuration {

    String VERSION;
    String incompatibleMatricesMessage;
    String matrixNotSquareMessage;
    String badMatrixSizeMessage;
    String noLoadedMatricesMessage;
    String inputMatrixNameMessage;
    String badMatrixNameLengthMessage;
    String matrixNameNotLetterMessage;
    String matrixAlreadyExistsMessage;
    String linesMessage;
    String columnsMessage;
    String matrixInputContentsMessage;
    String matrixDoesntExistMessage;
    String mainChoiceQuestionMessage;
    String listMatricesTitleMessage;
    String mainChoiceSelectMatrix;
    String mainChoiceNewMatrix;
    String mainChoiceCloseApp;
    String matrixChoiceTransposeMessage;
    String matrixChoiceMultiplyIntegerMessage;
    String matrixChoiceDeterminantMessage;
    String matrixChoiceMultiplyMatrixMessage;
    String matrixChoiceGoBackMessage;
    String matrixChoiceSaveMessage;
    String matrixChoiceDeleteMessage;
    String matrixIntegerInputMessage;
    String matrixResultDeterminantMessage;

    public Configuration() {
    }

    public static Configuration getFromFile(File configFile) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return new Gson().fromJson(objectMapper.readValue(configFile, LiteralConfig.class).config, Configuration.class);
    }

    public static void saveDefaultConfig(File configFile) throws IOException {

        Configuration configuration = new Configuration();
        configuration.VERSION = "1.0.0";
        configuration.incompatibleMatricesMessage = "The matrices are not compatible.";
        configuration.matrixNotSquareMessage = "Matrix is not square.";
        configuration.badMatrixSizeMessage = "Matrix size must be 2 or 3.";
        configuration.noLoadedMatricesMessage = "No matrices loaded.";
        configuration.inputMatrixNameMessage = "Input matrix name(one letter):";
        configuration.badMatrixNameLengthMessage = "Matrix name must be just one character long.";
        configuration.matrixNameNotLetterMessage = "Matrix name must be a letter.";
        configuration.matrixAlreadyExistsMessage = "Matrix already exists.";
        configuration.linesMessage = "Lines: ";
        configuration.columnsMessage = "Columns: ";
        configuration.matrixInputContentsMessage = "Input matrix contents: ";
        configuration.matrixDoesntExistMessage = "Matrix doesn't exist.";
        configuration.mainChoiceQuestionMessage = "What do you want to do?";
        configuration.listMatricesTitleMessage = "Matrices:";
        configuration.mainChoiceSelectMatrix = "Select matrix.";
        configuration.mainChoiceNewMatrix = "New matrix.";
        configuration.mainChoiceCloseApp = "Exit.";
        configuration.matrixChoiceTransposeMessage = "Transpose.";
        configuration.matrixChoiceDeterminantMessage = "Determinant.";
        configuration.matrixChoiceMultiplyIntegerMessage = "Multiply with integer.";
        configuration.matrixChoiceMultiplyMatrixMessage = "Multiply with Matrix.";
        configuration.matrixChoiceGoBackMessage = "Go back.";
        configuration.matrixChoiceSaveMessage = "Save matrix.";
        configuration.matrixChoiceDeleteMessage = "Delete Matrix.";
        configuration.matrixIntegerInputMessage = "Input integer: ";
        configuration.matrixResultDeterminantMessage = "Determinant: ";


        String literal = new Gson().toJson(configuration);

        LiteralConfig config = new LiteralConfig(literal);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());//.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        objectMapper.writeValue(configFile, config);

    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }

    public String getIncompatibleMatricesMessage() {
        return incompatibleMatricesMessage;
    }

    public void setIncompatibleMatricesMessage(String incompatibleMatricesMessage) {
        this.incompatibleMatricesMessage = incompatibleMatricesMessage;
    }

    public String getMatrixNotSquareMessage() {
        return matrixNotSquareMessage;
    }

    public void setMatrixNotSquareMessage(String matrixNotSquareMessage) {
        this.matrixNotSquareMessage = matrixNotSquareMessage;
    }

    public String getBadMatrixSizeMessage() {
        return badMatrixSizeMessage;
    }

    public void setBadMatrixSizeMessage(String badMatrixSizeMessage) {
        this.badMatrixSizeMessage = badMatrixSizeMessage;
    }

    public String getNoLoadedMatricesMessage() {
        return noLoadedMatricesMessage;
    }

    public void setNoLoadedMatricesMessage(String noLoadedMatricesMessage) {
        this.noLoadedMatricesMessage = noLoadedMatricesMessage;
    }

    public String getInputMatrixNameMessage() {
        return inputMatrixNameMessage;
    }

    public void setInputMatrixNameMessage(String inputMatrixNameMessage) {
        this.inputMatrixNameMessage = inputMatrixNameMessage;
    }

    public String getBadMatrixNameLengthMessage() {
        return badMatrixNameLengthMessage;
    }

    public void setBadMatrixNameLengthMessage(String badMatrixNameLengthMessage) {
        this.badMatrixNameLengthMessage = badMatrixNameLengthMessage;
    }

    public String getMatrixNameNotLetterMessage() {
        return matrixNameNotLetterMessage;
    }

    public void setMatrixNameNotLetterMessage(String matrixNameNotLetterMessage) {
        this.matrixNameNotLetterMessage = matrixNameNotLetterMessage;
    }

    public String getMatrixAlreadyExistsMessage() {
        return matrixAlreadyExistsMessage;
    }

    public void setMatrixAlreadyExistsMessage(String matrixAlreadyExistsMessage) {
        this.matrixAlreadyExistsMessage = matrixAlreadyExistsMessage;
    }

    public String getLinesMessage() {
        return linesMessage;
    }

    public void setLinesMessage(String linesMessage) {
        this.linesMessage = linesMessage;
    }

    public String getColumnsMessage() {
        return columnsMessage;
    }

    public void setColumnsMessage(String columnsMessage) {
        this.columnsMessage = columnsMessage;
    }

    public String getMatrixInputContentsMessage() {
        return matrixInputContentsMessage;
    }

    public void setMatrixInputContentsMessage(String matrixInputContentsMessage) {
        this.matrixInputContentsMessage = matrixInputContentsMessage;
    }
}