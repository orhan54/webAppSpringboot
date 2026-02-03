package fr.pompey.cda24060.projetwebspringboot.service;

import fr.pompey.cda24060.projetwebspringboot.model.User;
import fr.pompey.cda24060.projetwebspringboot.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id_user) {
        // appel au repository
        return  userRepository.getUser(id_user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.getUsers();
    }

    public void deleteUser(final Integer id_user) {
        userRepository.deleteUser(id_user);
    }

    public User saveUser(User user) {
        User saved;
        // System.out.println(person.toString());
        // Regle de gestion : Le nom de famille doit etre mis en majuscule.
        user.setUser_last_name(user.getUser_last_name().toUpperCase());

        if(user.getId_users() == null) {
            // Si l'id est nul, alors c'est un nouvel employe.
            saved = userRepository.createUser(user);
        } else {
            saved = userRepository.updateUser(user);
        }
        return saved;

    }

}
