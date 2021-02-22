package achraf.project.product.service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import achraf.project.product.service.Category;

@FeignClient(name = "category-service", url = "localhost:8070")
public interface CategoryFeignProxy {
    
    ResponseEntity<List<Category>> getCategories();
}
