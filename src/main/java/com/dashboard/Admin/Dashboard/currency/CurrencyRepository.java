package com.dashboard.Admin.Dashboard.currency;

import com.dashboard.Admin.Dashboard.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    List<Currency> findAllByOrderByIdAsc();

}
