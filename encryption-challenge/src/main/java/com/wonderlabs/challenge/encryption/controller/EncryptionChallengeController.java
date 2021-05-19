package com.wonderlabs.challenge.encryption.controller;

import com.wonderlabs.challenge.encryption.model.EncryptionChallengeResponse;
import com.wonderlabs.challenge.encryption.service.EncryptionChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api")
public class EncryptionChallengeController {

    @Autowired
    EncryptionChallengeService encryptionChallengeService;

    /***
     * This is controller for encryption handling request
     * @param data
     * @return
     */
    @PostMapping(value = "/encrypt")
    public ResponseEntity<?> challengeController
    (@Valid @NotBlank @RequestParam(name = "data") String data) {
        return new ResponseEntity<>(encryptionChallengeService.encrypt(data), HttpStatus.OK);
    }

}
