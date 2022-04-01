package ReBack.core.data;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_code", length = 15)
    public Long memberCode;

    @Id
    @Column(name = "member_id", length = 15)
    private String memberId;

    @Column(name = "member_name", length = 10)
    private String name1;

    @Column(name = "member_password", length = 60)
    private String memberPassword;

    @Column(name = "member_email", length = 50)
    private String email;

    @Column(name = "member_phonenumber", length = 11)
    private String phonenumber;

    @Column(name = "member_postalCode", length = 10)
    private String postalCode;

    @Column(name = "member_address", length = 255)
    private String address;

    @Column(name = "member_point", length = 7)
    private String point;

    @Column(name = "member_howjoin", length = 1)
    private String howjoin;

    @Column(name = "member_withdrawal", length = 30)
    private String withdrawal;

    @Column(name = "mebmer_business_number", length = 10)
    private String businessnumber;

    @Column(name = "member_type", length = 1)
    private String type;


    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name1;
    }

    public void setName(String name) {
        this.name1 = name;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getHowjoin() {
        return howjoin;
    }

    public void setHowjoin(String howjoin) {
        this.howjoin = howjoin;
    }

    public String getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(String withdrawal) {
        this.withdrawal = withdrawal;
    }

    public String getBusinessnumber() {
        return businessnumber;
    }

    public void setBusinessnumber(String businessnumber) {
        this.businessnumber = businessnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
