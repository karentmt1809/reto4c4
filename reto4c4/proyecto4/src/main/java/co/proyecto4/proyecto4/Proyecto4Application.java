package co.proyecto4.proyecto4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.proyecto4.proyecto4.repository.crud.FraganceCrudRepository;
import co.proyecto4.proyecto4.repository.crud.OrderCrudRepositorry;
import co.proyecto4.proyecto4.repository.crud.UserCrudRepository;

/**
 *
 * @author karent_saenz
 */
@SpringBootApplication
public class Proyecto4Application implements CommandLineRunner {

	@Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;
    
    @Autowired
    private OrderCrudRepositorry orderCrudRepository;


	public static void main(String[] args) {
		SpringApplication.run(Proyecto4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
        fraganceCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
		
	}

}
