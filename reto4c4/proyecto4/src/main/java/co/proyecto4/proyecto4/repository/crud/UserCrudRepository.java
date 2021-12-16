package co.proyecto4.proyecto4.repository.crud;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.proyecto4.proyecto4.model.User;

/**
 *
 * @author karent_saenz
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();
   
}
