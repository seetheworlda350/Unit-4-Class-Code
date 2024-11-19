package homework1;


import java.util.Scanner;
import java.util.Random;


public class Unit4HW1 {


    public static void main(String[] args) {
        guessingGame();
        tiredTurtle();
        notATamagotchi();
        int bob = 5;
        System.out.println(bob);
        bob = 8;



    }


    /**
     * Picks a random number between 1 and 100 and asks the user
     * to guess it. For each guess, the program should tell the user whether
     * the guess is too high, too low, or correct.
     */
    public static void guessingGame() {
        //feel free to use the Random class
        System.out.println("Hi, I am thinking of a number between 1 and 100. Can you guess it?");
        int randomNum = (int) (Math.random() * 100 + 1);
        int userGuess = 0;
        while (randomNum != userGuess) {
            Scanner Guess = new Scanner(System.in);
            System.out.print("Enter your guess: ");
            userGuess = Guess.nextInt();
            if (userGuess > randomNum) {
                System.out.println("Too high! Try again.");
            } else if (userGuess < randomNum) {
                System.out.println("Too low! Try again.");
            } else if (userGuess == randomNum) {
                System.out.println("Correct! The number was " + randomNum);
            }
        }
    }


    /**
     * Tired Turtle
     * Asks the user how many steps they want the turtle to take in its
     * first move. Then it calculates and displays how many total steps
     * the turtle took until it stopped.
     */
    public static void tiredTurtle() {
        System.out.println(" ");
        System.out.println("---------------------------------");
        System.out.println(" ");
        System.out.println("Hello, I have a very tired turtle.");
        Scanner steps = new Scanner(System.in);
        int firstStep = 0;
        int totalSteps = 0;
        System.out.print("How many steps should the turtle take in its first move? ");
        firstStep = steps.nextInt();
        totalSteps += firstStep;
        while (firstStep != 0) {
            firstStep = firstStep / 2;
            totalSteps += firstStep;


        }
        System.out.println("Total steps taken by the turtle: " + totalSteps);
    }




    /**
     * Simulates a Tamagotchi-like game. The user should be able to see their pets current hunger level
     * and decided to play with it or not. if they choose not to feed it and the pets hunger level reaches
     * 50, the pet will die. The simulation ends after 5 hours
     */
    public static void notATamagotchi() {
        System.out.println(" ");
        System.out.println("---------------------------------");
        System.out.println(" ");
        System.out.println("Welcome to Not A Tamagotchi!");
        int hunger = 10;
        int hour = 1;
        while (hour <= 5) {
            if (hunger < 0) {
                hunger = 0;
            }
            if (hour == 5) {
                System.out.println("Hour " + hour + ": Current hunger level is " + hunger);
                System.out.println("End of simulation. Your pet is content.");
                break;
            }
            System.out.println("Hour " + hour + ": Current hunger level is " + hunger);
            Scanner feed = new Scanner(System.in);
            System.out.print("Would you like to feed your pet? (yes/no): ");
            if (feed.nextLine().equals("yes")) {
                hunger -= 25;
                System.out.println(" ");
            } else {
                System.out.println(" ");
                hunger += 10;
            }
            if (hunger >= 50) {
                System.out.println("Your pet has died of hunger.");
                break;
            }
            if (hunger == 40) {
                System.out.println("Feed your pet soon, it is getting hungry.");
                hunger += 10;
            }
            hour++;
        }
    }
}

