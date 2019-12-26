package com.ajman.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * The persistent class for the AJMANPAYWALLET_TRANSACTIONAUDIT database table.
 * 
 */
@Entity
@Table(name = "AJMANPAYWALLET_TRANSACTIONAUDIT")
@NamedQuery(name = "AjmanpaywalletTransactionaudit.findAll", query = "SELECT a FROM AjmanpaywalletTransactionaudit a")
public class AjmanpaywalletTransactionaudit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTIONID")
	private String transactionid;

	@Column(name = "ACCOUNT_STATUS")
	private String accountStatus;

	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;

	@Column(name = "CARD_NUMBER")
	private String cardNumber;

	@Column(name = "CARDTYPE")
	private String cardtype;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@Column(name = "CUSTOMER_DEVICEID")
	private String customerDeviceid;

	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "CUSTOMER_IPADDRESS")
	private String customerIpaddress;

	@Column(name = "CUSTOMER_MOBILENUMBER")
	private String customerMobilenumber;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "EXPIRYDATE")
	private String expirydate;

	@Column(name = "EXTRA_FEILD1")
	private String extraFeild1;

	@Column(name = "EXTRA_FEILD2")
	private String extraFeild2;

	@Column(name = "EXTRA_FEILD3")
	private String extraFeild3;

	@Column(name = "PAYFORT_ID")
	private String payfortId;

	@Column(name = "PAYFORT_RESPONSE_CODE")
	private String payfortResponseCode;

	@Column(name = "PAYFORT_RESPONSE_MESSAGE")
	private String payfortResponseMessage;

	@Column(name = "PAYFORT_PAYMENT_RESPONSE")
	private String payfortPaymentResponse;

	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;

	@Column(name = "REFERENCE_NUMBER")
	private String referenceNumber;

	@Column(name = "SERVICENAME")
	private String servicename;

	@Column(name = "ENTITY_RESPONSE_MESSAGE")
	private String entityResponseMessage;

	@Column(name = "ENTITY_RESPONSE")
	private String entityResponse;

	@Column(name = "ENTITYNAME")
	private String entityName;

	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;

	@Column(name = "TRANSACTION_CREATED_DATE", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp transactionCreatedDate;

	@UpdateTimestamp
	@Column(name = "TRANSACTION_UPDATED_DATE")
	private Timestamp transactionUpdatedDate;

	@Column(name = "TRANSACTION_SOURCE")
	private String transactionSource;

	@Column(name = "TRANSACTION_STATUS")
	private String transactionStatus;

	@Column(name = "WALLETID")
	private String walletid;

	@Column(name = "CUSTOMER_LANGUAGE")
	private String customerLanguage;

	public AjmanpaywalletTransactionaudit() {
	}

	public String getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getCardHolderName() {
		return this.cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCustomerDeviceid() {
		return this.customerDeviceid;
	}

	public void setCustomerDeviceid(String customerDeviceid) {
		this.customerDeviceid = customerDeviceid;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerIpaddress() {
		return this.customerIpaddress;
	}

	public void setCustomerIpaddress(String customerIpaddress) {
		this.customerIpaddress = customerIpaddress;
	}

	public String getCustomerMobilenumber() {
		return this.customerMobilenumber;
	}

	public void setCustomerMobilenumber(String customerMobilenumber) {
		this.customerMobilenumber = customerMobilenumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public String getExtraFeild1() {
		return this.extraFeild1;
	}

	public void setExtraFeild1(String extraFeild1) {
		this.extraFeild1 = extraFeild1;
	}

	public String getExtraFeild2() {
		return this.extraFeild2;
	}

	public void setExtraFeild2(String extraFeild2) {
		this.extraFeild2 = extraFeild2;
	}

	public String getExtraFeild3() {
		return this.extraFeild3;
	}

	public void setExtraFeild3(String extraFeild3) {
		this.extraFeild3 = extraFeild3;
	}

	public String getPayfortId() {
		return this.payfortId;
	}

	public void setPayfortId(String payfortId) {
		this.payfortId = payfortId;
	}

	public String getPayfortResponseCode() {
		return this.payfortResponseCode;
	}

	public void setPayfortResponseCode(String payfortResponseCode) {
		this.payfortResponseCode = payfortResponseCode;
	}

	public String getPayfortResponseMessage() {
		return this.payfortResponseMessage;
	}

	public void setPayfortResponseMessage(String payfortResponseMessage) {
		this.payfortResponseMessage = payfortResponseMessage;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getServicename() {
		return this.servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public BigDecimal getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionSource() {
		return this.transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	public String getTransactionStatus() {
		return this.transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getWalletid() {
		return this.walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}

	public Timestamp getTransactionCreatedDate() {
		return transactionCreatedDate;
	}

	public void setTransactionCreatedDate(Timestamp transactionCreatedDate) {
		this.transactionCreatedDate = transactionCreatedDate;
	}

	public Timestamp getTransactionUpdatedDate() {
		return transactionUpdatedDate;
	}

	public void setTransactionUpdatedDate(Timestamp transactionUpdatedDate) {
		this.transactionUpdatedDate = transactionUpdatedDate;
	}

	public String getPayfortPaymentResponse() {
		return payfortPaymentResponse;
	}

	public void setPayfortPaymentResponse(String payfortPaymentResponse) {
		this.payfortPaymentResponse = payfortPaymentResponse;
	}

	public String getEntityResponseMessage() {
		return entityResponseMessage;
	}

	public void setEntityResponseMessage(String entityResponseMessage) {
		this.entityResponseMessage = entityResponseMessage;
	}

	public String getEntityResponse() {
		return entityResponse;
	}

	public void setEntityResponse(String entityResponse) {
		this.entityResponse = entityResponse;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getCustomerLanguage() {
		return customerLanguage;
	}

	public void setCustomerLanguage(String customerLanguage) {
		this.customerLanguage = customerLanguage;
	}

}