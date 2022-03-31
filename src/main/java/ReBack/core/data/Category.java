package ReBack.core.data;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @SequenceGenerator(name = "category_seq_generator",
            sequenceName = "category_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_generator")
    private Long CategoryCode;

    @Column(length=30, nullable = false)
    private String CategoryName;
}
