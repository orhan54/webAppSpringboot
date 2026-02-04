package fr.pompey.cda24060.projetwebspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private Integer id_users;

    @JsonProperty("user_first_name")
    private String userFirstName;

    @JsonProperty("user_last_name")
    private String userLastName;

}
