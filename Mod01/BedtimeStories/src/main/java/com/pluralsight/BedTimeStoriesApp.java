package com.pluralsight;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BedTimeStoriesApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Choose a story to read:");
        System.out.println("1. goldilocks.txt");
        System.out.println("2. hansel_and_gretel.txt");
        System.out.println("3. mary_had_a_little_lamb.txt");
        System.out.print("Enter the name of the story file: ");
        String fileName = input.nextLine();

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/" + fileName);
            Scanner fileScanner = new Scanner(fis);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
