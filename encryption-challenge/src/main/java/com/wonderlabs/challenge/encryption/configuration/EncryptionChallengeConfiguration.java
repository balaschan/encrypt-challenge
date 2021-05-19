package com.wonderlabs.challenge.encryption.configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Application configuration for encryption challenge
 */
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
@Configuration
@EnableEncryptableProperties
public class EncryptionChallengeConfiguration {

    @Value("${key}")
    private String key;

    @Value("${algorithm}")
    private String algorithm;

    @Bean(name = "encryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor pbEncryptor = new PooledPBEStringEncryptor();
        pbEncryptor.setPoolSize(4);
        pbEncryptor.setPassword(key);
        pbEncryptor.setAlgorithm(algorithm);
        return pbEncryptor;
    }

    /**
     * This bean creation for Swagger implementation
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wonderlabs.challenge.encryption"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Wonderlabs Encryption challenge")
                .description("Wonderlabs Encryption challenge")
                .version("version 1.0")
                .contact(new Contact("Bala", "", "")).build();
    }


}
