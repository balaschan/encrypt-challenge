package com.wonderlabs.challenge.encryption.service;

import com.wonderlabs.challenge.encryption.model.EncryptionChallengeResponse;

public interface EncryptionChallengeService {

    public EncryptionChallengeResponse encrypt(String encryptText);
}
