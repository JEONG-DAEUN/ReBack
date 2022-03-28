package ReBack.core.data;

import lombok.*;
import javax.persistence.*;


@Entity
//@Table(name="tbl_member")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
}
