package ReBack.core.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orderlist")
public class OrderList {
    @Id
    @Column(name = "orderlist_code")
    public String orderlistCode;
    @Column(name = "orderlist_count")
    public Number orderlistCount;
    @Column(name = "orderlist_amoubt")
    public Number orderlistAmount;
    @Column(name = "orderlist_mileage_point")
    public Number orderlistMileagePoint;
    @Column(name = "orderlist_purchase_status")
    public String orderlistPurchaseStatus;
    @Column(name="orderlist_review_point")
    public Number orderlistReviewPoint;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_code")
    private List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orderform_code")
    private List<OrderForm> orderforms = new ArrayList<>();

    public OrderList(){

    }

}
