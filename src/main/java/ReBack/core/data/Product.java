package ReBack.core.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    @Column(name = "product_code")
    public String productCode;
    @Column(name = "product_type")
    public  String productType;
    @Column(name = "product_infomation")
    public  String productInformation;
    @Column(name = "product_stock")
    public Number productStock;
    @Column(name = "product_category_type")
    public String productCategoryType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="category_code")
    private List<Category> categorys = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="material_code")
    private List<Material> materials = new ArrayList<>();

    public Product(){

    }
}
