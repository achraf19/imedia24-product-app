package achraf.project.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import achraf.project.product.exception.ProductConflictException;
import achraf.project.product.exception.ProductNotFoundException;
import achraf.project.product.model.Product;
import achraf.project.product.repository.ProductRepository;

@Service
public class ProductService {

    private @Autowired ProductRepository PR;
    
    // method returns all products
    public ResponseEntity<List<Product>> findProducts() {
        return ResponseEntity.ok().body(PR.findAll());
    }
    // method returns product by name
    public ResponseEntity<?> findProductByName(String product) {
        if(PR.findByName(product).isPresent()){ return ResponseEntity.ok(PR.findByName(product).get()); }
        return ResponseEntity.ok(new ProductNotFoundException("This product does not exists !"));
    }
    // method returns products by category
    public ResponseEntity<List<?>> findProductsByCategory(String category) {
        if(PR.findByCategory(category).isEmpty()) throw new ProductNotFoundException("No product found for this category !");
        return ResponseEntity.ok().body(PR.findByCategory(category).get());
    }

    // method returns a product info by name
    public boolean CheckIfProductExists(String product) {
        return PR.findByName(product).isPresent();
                         
    }
    // method creates new product and then save it
    public ResponseEntity<?> addProduct(Product product) {
         // invoke find product by name method to check if product already exists !
         if(CheckIfProductExists(product.getName())) 
         return ResponseEntity.status(HttpStatus.CONFLICT).body(new ProductConflictException("this product already exists !"));

         PR.save(product);
         return ResponseEntity.status(HttpStatus.CREATED).body("this product is added succesfully !");
    }
}
