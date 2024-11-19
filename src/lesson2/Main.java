package lesson2;

public class Main {
    public static void main(String[] args) {

        for(int start = 0; start < 10; start++){
            System.out.println(start);
        }

        System.out.println();

        int start2 = 0;
        while(start2 < 10){
            System.out.println(start2);
            start2++;
        }

        String name = "Norman";
        for(int i = 0; i<name.length(); i++){
            System.out.println(name.charAt(i));
        }
    }
}
