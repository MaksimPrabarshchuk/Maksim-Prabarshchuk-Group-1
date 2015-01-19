package spring.jms.producer.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
@ComponentScan("spring.jms.producer")
public class AppConfig {

    private static final String ACTIVEMQ_CONNECTION_URL = "tcp://localhost:61616";
    private static final String ACTIVEMQ_TOPIC_NAME = "newUsers";

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestination(defaultDestination());
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(new ActiveMQConnectionFactory(ACTIVEMQ_CONNECTION_URL));
    }

    private Destination defaultDestination() {
        return new ActiveMQTopic(ACTIVEMQ_TOPIC_NAME);
    }
}
