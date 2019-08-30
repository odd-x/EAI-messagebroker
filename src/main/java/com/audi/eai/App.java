package com.audi.eai;

import com.audi.eai.messaging.employeeProducer;
import com.audi.eai.model.Employee;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Employee employee = new Employee();
        Employee employee1 = new Employee();

        employee.setId(123);
        employee.setFirstName("Audi");
        employee.setLastName("Aulia");
        employee.setDivision("HR");

        employee1.setId(321);
        employee1.setFirstName("Elga");
        employee1.setLastName("Purnama Aji");
        employee1.setDivision("IT");
        employeeProducer producer = new employeeProducer();

        producer.send(employee);
        producer.send(employee1);


    }
}
