package com.hcl.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.banking.entity.Account;
import com.hcl.banking.dto.StatmentDto;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account findByUserId(Long userId);
	@Query("select new com.hcl.banking.dto.StatmentDto(t.fromAccount.accountNo,t.toAccount.accountNo,t.transcationDate,t.amount,t.transcationType) from Account a , Transcation t where   a.id=t.fromAccount.id and  t.fromAccount.user.id=:userId order by t.id desc ")
	public List<StatmentDto> findLastTransaction(@Param("userId") Long userId);
}
