package com.epf;
import com.epf.configuration.config;


public class Main {
    public static void main(String[] args) {
        config config = new config();
        boolean isConnected = config.testDatabaseConnection();
        if (isConnected) {
            System.out.println("Connexion à la base de données réussie !");
        } else {
            System.out.println("Échec de la connexion à la base de données.");
        }


    }
}
