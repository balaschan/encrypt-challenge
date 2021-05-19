package com.wonderlabs.challenge.encryption.service;

import com.wonderlabs.challenge.encryption.exception.EncryptionChallengeException;
import com.wonderlabs.challenge.encryption.model.EncryptionChallengeResponse;
import com.wonderlabs.challenge.encryption.util.FileUtil;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * Encryption Challenge Service
 */
@Service("encryptionChallengeService")
public class EncryptionChallengeServiceImpl implements EncryptionChallengeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionChallengeServiceImpl.class);

    @Value("classpath:encrypt.properties")
    Resource resourceFile;

    @Autowired
    StringEncryptor encryptor;

    public EncryptionChallengeResponse encrypt(final String data) {
        String encryptedData = encryptor.encrypt(data);
        try {
            FileUtil.writeProperty(resourceFile, data, encryptedData);
        } catch (Exception e) {
            LOGGER.error("Exception while writing : {}", e);
            throw new EncryptionChallengeException("error while writing to file", e);
        }
        return createResponse(data, encryptedData);
    }

    public EncryptionChallengeResponse createResponse(String keyData, String encryptData) {
        EncryptionChallengeResponse response = new EncryptionChallengeResponse();
        response.setRequest(keyData);
        response.setEncryptedData(encryptData);
        return response;
    }

}
