package fr.pompey.cda24060.projetwebspringboot.model;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Model Tests")
@Feature("User Model")
class UserTest {

    @Test
    @Story("Create User")
    @Description("Test de création d'un utilisateur et vérification des getters/setters")
    void testUserCreation() {

        User user = new User();
        user.setId_users(1);
        user.setUser_first_name("Jean");
        user.setUser_last_name("Dupont");

        assertEquals(1, user.getId_users());
        assertEquals("Jean", user.getUser_first_name());
        assertEquals("Dupont", user.getUser_last_name());
    }
}
