package ReBack.core.data;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    @Column(name = "category_code")
    public String categoryCode;
    @Column(name = "category_name")
    public String categoryName;

    public Category(){

    }

}
