package ru.succulentum.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "services")
@Getter
@Setter
public class ServicesUrlConfig {
    private String collectionServiceUrl;
    private String usersServiceUrl;
}
