package ReBack.core.data;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="refund")
public class Refund {
    @Id
    @Column(name = "refund_code")
    public String refundCode;
    @Column(name = "refund_count")
    public String refundCount;
    @Column(name = "refund_amount")
    public String refundAmount;
    @Column(name = "refund_status")
    public String refundStatus;
    @Column(name = "refund_point")
    public String refundPoint;

    public Refund(){

    }
    //주문항목코드
    @OneToOne
    @JoinColumn(name = "orderList_code")
    private OrderList orderList;


}
