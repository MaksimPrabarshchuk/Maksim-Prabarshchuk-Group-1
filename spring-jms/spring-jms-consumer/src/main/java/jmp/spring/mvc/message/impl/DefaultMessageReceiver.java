package jmp.spring.mvc.message.impl;

import java.time.LocalDate;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import jmp.spring.mvc.model.Employee;
import jmp.spring.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultMessageReceiver implements MessageListener {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void onMessage(Message message) {
        if (message instanceof MapMessage) {
            MapMessage mapMessage = (MapMessage) message;
            try {
                Employee em = new Employee();
                em.setFirstName(mapMessage.getString("firstName"));
                em.setLastName(mapMessage.getString("lastName"));
                em.setGender(mapMessage.getString("gender"));
                em.setHireDate(LocalDate.now().toString());
                em.setJobTitle(mapMessage.getString("jobTitle"));
                em.setSalary(mapMessage.getDouble("salary"));
                employeeService.saveEmployee(em);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
