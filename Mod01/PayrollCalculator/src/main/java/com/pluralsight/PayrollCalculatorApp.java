package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculatorApp {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();
            String input;
            System.out.println("ID|name|Gross pay");
            while ((input = bufReader.readLine()) != null) {
                String[] parts = input.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1].trim();
                double hoursWork = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                Employee employ = new Employee(id, name, hoursWork, payRate);
                System.out.printf("%d|%s|%.2f|\n", employ.getEmployeeId(), employ.getName(), employ.getGrossPay());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
