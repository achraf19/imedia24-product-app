package achraf.project.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import achraf.project.product.model.Product;
import achraf.project.product.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

    private @Autowired ProductService PS;
    
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() { return PS.findProducts(); }

    @GetMapping("/info/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) { 
        return ResponseEntity.ok().body(PS.findProductByName(name));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<?>> getProductsByCategory(@PathVariable String category) { 
        return PS.findProductsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) { 
        return PS.addProduct(product);
    }

    @PutMapping("/update/{ID}")
    public ResponseEntity<?> updateProduct(@PathVariable String ID, @RequestBody Product product) { 
        return PS.updateProduct(ID, product);
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<?> deleteProduct(@PathVariable String ID) { 
        return PS.deleteProduct(ID);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAll() { 
        return PS.deleteProducts();
    }



    



    
}

