package com.ajman.ajmapayscheduletask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ajman.dao.AjmanPayRepo;
import com.ajman.entity.AjmanpaywalletTransactionaudit;

@Component
public class HelperService {

	@Autowired
	private AjmanPayRepo ajmanPayRepo;

	final String STAGING_CHECKSTATUS_URL = "https://stapi.ajman.ae/ajman/uat/v01/receiptStatusInquiry/SC/referencenumber/";
	final String STAGING_CHARGEWALLET_URL = "https://stapi.ajman.ae/ajman/uat/v01/chargeEwallet";
	final String STAGING_ENCRYPT_URL = "https://stapi.ajman.ae/ajman/uat/v01/restservices/mobile/AES/Encrypt";

	public void callCheckStausAjmanPay(AjmanpaywalletTransactionaudit ajmanpaywalletTransactionaudit) {

		if (ajmanpaywalletTransactionaudit.getCustomerLanguage() == null) {
			ajmanpaywalletTransactionaudit.setCustomerLanguage("en");
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("x-ibm-client-id", "372767e6-5ae8-46f8-8f5e-3d727ffce2ba");
		headers.add("x-ibm-client-secret", "W1uL7hH0bR2nM0mM6fB8rS5eK1nY8tV3xO0yL7gW2cA0jO7fA3");
		headers.add("Accept-Language", ajmanpaywalletTransactionaudit.getCustomerLanguage());
		headers.add("Authorization", "Basic REVEOkRlZHBhc3MxMjM=");

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String CHECK_STATUS_URL = STAGING_CHECKSTATUS_URL + ajmanpaywalletTransactionaudit.getReferenceNumber();

		ResponseEntity<String> responseEntity = null;

		try {
			RestTemplate restTemplate = new RestTemplate();

			System.out.println("URL to checkStatus ---" + CHECK_STATUS_URL);

			responseEntity = restTemplate.exchange(CHECK_STATUS_URL, HttpMethod.GET, entity, String.class);

			JSONObject jsonObject = new JSONObject(responseEntity.getBody());
			int paymentStatus = jsonObject.getInt("Status");
			String receiptNumber = jsonObject.getString("receiptNumber");

			System.out.println("status value from response ---" + paymentStatus);

			if (paymentStatus == 1) {
				// then update in DB - this is only testing ideally this should
				// in else
				chargeEwalletService(ajmanpaywalletTransactionaudit);
			} else {
				// call the charge ewallet service
				ajmanpaywalletTransactionaudit.setExtraFeild1(receiptNumber);
				ajmanpaywalletTransactionaudit.setTransactionStatus("SUCCESS");
				saveOrUpdateTransaction(ajmanpaywalletTransactionaudit);
			}
		} catch (Exception e) {
			System.out.println("Error in check status ::" + e);
		}

	}

	private void chargeEwalletService(AjmanpaywalletTransactionaudit ajmanpaywalletTransactionaudit) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
		headers.add("x-ibm-client-id", "0415939e-e480-438a-be42-3c32f56dd086");
		headers.add("x-ibm-client-secret", "vA8eX7aP7rW8bD5wQ1oI6yR6cM3lF4oI6gQ6nS7sC4yH5bU5pO");
		headers.add("Accept-Language", ajmanpaywalletTransactionaudit.getCustomerLanguage());
		headers.add("id","2647A9704FCAED96AA325EF461A01070");
		headers.add("Authorization", "Basic QURHQ2hhbm5sczpAcHAmUDBydGEhMTg=");
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String body = "amount=252.5000&transactionId=83293";
				//+ ajmanpaywalletTransactionaudit.getTransactionid();
		
		System.out.println("body --" + body);

		HttpEntity formEntity = new HttpEntity<String>(body, headers);

		ResponseEntity<String> responseEntity = null;

		try {
			RestTemplate restTemplate = new RestTemplate();

			responseEntity = restTemplate.exchange("https://stapi.ajman.ae/ajman/uat/v01/chargeEwallet", HttpMethod.POST, formEntity, String.class);

			System.out.println("body from response ---" + responseEntity.getBody());

//			JSONObject jsonObject = new JSONObject(responseEntity.getBody());
//
//			int responseCode = jsonObject.getInt("code");
//			String receiptNo = jsonObject.getString("receipt_no");
//			String responseMessage = jsonObject.getString("message");
//
//			System.out.println("body from response ---" + responseCode);
//			System.out.println("body from response ---" + receiptNo);
//			System.out.println("body from response ---" + responseMessage);
//
//			if (responseCode == 100) {
//				// update the transaction status as success
//				ajmanpaywalletTransactionaudit.setTransactionStatus("SUCCESS");
//				ajmanpaywalletTransactionaudit.setEntityResponseMessage(responseMessage);
//				ajmanpaywalletTransactionaudit.setExtraFeild1(receiptNo);
//				saveOrUpdateTransaction(ajmanpaywalletTransactionaudit);
//			}

		} catch (Exception e) {
			System.out.println("Error in charge ewallet ::" + e);
		}
	}

	private String encryptData(String language, String eid) {

		String encryptedId = "";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("x-ibm-client-id", "0415939e-e480-438a-be42-3c32f56dd086");
		headers.add("x-ibm-client-secret", "vA8eX7aP7rW8bD5wQ1oI6yR6cM3lF4oI6gQ6nS7sC4yH5bU5pO");
		headers.add("Accept-Language", language);
		headers.add("Authorization", "Basic QURHQ2hhbm5sczpAcHAmUDBydGEhMTg=");

		Map<String, String> map = new HashMap();
		map.put("id", eid);
		map.put("type", "RESIDENT");

		HttpEntity<?> entity = new HttpEntity<>(map, headers);

		ResponseEntity<String> responseEntity = null;

		try {
			RestTemplate restTemplate = new RestTemplate();
			responseEntity = restTemplate.exchange(STAGING_ENCRYPT_URL, HttpMethod.POST, entity, String.class);
			JSONObject jsonObject = new JSONObject(responseEntity.getBody());
			encryptedId = jsonObject.getString("id");
		} catch (Exception e) {
			System.out.println("Error in Encrypt data ::" + e);
		}
		return encryptedId;
	}

	private void saveOrUpdateTransaction(AjmanpaywalletTransactionaudit ajmanpaywalletTransactionaudit) {
		ajmanPayRepo.save(ajmanpaywalletTransactionaudit);
	}
}
