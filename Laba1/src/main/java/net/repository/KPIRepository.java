package net.repository;

import net.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KPIRepository extends JpaRepository<KPI, Long> {
}
