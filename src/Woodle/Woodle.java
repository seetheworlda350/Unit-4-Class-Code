package Woodle;

import java.util.Scanner;
import java.util.Random;

public class Woodle {
    public static void main(String[] args) {
        System.out.println("-----------Woodle-----------");
        System.out.println("I have a 5 letter word that you need to guess.");
        Random randLine = new Random();
        String word = "apple";
        String guess = "";
        Scanner input = new Scanner(System.in);
        int attempts = 0;

        while (!guess.equals(word)) {
            int correct = 0;
            int wrongSpot = 0;
            boolean[] matched = new boolean[5];
            System.out.println("Enter your guess: ");
            guess = input.nextLine();

            // Check if the entered word is 5 letters long using substring and equals
            while (guess.length() < 5 || !guess.substring(0, 5).equals(guess)) {
                System.out.println("The word must be 5 letters long. Please enter a new guess: ");
                guess = input.nextLine();
            }

            attempts++;

            for (int j = 0; j < 5; j++) {
                if (word.substring(j, j + 1).equals(guess.substring(j, j + 1))) {
                    correct++;
                    matched[j] = true;
                }
            }

            for (int j = 0; j < 5; j++) {
                if (!word.substring(j, j + 1).equals(guess.substring(j, j + 1)) && word.indexOf(guess.substring(j, j + 1)) != -1) {
                    for (int k = 0; k < 5; k++) {
                        if (word.substring(k, k + 1).equals(guess.substring(j, j + 1)) && !matched[k]) {
                            wrongSpot++;
                            matched[k] = true;
                            break;
                        }
                    }
                }
            }

            System.out.println(correct + " correct");
            System.out.println(wrongSpot + " incorrect location, correct letter");
        }
        if (attempts == 1) {
            System.out.println("Congratulations, you guessed the word in " + attempts + " try!");
        } else {
            System.out.println("Congratulations, you guessed the word in " + attempts + " tries!");
        }
    }
}