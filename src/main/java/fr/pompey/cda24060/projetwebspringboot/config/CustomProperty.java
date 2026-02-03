package fr.pompey.cda24060.projetwebspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fr.pompey.cda24060.projetwebspringboot")
@Data
public class CustomProperty {

    private String apiURL;
}
