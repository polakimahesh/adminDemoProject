package com.dashboard.Admin.Dashboard.subReseller;

import com.dashboard.Admin.Dashboard.reseller.Reseller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubResellerRepository extends JpaRepository<SubResellers, Integer> {
    List<SubResellers> findAllByOrderByIdAsc();
}
