package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the employee file to process: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader("src/main/resources/" + inputFileName);
            BufferedReader bufReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFileName);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            // header for a payroll file
            bufWriter.write("id|name|gross pay");
            bufWriter.newLine();

            bufReader.readLine(); // skip header

            String input;

            System.out.println("ID|name|Gross pay");

            while ((input = bufReader.readLine()) != null) {
                String[] parts = input.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1].trim();
                double hoursWork = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                Employee employ = new Employee(id, name, hoursWork, payRate);

                bufWriter.write(String.format("%d|%s|%.2f", id, name, employ.getGrossPay()));
                bufWriter.newLine();
            }

            bufWriter.close();
            bufReader.close();

            System.out.println("The payroll file was created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
