package com.sabora.server.ConfigTest;

import com.sabora.server.Configuration.EncryptionConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
public class EncryptionConfigTest {
    
    @Autowired
    private EncryptionConfig encryptionConfig;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("encryption.key", () -> "test-encryption-secret-key-config-sabora");
    }

    @Test
    public void testEncryptionConfig() {
        assert(encryptionConfig.getSecretKey().equals("test-encryption-secret-key-config-sabora"));
    }
}
