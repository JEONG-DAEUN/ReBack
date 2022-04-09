package ReBack.core.repository;

import ReBack.core.data.FinancialSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinancialSupportRepository extends JpaRepository<FinancialSupport, Long> {
    @Query("FROM FinancialSupport e")
    List<FinancialSupport> getAllFinancialSupportData();
}