package ci.influo.fimoevents.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
    "app.cors.allowed-origins=http://localhost:3000,http://localhost:3001",
    "app.cors.allowed-methods=GET,POST,PUT,DELETE",
    "app.cors.allowed-headers=*",
    "app.cors.allow-credentials=true"
})
class CorsConfigTest {

    @Autowired
    private CorsConfigurationSource corsConfigurationSource;

    @Test
    void testCorsConfiguration() {
        CorsConfiguration config = corsConfigurationSource.getCorsConfiguration(null);
        
        assertNotNull(config);
        assertTrue(config.getAllowedOriginPatterns().contains("http://localhost:3000"));
        assertTrue(config.getAllowedOriginPatterns().contains("http://localhost:3001"));
        assertTrue(config.getAllowedMethods().contains("GET"));
        assertTrue(config.getAllowedMethods().contains("POST"));
        assertTrue(config.getAllowedMethods().contains("PUT"));
        assertTrue(config.getAllowedMethods().contains("DELETE"));
        assertTrue(config.getAllowCredentials());
        assertTrue(config.getAllowedHeaders().contains("*"));
    }

    @Test
    void testExposedHeaders() {
        CorsConfiguration config = corsConfigurationSource.getCorsConfiguration(null);
        
        assertTrue(config.getExposedHeaders().contains("Authorization"));
        assertTrue(config.getExposedHeaders().contains("Content-Type"));
        assertTrue(config.getExposedHeaders().contains("X-Requested-With"));
    }
} 