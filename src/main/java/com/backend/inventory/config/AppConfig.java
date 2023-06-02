package com.backend.inventory.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    /**
     * This function creates a new JdbcTemplate object and passes it the
     * HikariDataSource object that was created in the previous function.
     *
     * @param hikariDataSource This is the HikariDataSource bean that we created
     * earlier.
     * @return A JdbcTemplate object.
     */
    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
        return new JdbcTemplate(hikariDataSource);
    }
}
