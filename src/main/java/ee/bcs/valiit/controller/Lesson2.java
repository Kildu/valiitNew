package ee.bcs.valiit.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) throws Exception {

        //1.YL SISEND+VÄLJUND
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[10];
        //StringBuilder initialArray = new StringBuilder();
        System.out.println("Sisesta 10 numbrit");
        for (int i = 0; i < 10; i++) {
            intArray[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(exercise1(intArray)));

//        //2.YL SISEND+VÄLJUND (exercise2())
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("Sisesta number: ");
//        int input = scanner1.nextInt();
//        int[] massiiv = new int[input];
//        System.out.println(Arrays.toString(exercise2(massiiv)));

        //
        // exercise3(2,5);
        //fibonacci(5);
        //exercise5();
        //exercise6();
          //exercise7();
//        exercise8();
//        exercise9();
    }

    public static int [] exercise1(int [] intArray) {
        // TODO loo 10 elemendile täisarvude massiiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras
        //StringBuilder newArray = new StringBuilder();
        int [] newOne = new int [10];
        for (int j = 9; j >= 0; j--) {
            //newArray.append((intArray[j]) + " ");
            newOne[9-j] = intArray[j];
        }
        return newOne;
    }

//    public static int [] exercise2(int x) {
//        // TODO prindi välja x esimest paaris arvu
//        // Näide:
//        // Sisend 5
//        // Väljund 2 4 6 8 10
//
//        for (int i = 1; i <= x; i++) {
//            massiiv[i - 1] = i * 2;
//            System.out.println(massiiv[i - 1]);
//        }
//        return massiiv;
//    }

    public static void exercise3(int x, int y) {        //tühi string, liidad stringi OR 2D massiiv, br/ break line
        int[][] array = new int[x][y];
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Sisesta tabeli ridade ja veergude arv: ");
        x = scanner2.nextInt();
        y = scanner2.nextInt();
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(j * i + " ");        // lisan tühiku numbri järele
            }
            System.out.println("");         //reavahetus
        }
    }

    public static int fibonacci(int n) {        //
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Sisesta Fibonacci jada number, mille väärtust soovid kuvada:");
        n = scanner3.nextInt();
        int[] massiiv = new int[n + 1];   // siia tuleb +1 tuleb panna või Math.max(2,n), kuna muidu jääb massiivis 1 koht puudu, kui tahad jada 1. numbrit (seal vaja 2 indeksit, 0 ja 1)
        massiiv[0] = 0;
        massiiv[1] = 1;

        for (int i = 2; i < n; i++) {
            massiiv[i] = massiiv[i - 2] + massiiv[i - 1];
        }
        System.out.println(massiiv[n - 1]);

        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
        return massiiv[n - 1];
    }

    public static void exercise5() {        //Hailstone numbers
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        //Calculate algorithm lengths
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Sisesta 2 arvu vahemikus 1 - 9 999: ");
        int n1 = scanner4.nextInt();
        int n2 = scanner4.nextInt();
        int maxLength = 1;
        int length = 1;

        if (n1 > n2) {
            int temp = n2;
            n2 = n1;
            n1 = temp;
        }
        for (int n = n1; n <= n2; n++) {
            length = ex5Range(n);
            if (length > maxLength) {
                maxLength = length;
            }
        }
        System.out.println(maxLength);
    }

    public static int ex5Range(int x) {
        int counter = 1;
        while (x != 1) {
            if (x % 2 != 0) {       //paaritu arv
                x = (3 * x) + 1;
            } else {                // paaris arv
                x = x / 2;
            }
            counter++;
        }
        return counter;
    }

    public static void exercise6() throws Exception{
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */
        File visits = new File("C:/Users/opilane/Desktop/Kildu-Java/Visits.txt");
        Scanner scanner = new Scanner (visits);
        List<String> visitsList = new ArrayList<>();
        String line = "";
        while (scanner.hasNextLine()) {
            visitsList.add(scanner.nextLine());
        }
        System.out.println(Arrays.toString(visitsList.toArray()));
    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        //Kõigepealt teeme jagamise (sulgudes), seejärel lahutamise ning seejärel korrutamise.

        BigDecimal a = new BigDecimal("1.89");
        BigDecimal b = new BigDecimal("394486820340");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

        BigDecimal solution = ((b.divide(c)).subtract(d)).multiply(a);
        System.out.println(solution);
    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}