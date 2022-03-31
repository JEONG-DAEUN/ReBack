package ReBack.core.data;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @SequenceGenerator(name = "material_seq_generator",
            sequenceName = "material_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq_generator")
    private Long materialCode;

    @Column(length=30, nullable = false)
    private String materialName;

}

