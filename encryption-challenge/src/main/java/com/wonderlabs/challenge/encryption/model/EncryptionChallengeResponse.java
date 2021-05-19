package com.wonderlabs.challenge.encryption.model;

/**
 * Encryption Challenge Response
 */
public class EncryptionChallengeResponse {

    private String request;

    private String encryptedData;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }
}
