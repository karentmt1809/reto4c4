package co.proyecto4.proyecto4.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.proyecto4.proyecto4.model.User;
import co.proyecto4.proyecto4.repository.UserRepository;

/**
 *
 * @author karent_saenz
 */
@Service
public class UserService {
    @Autowired
    /**
     * Atributo de tipo UserRepository
     */
    private UserRepository repositorio;
    
    /**
     * Metodo para tener el id del usuario
     */
    public Optional<User> getUser(int id_user) {
        return repositorio.getUser(id_user);
    }
    /**
     * Metodo para traer todos los usuarios 
     */
    public List<User> listAll() {
        return repositorio.listAll();
    }
    /**
     * Metodo para verificar si el correo existe
     */
    public boolean emailExists(String email) {
        return repositorio.emailExists(email);
    }
    /**
     * Metodo para realizar la autenticacion del usuario
     */
    public User autenticateUser(String email, String password) {
        /***
         * Objeto de tipo Optional
         */
        Optional<User> usuario = repositorio.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    /**
     * Metodo para crear un nuevo usuario
     */
    public User create(User user) {
        /**
         * Objeto optional de tipo User
         */
        Optional<User> userIdMaximo;
        
        if (user.getId() == null) {
            
            userIdMaximo = repositorio.lastUserId();
            
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        /**
         * Objeto optional de tipo User
         */
        Optional<User> user_n = repositorio.getUser(user.getId());
        if (user_n .isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return repositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    /**
     * Metodo que permite actualizar un usuario
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                repositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
     * Metodo para eliminar un usuario segun el id 
     * @param userId
     * @return
     */
    public boolean delete(int userId) {
        Optional<User> usuario = getUser(userId);
        
        if (usuario.isEmpty()){
            return false;
        }else{
            repositorio.delete(usuario.get());
            return true;
        }
    }
}


