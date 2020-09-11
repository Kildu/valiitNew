package ee.bcs.valiit.controller;

public class Lesson1 {

    public static void main(String[] args) {
        excersie1();
        excersie2();
        excersie3();
        excersie4();
    }

    public static void excersie1(){
        // TODO
        int a = 1;
        int b = 1;
        int c = 3;

        System.out.println(a==b);
        System.out.println(a==c);

        a = c;

        System.out.println(a==b);
        System.out.println(a==c);

        // defineeri 3 muutujat a = 1, b = 1, c = 3
        // Prindi välja a==b ja a==c
        // Lisa rida a = c
        // Prindi välja a==b ja a==c, mis muutus??? --> Muutus a väärtus
    }

    public static void excersie2(){
        // TODO
        int x1 = 10;
        int x2 = 20;

        int y1 = ++x1;
        System.out.println("x1 väärtus on " + x1 + " y1 väärtus on " + y1);
        // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
        // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1

        int y2 = x2++;
        System.out.println("x2 väärtus on " + x2 + " y2 väärtus on " + y2);

        // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
        // Analüüsi tulemusi
    }

    public static void excersie3(){
        // TODO
        long a = 18 % 3;
        long b = 19 % 3;
        long c = 20 % 3;
        long d = 21 % 3;
        System.out.println("a " + a + " b " + b + " c " + c + " d " + d);
        // Loo arvulised muutujad
        // a = 18 % 3
        // b = 19 % 3
        // c = 20 % 3
        // d = 21 % 3
        // Prindi välja kõigi muutujate väärtused --> Näitab jääki, kui palju jääb üle
    }

    public static void excersie4(){
        // TODO
        String var = "\\\"\\\\\"";
        System.out.println(var);
        // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
        // Trüki muutuja sisu välja
    }

}
