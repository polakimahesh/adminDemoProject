package com.dashboard.Admin.Dashboard.reseller;

import com.dashboard.Admin.Dashboard.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller,Integer> {
    List<Reseller> findAllByOrderByIdAsc();
}
