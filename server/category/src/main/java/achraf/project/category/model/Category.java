package achraf.project.category.model;

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
@TypeAlias("category")
@Document(collection = "category")
public class Category {
    
    @Id 
    private String ID = UUID.randomUUID().toString();
    private String name;

    
    
    
}
