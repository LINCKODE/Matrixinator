package me.linckode.matrixinator;

import java.io.File;

public class Main {

    public static Configuration configuration;

    static File configFile = new File("config.yaml");


    public static void main(String[] args) throws Exception {

        if (!configFile.exists()) {
            configFile.createNewFile();
            Configuration.saveDefaultConfig(configFile);
        }

        configuration = Configuration.getFromFile(configFile);

        System.out.println("Matrixinator v." + configuration.VERSION);
        Manager.loadMatrices();
        if (!Manager.listMatrices()) Manager.newMatrix();
        Manager.presentMainChoices();

    }

}
