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

    public User getUser(Integer id_users) {
        // appel au repository
        return  userRepository.getUser(id_users);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.getUsers();
    }

    public void deleteUser(final Integer id_users) {
        userRepository.deleteUser(id_users);
    }

    public User saveUser(User user) {
        User saved;
        // System.out.println(person.toString());
        // Regle de gestion : Le nom de famille doit etre mis en majuscule.
        user.setUserLastName(user.getUserLastName().toUpperCase());

        if(user.getId_users() == null) {
            // Si l'id est nul, alors c'est un nouvel employe.
            saved = userRepository.createUser(user);
        } else {
            saved = userRepository.updateUser(user);
        }
        return saved;

    }

}
