package ee.bcs.valiit.controller;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {

    //NB! Main meetodis annad sisendi funktsioonile!!!

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //6. meetod sisend + väljund
        System.out.println("Sisesta 1st suurem täisarv: ");
        int x = scanner.nextInt();
        System.out.print(isPrime(x));

//        //5. meetod sisend + väljund
//        System.out.println("Sisesta sõne, mida soovid tagurpidi pöörata: ");
//        String text = scanner.nextLine();
//        System.out.print(reverseString(text));

//        //4. meetodi sisend + väljund
//        System.out.println("Sisesta massiivi elementide arv: ");
//        int elements = scanner.nextInt();
//        System.out.println("Sisesta massiivi elemendid: ");
//        int[] a = new int[elements];
//        for (int i = 0; i < elements; i++) {
//            a[i] = scanner.nextInt();
//        }
//        //sort(a);                    // obtain the array vahemälust
//        System.out.println(Arrays.toString(sort(a))); // now print the array as String


//        //3. meetodi sisend + väljund
//        System.out.println("Sisesta positiivne täisarv, mille faktoriaali soovid arvutada: ");
//        int x = scanner.nextInt();
//        System.out.println(factorial(x));

//        //2. meetodi sisend + väljund
//        System.out.println("Sisesta massiivi elementide arv: ");
//        int elements = scanner.nextInt();
//        System.out.println("Sisesta massiivi elemendid: ");
//        int [] x = new int [elements];
//        for (int i = 0; i < elements; i++) {
//            x [i] = scanner.nextInt();
//        }
//        System.out.println(sumM(x));
        //NB!!!! OLULINE INFO MASSIIVIDE KOHTA
        // NB! x on massiivi nimi,  int[] massiivi tüüp, kutsun meetodit massiivi nimega
        // x[2] // int - konkreetse massiivi elemendi väärtus, number


        //1. meetodi sisend + väljund
        //System.out.println("Sisesta x ja y väärtused: ");
        //int x = scanner.nextInt();
        //int y = scanner.nextInt();
        // System.out.println(sum(x,y));
    }

    public static int sum(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        int summa;
        summa = x + y;
        return summa;
    }

    public static int sumM(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        x = new int [] {1, 2, 3};
        int sumA = x[0] + x[1] + x[2];
//        for (int i = 0; i < x.length; i++) {
//            sumA = sumA + x[i];
//        }

//        int sumA = 0;
//        for (int i = 0; i < x.length; i++) {
//            sumA = sumA + x[i];
//        }
        return sumA;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.

        // Lahendus ilma massiivideta
        int factorial = 1;
        for (int i = 2; i <= x; i++) {
            factorial *= i;
        }
        return factorial;
        //int [] factorialArray = new int [x+1];  //--> checki x-i, mis siia panna???
        //factorialArray[0] = 1;
        //factorialArray[1] = 1;
        //    for (int i = 2; i <= x; i++) {
        //        factorialArray [i] = factorialArray[i-1] * (i);
        //}
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        //return factorialArray[x];
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        //int [] min = new int [a.length];
        //int minimum = a [0];
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {        //kas praegune väärtus on järgnevast suurem? Kui jah, siis...
                    int temp = a[i + 1];      //temporarily salvestan järgneva väärtuse
                    a[i + 1] = a[i];         //järgnevale väärtusele annan praeguse väärtuse
                    a[i] = temp;            //praegusele väärtusele annan temp väärtuse (järgneva väärtuse)
                }
            }
        }
        //Arrays.sort(a);       --> etteantud meetodeid ei kasuta
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static String reverseString(String text) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        // 2 parameetriga substringi vaja ülesande lahendamiseks, vaatas ka split ja indexOf

//        for (int i = text.length() - 1; i >= 0; i--) {
//            if (i == text.length() - 1) {
//                System.out.print(text.substring(text.length() - 1));
//            } else {
//                System.out.print(text.substring(i, i + 1));
//            }
//            //System.out.print(test.substring(3, 4));   D   A     --> viimase tähe End Index on 1 võrra suurem indeksite väärtusest (length()+1)
//            //System.out.print(test.substring(2, 3));   C   B
//            //System.out.print(test.substring(1, 2));   B   C
//            //System.out.print(test.substring(0, 1));   A   D
//        }
        String newString = "";      //--> loon uue stringi ja annan algväärtuse
        for (int i = 0; i < text.length(); i++) {
            String temp = text.substring(text.length() - 1 - i, text.length() - i);   //loen ajutisse Stringi sisse tagurpidi väärtused
            newString += temp;      //lisan uude Stringi kõik tähed
        }
//        System.out.print(newString);
//        System.out.println("");
//        System.out.println(text.substring(3,4));
        return newString;
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        boolean primeCheck = false;
        if (x == 2 || x == 3) {
            primeCheck = true;
        } else if (x % 2 == 0 || x % 3 == 0) {
            primeCheck = false;
        } else {
            primeCheck = true;
        }
        return primeCheck;
    }
}