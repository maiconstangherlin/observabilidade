package com.maiconstangherlin.observabilidade.config;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import javax.jms.Session;

@EnableJms
@Configuration
public class JmsConfig {

    SQSConnectionFactory connectionFactory =
            SQSConnectionFactory.builder()
                    .withRegion(Region.getRegion(Regions.US_EAST_1))
                    .withAWSCredentialsProvider(new DefaultAWSCredentialsProviderChain())
                    .build();

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(this.connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("3-10");
        factory.setReceiveTimeout(10000L);
        factory.setMaxMessagesPerTask(25);
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return factory;
    }

}
