package ee.bcs.valiit.controller;

import java.util.Scanner;

public class Lesson1MathUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palun sisestage meetod, mida soovite kasutada.");
        String method = scanner.nextLine();

        if (method.equalsIgnoreCase("min") || method.equalsIgnoreCase("max") ) {
            System.out.println("Palun sisestage 2 numbrit.");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (method.equalsIgnoreCase("min")) {
                System.out.println(min(a,b));
            } else {
                System.out.println(max(a,b));
            }
        } else if (method.equalsIgnoreCase("abs") || method.equalsIgnoreCase("isEven") ) {
            System.out.println("Palun sisestage 1 number.");
            int a = scanner.nextInt();
            if (method.equalsIgnoreCase("abs")) {
                System.out.println(abs(a));
            } else {
                System.out.println(isEven(a));
            }
        } else if (method.equalsIgnoreCase("min3") || method.equalsIgnoreCase("max3") ){
            System.out.println("Palun sisestage 3 numbrit.");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (method.equalsIgnoreCase("min3")) {
                System.out.println(min3(a,b,c));
            } else {
                System.out.println(max3(a,b,c));
            }
        } else {
            System.out.println("Sellist meetodit programmis ei ole, palun sisesta korrektne meetod!");
        }
        //int a = scanner.nextInt();
        //int b = scanner.nextInt();
        //System.out.println(min(a, b));
        //System.out.println(abs(13));
        //System.out.println(min(5, -12, -12));
        //System.out.println(max(12, 12, 5));


    }

    public static int min(int a, int b) {
        int minimum;
        // TODO tagasta a ja b väikseim väärtus
        if (a < b) {
            minimum = a;
        } else {
            minimum = b;
        }
        return minimum;
    }

    public static int max(int a, int b) {
        int maximum;
        // TODO tagasta a ja b suurim väärtus
        if (a > b) {
            maximum = a;
        } else {
            maximum = b;
        }
        return maximum;
    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv
        if (a < 0) {
            a = -a;
        }
        return a;
    }

    public static boolean isEven(int a) {
        boolean even;
        // TODO tagasta true, kui a on paaris arv
        // tagasta false kui a on paaritu arv
        if (a % 2 == 0) {
            even = true;
        } else {
            even = false;
        }
        return even;
    }

    public static int min3(int a, int b, int c) {
        int minimum;
        // TODO tagasta a, b ja c väikseim väärtus
        if (a <= b && a <= c) {
            minimum = a;
        } else if (b <= a && b <= c) {
            minimum = b;
        } else {
            minimum = c;
        }
        return minimum;
    }

    public static int max3(int a, int b, int c) {
        int maximum;
        // TODO tagasta a, b ja c suurim väärtus
        if (a >= b && a >= c) {
            maximum = a;
        } else if (b >= a && b >= c) {
            maximum = b;
        } else {
            maximum = c;
        }
        return maximum;
    }

}
