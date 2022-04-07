package ReBack.core.dto;

import ReBack.core.data.Category;
import ReBack.core.data.Design;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@DataAmount
public class DesignDTO {
    private String designName;
    private String designEx;
    private Category category;
    private String designImagePath;
    private LocalDateTime designDate;
}
