package ReBack.core.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orderform")
public class OrderForm {
    @Id
    @Column(name = "orderform_code")
    public String orderformCode;
    @Column(name = "orderform_pay_total_amount")
    public Number orderformPayTotalAmount;
    @Column(name = "orderform_state")
    public String orderformState;
    @Column(name = "orderform_request")
    public String orderformRequest;
    @Column(name = "orderform_receiver_address")
    public String orderformReceiverAddress;
    @Column(name = "orderform_receiver_name")
    public String orderformReceiverName;
    @Column(name = "orderform_receiver_phone_num")//orderform_receiver_phone_number -> orderform_receiver_phone_num
    public String orderformReceiverPhoneNum;
    @Column(name = "orderform_delivery_status")
    public String orderformDeliveryStatus;
    @Column(name = "delivery_company_information") //orderform_delivery_company_information 였는데 식별자가 길어서 줄임
    public String DeliveryCompanyInformation;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pay_code")
    private List<Pay> pays = new ArrayList<>();

    public OrderForm(){

    }
    //회원코드
//    @ManyToOne(targetEntity = Pay.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "pay_code")
//    private Pay pay;

    //디자인코드
//    @ManyToOne(targetEntity = Pay.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "pay_code")
//    private Pay pay;
}
