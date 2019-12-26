package com.ajman.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ajman.entity.AjmanpaywalletTransactionaudit;

@Repository
public interface AjmanPayRepo extends
		JpaRepository<AjmanpaywalletTransactionaudit, Serializable> {

	AjmanpaywalletTransactionaudit save(AjmanpaywalletTransactionaudit ajmanBean);
	
	AjmanpaywalletTransactionaudit findByTransactionid(String transactionId);
	
	AjmanpaywalletTransactionaudit findByTransactionUpdatedDateAfter(Timestamp date);
	
	List<AjmanpaywalletTransactionaudit> findByPayfortResponseCodeAndTransactionStatusAndTransactionUpdatedDateAfter(String responseCode,String status,Timestamp time);

	// AjmanpayTransactionaudit findBySmartPassUUID(String smartPassUUID);


}
