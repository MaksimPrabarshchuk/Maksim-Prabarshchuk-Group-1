package spring.jms.producer;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.jms.producer.config.AppConfig;
import spring.jms.producer.message.MessageSender;

public class Main {

    private static final String[] keys = new String[] {"firstName", "lastName", "gender", "jobTitle", "salary"};

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender messageSender = (MessageSender) context.getBean("messageSender");
        System.out.println("Input data for add new employee. (First name:Last Name:Gender:Job Title:Salary)");
        for (;;) {
            System.out.printf("New employee - ");
            Scanner scanner = new Scanner(System.in);
            String data = scanner.next();
            if ("exit".equals(data)) System.exit(0);

            String[] params = data.split(":");
            HashMap map = new HashMap();
            for (int i = 0; i < params.length; i++) {
                map.put(keys[i], params[i]);
            }
            try {
                messageSender.send(map);
            } catch (Exception e) {
                System.out.println("Error occured during JMS processing");
            }
        }
    }
}
