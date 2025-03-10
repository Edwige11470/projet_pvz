package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class config {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Configuration de la connexion à la base de données MySQL
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");
        dataSource.setUsername("epf");
        dataSource.setPassword("epf");

        return dataSource;
    }

    // Configuration du JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public boolean testDatabaseConnection() {
        try {
            // Effectuer une requête simple pour vérifier la connexion
            String sql = "SELECT 1";
            jdbcTemplate().queryForObject(sql, Integer.class);
            return true; // Connexion réussie
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Échec de la connexion
        }
    }
}
