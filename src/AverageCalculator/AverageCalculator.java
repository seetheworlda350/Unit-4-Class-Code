package AverageCalculator;
import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        double average = 0.0;
        double sum = 0;
        int count = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number: ");
            int userNum = scan.nextInt();
            count++;
            sum = sum + userNum;
            average = sum / count;
            System.out.println("Average: " + average);
        }

    }
}
