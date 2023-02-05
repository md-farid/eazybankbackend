package com.teamwebsoft.repositories;

import com.teamwebsoft.models.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions,Long> {
    List<AccountTransactions> findByCustomerIdOrderByTransactionsDtDesc(long customerId);
}
