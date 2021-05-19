package com.wonderlabs.challenge.encryption.service;

import com.wonderlabs.challenge.encryption.model.EncryptionChallengeResponse;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EncryptionChallengeServiceImplTest {

    @Mock
    private StringEncryptor encryptor;

    @InjectMocks
    EncryptionChallengeServiceImpl encryptionChallengeService;

    @BeforeEach
    void setUp() {
        when(encryptor.encrypt(any() )).thenReturn("sadfsddsakfjdsgg");
        Resource resource = new ClassPathResource("encrypt.properties");
        ReflectionTestUtils.setField(encryptionChallengeService, "resourceFile", resource);
    }

    @Test
    void testEncrypt() {
        EncryptionChallengeResponse response = encryptionChallengeService.encrypt("test");
        assertEquals("sadfsddsakfjdsgg", response.getEncryptedData());
    }


}