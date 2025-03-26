package com.microservices_payment_system.payment_service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	 @Bean
	 public NewTopic paymentTopic() 
	 {
	    //return new NewTopic("payment-topic", 3, (short) 1);
		 return TopicBuilder.name("payment-topic")
                 .partitions(3)
                 .replicas(1)
                 .build();
	    
	 }

}
