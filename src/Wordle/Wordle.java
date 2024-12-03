package Wordle;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

class ColoredChar {
    private final char character;
    private final String color;

    public ColoredChar(char character, String color) {
        this.character = character;
        this.color = color;
    }

    @Override
    public String toString() {
        return color + character + "\u001B[0m";
    }
}

public class Wordle {
    public static void main(String[] args) {
        System.out.println("-----------Wordle-----------");
        System.out.println("I have a 5 letter word that you need to guess.");
        System.out.println("If at any point you want a hint, you have two hints per round.");
        System.out.println("To use a hint, type the number of h's that corresponds to the letter you want to know.");
        System.out.println("For example, if you want to know the first letter, type 'h'.");
        System.out.println("If you want to know the third letter, type 'hhh'.");

        Random randLine = new Random();
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";

        int lineNumber = randLine.nextInt(3104);
        String word = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src/Wordle/WordBank.txt"))) {
            for (int i = 0; i <= lineNumber; i++) {
                word = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean validWord = false;
        int hintsUsed = 0;
        String guess = "";
        Scanner input = new Scanner(System.in);
        int attempts = 0;

        while (!guess.equals(word)) {
            int correct = 0;
            int wrongSpot = 0;
            boolean[] matched = new boolean[5];
            boolean[] used = new boolean[5]; // Tracks characters in word already used for yellow
            System.out.println("Enter your guess: ");
            guess = input.nextLine();

            boolean hintUsed = false;
            if (hintsUsed < 2) {
                switch (guess) {
                    case "h":
                        System.out.println("The first letter of the word is " + word.charAt(0));
                        hintsUsed++;
                        hintUsed = true;
                        break;
                    case "hh":
                        System.out.println("The second letter of the word is " + word.charAt(1));
                        hintsUsed++;
                        hintUsed = true;
                        break;
                    case "hhh":
                        System.out.println("The third letter of the word is " + word.charAt(2));
                        hintsUsed++;
                        hintUsed = true;
                        break;
                    case "hhhh":
                        System.out.println("The fourth letter of the word is " + word.charAt(3));
                        hintsUsed++;
                        hintUsed = true;
                        break;
                    case "hhhhh":
                        System.out.println("The last letter of the word is " + word.charAt(4));
                        hintsUsed++;
                        hintUsed = true;
                        break;
                }
            }

            if (hintUsed) {
                continue; // Skip the rest of the loop and prompt the user to enter a guess again
            }

            while (!validWord) {
                try (BufferedReader br = new BufferedReader(new FileReader("src/Wordle/BigWordBank.txt"))) {
                    for (int i = 0; i <= 15908; i++) {
                        if (guess.equals(br.readLine())) {
                            validWord = true;
                            break;
                        }
                    }
                    if (!validWord) {
                        System.out.println("That is not a valid 5 letter word. Please enter a valid 5 letter word: ");
                        guess = input.nextLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            attempts++;
            ColoredChar[] result = new ColoredChar[5];

            // First pass for correct positions
            for (int j = 0; j < 5; j++) {
                if (word.charAt(j) == guess.charAt(j)) {
                    correct++;
                    matched[j] = true;
                    used[j] = true;
                    result[j] = new ColoredChar(guess.charAt(j), GREEN);
                } else {
                    result[j] = new ColoredChar(guess.charAt(j), "");
                }
            }

            // Second pass for wrong positions
            for (int j = 0; j < 5; j++) {
                if (!matched[j] && word.indexOf(guess.charAt(j)) != -1) {
                    for (int k = 0; k < 5; k++) {
                        if (word.charAt(k) == guess.charAt(j) && !used[k]) {
                            wrongSpot++;
                            used[k] = true;
                            result[j] = new ColoredChar(guess.charAt(j), YELLOW);
                            break;
                        }
                    }
                }
            }

            for (ColoredChar c : result) {
                System.out.print(c);
            }
            System.out.println();
            System.out.println(correct + " correct");
            System.out.println(wrongSpot + " incorrect location, correct letter");
            validWord = false;
        }

        if (attempts == 1) {
            System.out.println("Congratulations, you guessed the word in " + attempts + " try!");
        } else {
            System.out.println("Congratulations, you guessed the word in " + attempts + " tries!");
        }
    }
}
