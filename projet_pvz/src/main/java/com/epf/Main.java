package com.epf;
import com.epf.Persistance.config;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;


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
