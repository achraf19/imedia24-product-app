package achraf.project.category.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bouncycastle.asn1.ocsp.ResponderID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import achraf.project.category.exception.CategoryConflictException;
import achraf.project.category.exception.CategoryNotFoundException;
import achraf.project.category.model.Category;
import achraf.project.category.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired private CategoryRepository CR;
    Map<String, Boolean> response = new HashMap<String, Boolean>();

    // method find all categories
    public ResponseEntity<List<Category>> getCategories() {
         return ResponseEntity.ok().body(CR.findAll());
    }

    // method find category by name
    public boolean findCategoryByName(Category category) {
        return CR.findCategoryByName(category.getName()).isPresent();
                         
    }

    // method add new category
    public ResponseEntity<?> addCategory(Category category) {
        // invoke find category by name method to check if category already exists !
        if(findCategoryByName(category)) 
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new CategoryConflictException("this category already exists !"));

        CR.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("this category is added succesfully !");

    }

    // method update a category
    public ResponseEntity<?> updateCategory(String id, Category category) {
        
        if(CR.findById(id).isPresent()) {
          CR.save(category);
          return ResponseEntity.status(HttpStatus.OK).body("The category "+ category.getName() +"was updated succesfully !");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CategoryNotFoundException("This category that you attempt to update does not exist in DB !"));
    }

    // method deletes an existing product
    public ResponseEntity<?> deleteCategory(String ID) {

        try {
            CR.deleteById(ID);
            return ResponseEntity.status(HttpStatus.OK).body("The category with ID= "+ ID + "was successfully deleted !");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server occurs while deleting the category with ID= "+ ID);

        }    
    
}

    // method deletes all categories
    public ResponseEntity<?> deleteCategories() {

        try {
            CR.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body("All categories were successfully deleted !");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server occurs while deleting all the categories");

        }    

    }

}
