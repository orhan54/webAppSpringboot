package fr.pompey.cda24060.projetwebspringboot.repository;

import fr.pompey.cda24060.projetwebspringboot.config.CustomProperty;
import fr.pompey.cda24060.projetwebspringboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class UserRepository {

    @Autowired
    private CustomProperty customProperty;

    public Iterable<User> getUsers() {
        // récupération de ma proprietes contenant l'url de l'API
        String baseURL = customProperty.getApiURL();
        // construction de l'url pour appel à l'API
        String getPersonsURL = baseURL + "/users";
        // construction de la requete HTTP
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
                getPersonsURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        log.debug("Get Users call {}", response.getStatusCode());
        // envoi de la reponse.
        return response.getBody();
    }

    public User getUser(int id_user) {
        String baseURL = customProperty.getApiURL();
        String getUserURL = baseURL + "/users/" + id_user;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(
                getUserURL,
                HttpMethod.GET,
                null,
                User.class
                );

        log.debug("Get user call {}", response.getStatusCode());

        return response.getBody();
    }

    public User updateUser(User user) {
        String baseApiURL = customProperty.getApiURL();
        String updateUserURL = baseApiURL + "/users/" + user.getId_users();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.exchange(
                updateUserURL,
                HttpMethod.PUT,
                request,
                User.class);

        log.debug("Update user call {}", response.getStatusCode());

        return response.getBody();
    }

    public User createUser(User user) {
        String baseApiURL = customProperty.getApiURL();
        String createUserURL = baseApiURL + "/users";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.exchange(
                createUserURL,
                HttpMethod.POST,
                request,
                User.class);

        log.debug("Create user call {}", response.getStatusCode());

        return response.getBody();
    }

    public void deleteUser(int id_user) {
        String baseApiURL = customProperty.getApiURL();
        String deleteUserURL = baseApiURL + "/users/" + id_user;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteUserURL,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete user call {}", response.getStatusCode());
    }


}
