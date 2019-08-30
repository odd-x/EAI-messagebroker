package com.audi.eai.messaging;

import com.audi.eai.model.*;
import com.google.gson.Gson;

public class employeeConsumer {
    public void listenITQueue(String message) {
        Gson gson = new Gson();
        Employee emp = gson.fromJson(message, Employee.class);
        String alert = "Listening IT Queue";
        System.out.println();
        System.out.println(alert);
        System.out.println("ID : " + emp.getId());
        System.out.println("Name : " + emp.getFirstName()+" "+emp.getLastName());
        System.out.println("Div :" + emp.getDivision());
        System.out.println();

    }

    public void listenHRQueue(String message) {
        Gson gson = new Gson();
        Employee emp = gson.fromJson(message, Employee.class);
        String alert = "Listening HR Queue";
        System.out.println();
        System.out.println(alert);
        System.out.println("ID : " + emp.getId());
        System.out.println("Name : " + emp.getFirstName());
        System.out.println("Div :" + emp.getDivision());
        System.out.println();
    }
}