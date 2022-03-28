package ReBack.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @Column(name = "pay_code")
    public String payCode;
    @Column(name = "pay_time")
    public String payTime;
    @Column(name = "pay_point")
    public String payPoint;
    @Column(name = "pay_amount")
    public String payAmount;
    @Column(name = "pay_validity")
    public String payValidity;
    @Column(name = "pay_payment_method")
    public String payPaymentMethod;

    public Pay(){

    }
    //후원내역코드
//    @ManyToOne(targetEntity = Product.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_code")
//    private Product product;
}
