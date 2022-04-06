package ReBack.core.data;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @SequenceGenerator(name = "member_seq_generator",
            sequenceName = "member_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long memberCode;

    @Column(length=30, nullable = false)
    private String memberId;

    @Column(length=10, nullable = false)
    private String memberName;

<<<<<<< Updated upstream
    @Column(length=30, nullable = false)
=======
    @Column(nullable = false)
>>>>>>> Stashed changes
    private String memberPassword;

    @Column(length=50, nullable = false)
    private String memberEmail;
<<<<<<< Updated upstream

    @Column(length=11, nullable = false)
    private String memberPhoneNumber;

    @Column(length=10, nullable = false)
    private int memberPostalCode;

    @Column(nullable = false)
    private String memberAddress;

    @Column(length=10)
    private int memberPoint;

    @Column(length=20)
    private MemberHowJoin memberHowJoin;

    @Column(length=30)
    private MemberWithdrawal memberWithdrawal;

    @Column(length=10, nullable = false)
    private int memberBusinessNumber;

    @Column(length=20, nullable = false)
    private  MemberType memberType;

    @Column(nullable = false)
    private LocalDateTime memberJoinDate;
=======

    @Column(length=11, nullable = false)
    private String memberPhoneNumber;

    @Column(length=10, nullable = false)
    private int memberPostalCode;

    @Column(nullable = false)
    private String memberAddress;

    @Column(length=10)
    private int memberPoint;

    @Column(length=20)
    private MemberHowJoin memberHowJoin;

    @Column(length=30)
    private MemberWithdrawal memberWithdrawal;

    @Column(length=10, nullable = false)
    private int memberBusinessNumber;

    @Column(length=20, nullable = false)
    private  MemberType memberType;

    @Column(nullable = false)
    private LocalDateTime memberJoinDate;

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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    public int getMemberPostalCode() {
        return memberPostalCode;
    }

    public void setMemberPostalCode(int memberPostalCode) {
        this.memberPostalCode = memberPostalCode;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public int getMemberPoint() {
        return memberPoint;
    }

    public void setMemberPoint(int memberPoint) {
        this.memberPoint = memberPoint;
    }

    public MemberHowJoin getMemberHowJoin() {
        return memberHowJoin;
    }

    public void setMemberHowJoin(MemberHowJoin memberHowJoin) {
        this.memberHowJoin = memberHowJoin;
    }

    public MemberWithdrawal getMemberWithdrawal() {
        return memberWithdrawal;
    }

    public void setMemberWithdrawal(MemberWithdrawal memberWithdrawal) {
        this.memberWithdrawal = memberWithdrawal;
    }

    public int getMemberBusinessNumber() {
        return memberBusinessNumber;
    }

    public void setMemberBusinessNumber(int memberBusinessNumber) {
        this.memberBusinessNumber = memberBusinessNumber;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public LocalDateTime getMemberJoinDate() {
        return memberJoinDate;
    }

    public void setMemberJoinDate(LocalDateTime memberJoinDate) {
        this.memberJoinDate = memberJoinDate;
    }

    public void put(String to, String phoneNumber) {
    }
>>>>>>> Stashed changes
}
