package achraf.project.category.controller;

import javax.validation.Valid;

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

import achraf.project.category.model.Category;
import achraf.project.category.service.CategoryService;

@Controller
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("category")
public class CategoryController {
    
    @Autowired private CategoryService CS;

    @GetMapping("/all")
    ResponseEntity<?> findCategories() {
        return this.CS.getCategories();
    }

    @PostMapping("/add")
    ResponseEntity<?> addCategory(@RequestBody Category category) {
        return this.CS.addCategory(category);
    }

    @PutMapping("/update")
    ResponseEntity<?> updateCategory(@PathVariable @Valid String id, @RequestBody Category category) {
        return this.CS.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<?> deleteProduct(@PathVariable String ID) { 
        return CS.deleteCategory(ID);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAll() { 
        return CS.deleteCategories();
    }

}
