package com.teamwebsoft.repositories;

import com.teamwebsoft.models.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Long> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);
}
