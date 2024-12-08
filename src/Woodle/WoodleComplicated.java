package Woodle;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class WoodleComplicated {
    public static void main(String[] args) {
        System.out.println("-----------Woodle-----------");
        System.out.println("I have a 5 letter word that you need to guess.");
        Random randLine = new Random();
        int lineNumber = randLine.nextInt(3104);
        String word = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src/Woodle/WordBank.txt"))) {
            for (int i = 0; i <= lineNumber; i++) {
                word = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean validWord = false;
        String guess = "";
        Scanner input = new Scanner(System.in);
        int attempts = 0;

        while (!guess.equals(word)) {
            int correct = 0;
            int wrongSpot = 0;
            boolean[] matched = new boolean[5];
            System.out.println("Enter your guess: ");
            guess = input.nextLine();
            attempts++;

            while (validWord == false) {
                try (BufferedReader br = new BufferedReader(new FileReader("src/Woodle/BigWordBank.txt"))) {
                    for (int i = 0; i <= 15908; i++) {
                        if (guess.equals(br.readLine())) {
                            validWord = true;
                            break;
                        }
                    }
                        if (validWord == false) {
                            System.out.println("That is not a valid 5 letter word. Please enter a valid 5 letter word: ");
                            guess = input.nextLine();
                        }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (int j = 0; j < 5; j++) {
                if (word.charAt(j) == guess.charAt(j)) {
                    correct++;
                    matched[j] = true;
                }
            }

            for (int j = 0; j < 5; j++) {
                if (word.charAt(j) != guess.charAt(j) && word.indexOf(guess.charAt(j)) != -1) {
                    for (int k = 0; k < 5; k++) {
                        if (word.charAt(k) == guess.charAt(j) && !matched[k]) {
                            wrongSpot++;
                            matched[k] = true;
                            break;
                        }
                    }
                }
            }




            System.out.println(correct + " correct");
            System.out.println(wrongSpot + " incorrect location, correct letter");
            validWord = false;
        }
        if (attempts == 1) {
            System.out.println("Congratulations, you guessed the word in " + attempts + " try!");
            validWord = false;
        } else {
            System.out.println("Congratulations, you guessed the word in " + attempts + " tries!");
            validWord = false;
        }
    }
}