package co.proyecto4.proyecto4.repository.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.proyecto4.proyecto4.model.Fragance;

/**
 *
 * @author karent_saenz
 */
public interface FraganceCrudRepository extends MongoRepository<Fragance, String>{
    public List<Fragance> findByPriceLessThanEqual(double precio);
    
}
