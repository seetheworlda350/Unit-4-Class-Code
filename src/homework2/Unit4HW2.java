package homework2;

public class Unit4HW2 {

    public static void main(String[] args) {
        vowelCounter("The quick brown fox jumped over the lazy dog.");
        System.out.println();
        vowelCounter("aaeeeeiiiioouuuu");
        System.out.println();
        palindromeChecker("level");
        System.out.println();
        palindromeChecker("abcde");
        System.out.println();
        palindromeChecker("racecar");
        System.out.println();
        palindromeChecker("aBbA");
        System.out.println();
        //extra credit
        palindromeChecker("s*dfj*js");
        System.out.println();
        palindromeChecker("jf&fj");

    }

    public static void vowelCounter(String str) {
        System.out.println("Part 1: Vowel Counter");
        System.out.println();
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        for (int letter = 0; letter < str.length(); letter++) {
            if (str.charAt(letter) == 'a' || str.charAt(letter) == 'A') {
                a++;
            } else if (str.charAt(letter) == 'e' || str.charAt(letter) == 'E') {
                e++;
            } else if (str.charAt(letter) == 'i' || str.charAt(letter) == 'I') {
                i++;
            } else if (str.charAt(letter) == 'o' || str.charAt(letter) == 'O') {
                o++;
            } else if (str.charAt(letter) == 'u' || str.charAt(letter) == 'U') {
                u++;
            }
        }
        System.out.println("a: " + a);
        System.out.println("e: " + e);
        System.out.println("i: " + i);
        System.out.println("o: " + o);
        System.out.println("u: " + u);

    }

    public static void palindromeChecker(String str) {
        String reverse = "";
        boolean hasInvalidChar = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '*' || str.charAt(i) == '&' || str.charAt(i) == '$' || str.charAt(i) == '#') {
                System.out.println("Error: Invalid character detected in " + str);
                hasInvalidChar = true;
                break;
            }
        }

        if (!hasInvalidChar) {
            for (int l = str.length() - 1; l >= 0; l--) {
                reverse = reverse + str.charAt(l);
            }
            if (str.equalsIgnoreCase(reverse)) {
                System.out.println(str + " is a palindrome.");
            } else {
                System.out.println(str + " is not a palindrome.");
            }


        }
    }
}