package com.ajman.ajmapayscheduletask;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ajman.dao.AjmanPayRepo;
import com.ajman.entity.AjmanpaywalletTransactionaudit;

@Component
public class ScheduledTasks {

	@Autowired
	private AjmanPayRepo ajmanPayRepo;

	@Autowired
	private HelperService helperService;

	@Autowired
	private AppProperties appProperties;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "${scheduling.job.cron}")
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));

		// check if time is blank then take the default value
		

		// 15 min after time
		Timestamp time = new Timestamp(System.currentTimeMillis() +  Long.parseLong(appProperties.getTime()));
		log.info("The time is now {}", time);
		List<AjmanpaywalletTransactionaudit> resultList = ajmanPayRepo
				.findByPayfortResponseCodeAndTransactionStatusAndTransactionUpdatedDateAfter(
						appProperties.getPaymentStatusCode(), appProperties.getTransactionStatus(), time);

		if (resultList != null) {

			for (AjmanpaywalletTransactionaudit ajmanpaywalletTransactionaudit : resultList) {

				System.out.println("Calling check status---");
				helperService.callCheckStausAjmanPay(ajmanpaywalletTransactionaudit);
			}
		}
	}
}