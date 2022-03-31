package ReBack.core.data;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @SequenceGenerator(name = "product_seq_generator",
            sequenceName = "product_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    private Long productCode;

    @Column(nullable = false, name="product_information")
    private String productInfo;

    @Column(nullable = false, length=50)
    private String productName;

    @Column(nullable = false, length=8)
    private int productPrice;
    
    @Column(nullable = false)
    private String productFileName;

    @Column(nullable = false)
    private String productFilePath;

    @ManyToOne
    @JoinColumn(name="member_code")
    private Member member;

    @ManyToOne
    @JoinColumn(name="category_code")
    private Category category;

    @ManyToOne
    @JoinColumn(name="material_code")
    private Material material;

}
