package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] quotes = {
                "Be yourself; everyone else is already taken. – Oscar Wilde",
                "Two things are infinite: the universe and human stupidity. – Albert Einstein",
                "So many books, so little time. – Frank Zappa",
                "Be the change that you wish to see in the world. – Mahatma Gandhi",
                "In three words I can sum up everything I've learned about life: it goes on. – Robert Frost",
                "A room without books is like a body without a soul. – Marcus Tullius Cicero",
                "You only live once, but if you do it right, once is enough. – Mae West",
                "In the end, we will remember not the words of our enemies, but the silence of our friends. – Martin Luther King Jr.",
                "Life is what happens when you're busy making other plans. – John Lennon",
                "To live is the rarest thing in the world. Most people exist, that is all. – Oscar Wilde"
        };

        try {
            System.out.print("Select a number between 1 and 10: ");
            int userResponse = input.nextInt();

            if (userResponse >= 1 && userResponse <= 10) {
                System.out.println("\n" + quotes[userResponse - 1]);
            } else {
                System.out.println("Pls enter the number between 1 and 10");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Enter a whole number!");
        }
    }
}
