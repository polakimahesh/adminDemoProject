package com.dashboard.Admin.Dashboard.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByUserId_Id(int id);

    @Query("select sum(t.amount) from Transaction t ")
    Long   findByAmount();
}
