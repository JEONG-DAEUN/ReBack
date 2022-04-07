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

    @Column(length=30, nullable = false)
    private String memberPassword;

    @Column(length=50, nullable = false)
    private String memberEmail;

    @Column(length=11, nullable = false)
    private String memberPhoneNumber;

    @Column(length=10, nullable = false)
    private int memberPostalCode;

    @Column(nullable = false)
    private String memberAddress;

    @Column(length=10)
    private int memberPoint;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberHowJoin memberHowJoin;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberWithdrawal memberWithdrawal;

    @Column(length=10)
    private int memberBusinessNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(nullable = false)
    private LocalDateTime memberJoinDate;

}
