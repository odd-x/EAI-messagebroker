package com.audi.eai.messaging;

import com.audi.eai.model.Employee;
import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * EmployeeProducer
 */
public class employeeProducer {

    public void send(Employee employee) throws InterruptedException {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String message = "";
        if (employee.getDivision().equals("IT")) {
            AmqpTemplate amqpTemplate = (RabbitTemplate) applicationContext.getBean("empITTemplate");
            Gson gson = new Gson();
            message = gson.toJson(employee);
            amqpTemplate.convertAndSend(message);
        } else if (employee.getDivision().equals("HR")) {
            AmqpTemplate amqpTemplate = (RabbitTemplate) applicationContext.getBean("empHRTemplate");
            Gson gson = new Gson();
            message = gson.toJson(employee);
            amqpTemplate.convertAndSend(message);
        }
            Thread.sleep(1000);
            applicationContext.close();
        }

}