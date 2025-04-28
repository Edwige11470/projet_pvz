package com.oxyl.coursepfback;
import com.oxyl.coursepfback.configuration.AppConfig;


public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        boolean isConnected = config.testDatabaseConnection();
        if (isConnected) {
            System.out.println("Connexion à la base de données réussie !");
        } else {
            System.out.println("Échec de la connexion à la base de données.");
        }


    }
}
