package ee.bcs.valiit.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta Fibonacci jada number, milleni soovid paarisarvude summat kuvada: ");
        int n = scanner.nextInt();
        System.out.println(evenFibonacci(n));

//        //randomGame();
//        System.out.println("Sisesta tekst, mida soovid kuvada morse koodis.");
//        Scanner scanner1 = new Scanner(System.in);
//        String translate = scanner1.nextLine();
//        System.out.println(morseCode(translate));

    }

    public static int evenFibonacci(int n) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
            if (fibArray[i] % 2 == 0) {
                sum += fibArray[i];
            }
        }
        return sum;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks

        Random random = new Random();
        int i = random.nextInt(100);
        boolean guessedRight = false;
        int counter = 1;

        while (!guessedRight) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Palun paku number 0st 100ni: ");
            int guess = scanner.nextInt();
            if (guess == i) {
                System.out.println("Arvasid õigesti!");
                break;
            } else if (i > guess) {
                System.out.println("Pakkusid väiksemat numbrit, proovi uuesti.");
            } else {
                System.out.println("Pakkusid suuremat numbrit, proovi uuesti.");
            }
            counter++;
        }
        System.out.println("Arvuti pakkus numbrit: " + i);
        System.out.println("Arvasid numbri ära " + counter + " korraga.");
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -

        Map<String, String> morseList = new HashMap<>();
        morseList.put("a", ".-");
        morseList.put("b", "-...");
        morseList.put("c", "-.-.");
        morseList.put("d", "-..");
        morseList.put("e", ".");
        morseList.put("f", "..-.");
        morseList.put("g", "--.");
        morseList.put("h", "....");
        morseList.put("i", "..");
        morseList.put("j", ".---");
        morseList.put("k", "-.-");
        morseList.put("l", ".-..");
        morseList.put("m", "--");
        morseList.put("n", "-.");
        morseList.put("o", "---");
        morseList.put("p", ".--.");
        morseList.put("q", "--.-");
        morseList.put("r", ".-.");
        morseList.put("s", "...");
        morseList.put("t", "-");
        morseList.put("u", "..-");
        morseList.put("v", "...-");
        morseList.put("w", ".--");
        morseList.put("x", ".--");
        morseList.put("y", "-.--");
        morseList.put("z", "--..");

        StringBuilder str = new StringBuilder();
        String newString = "";
        for (int i = 0; i < text.length(); i++) {
            str.append(morseList.get(text.substring(i,i+1)));
        }

        //        String temp = "";
//        String morse = "";
//        String newString = "";
//        for (int i = 0; i < text.length(); i++) {
//            temp = text.substring(i,i+1);
//            morse = morseList.get(temp);
//            str = str.append(morse);
//        }
        newString = str.toString();
        return newString;
    }
}
