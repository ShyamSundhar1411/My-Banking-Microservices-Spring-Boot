package com.bank.accounts.repository;

import com.bank.accounts.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity,Long> {
    Optional<AccountsEntity> findByCustomerId(Long customerId);
}
