package achraf.project.category.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import achraf.project.category.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    
    Optional<Category> findCategoryByName(String name);

}
