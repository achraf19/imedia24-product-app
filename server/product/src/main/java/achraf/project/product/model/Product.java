package achraf.project.product.model;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("product")
@Document(collection = "product")
public class Product {

    private @Id String ID = UUID.randomUUID().toString();
    private String name;
    private String price;
    private String currency;
    private int quantity;
    private String category;
    private String description;
    
    
}
