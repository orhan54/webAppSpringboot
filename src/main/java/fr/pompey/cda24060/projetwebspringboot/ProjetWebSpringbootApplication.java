package fr.pompey.cda24060.projetwebspringboot;

import fr.pompey.cda24060.projetwebspringboot.config.CustomProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjetWebSpringbootApplication {

    @Autowired
    private CustomProperty props;

    public static void main(String[] args) {
        SpringApplication.run(ProjetWebSpringbootApplication.class, args);
    }

//    public void run(String... args) throws Exception {
//        System.out.println("API URL: " + this.props.getApiURL());
//    }

}
