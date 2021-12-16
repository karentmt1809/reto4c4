package co.proyecto4.proyecto4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.proyecto4.proyecto4.model.User;
import co.proyecto4.proyecto4.repository.crud.UserCrudRepository;

/**
 *
 * @author karent_saenz
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public List<User> listAll() {
        return userCrudRepository.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    public User update(User user) {
        return userCrudRepository.save(user);
    }
    
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
     
}
