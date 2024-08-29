package com.NinjaCourier.testOtp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.message.*;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SMSService {
	
	
	
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	
	@PostConstruct
	private void setup() {
		Twilio.init( x, y);
	}
	
	
	public String sendSMS(String smsNumber, String smsMessage) {
        try {
            Message message = Message.creator(
                    new PhoneNumber(smsNumber),
                    new PhoneNumber(z),
                    smsMessage).create();
            
            log.info("SMS sent with SID: {}", message.getSid());
            return message.getSid();
        } catch (Exception e) {
            log.error("Failed to send SMS", e);
            throw new RuntimeException("Failed to send SMS", e);
        }
}
	}