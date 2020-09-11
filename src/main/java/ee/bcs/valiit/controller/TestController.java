package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

@RestController                     //@ operaator - annotatsioon, linnuke, millega märgistame klassi
public class TestController {
    private static final List <EmployeeDTO> employeeList = new ArrayList<>();    // <Employee> viitab andmetüübile

/*    @GetMapping(value="/")          //url, kuhu teed päringu --> NB! Sisuliselt määran url aadressi
    public String getHelloWorld() {
    return "Hi World";
    }*/

//    @GetMapping()
//    public String test(@RequestParam("id") String id) {     // localhost:8080/?id=....ja siia sisestan selle, mida tahan sisestada
//        return id;
//    }

    //LESSON 3 YL1
    @GetMapping("3sum/{sumx}/{sumy}/")
    public static int sum(@PathVariable ("sumx") int x, @PathVariable("sumy") int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        return Lesson3.sum(x,y);
    }   //-->web: http://localhost:8080/3sum/5/6/

    //LESSON 3 YL2
    @GetMapping("sumarray/{array}")
    public static int sumM(@PathVariable ("array") int [] x) {      //array PathVariable'ga
        // Todo liida kokku kõik numbrid massivis x
        return Lesson3.sumM(x);
    }   //--> web: http://localhost:8080/sumarray/1,2,3     --> array sisestan eraldades elemendid komadega

    //LESSON 3 YL2  --> @RequestParam'ga
    @GetMapping("sumarrayparam")
    public static int sumArray(@RequestParam ("arr") int [] x) {       //array RequestParam'ga
        // Todo liida kokku kõik numbrid massivis x
        return Lesson3.sumM(x);
    }   //--> web:  http://localhost:8080/sumarrayparam?arr=1,2,3

    //LESSON 3 YL3
    @GetMapping("factorial")
    public static int factorial(@RequestParam ("x") int x) {
        // TODO tagasta x faktoriaal.
        return Lesson3.factorial(x);
    }

    //LESSON 3 YL4
    @GetMapping("sortlist")
    public static int[] sort(@RequestParam("sort") int [] a) {
        // TODO sorteeri massiiv suuruse järgi
        return Lesson3.sort(a);
    }   //--> web: http://localhost:8080/sortlist?sort=5,4,3,2,1

    //LESSON 3 YL5
    @GetMapping("reversestring")
    public static String reverseString(@RequestParam ("rev") String text) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        // 2 parameetriga substringi vaja ülesande lahendamiseks, vaatas ka split ja indexOf

        return Lesson3.reverseString(text);
    }   // --> web: http://localhost:8080/reversestring?rev=kildu

    //LESSON 3 YL6
    @GetMapping("isprime")
    public static boolean isPrime(@RequestParam ("prim") int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        return Lesson3.isPrime(x);
    }   // web:     http://localhost:8080/isprime?prim=13   (true)

    //Lesson3HARD YL1
    @GetMapping("evenfibonacci/{fibo}")
    public static int evenFibonacci(@PathVariable("fibo") int n) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        return Lesson3Hard.evenFibonacci(n);
    }   // --> http://localhost:8080/evenfibonacci/10       (44)

    //Lesson3HARD YL3
    @GetMapping("morsecode/{morse}")
    public static String morseCode(@PathVariable("morse") String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return Lesson3Hard.morseCode(text);
    }   // --> http://localhost:8080/morsecode/tere     (-..-..)

    //Lesson2 YL1
    @GetMapping("2excercise1")
    public static int[] exercise1(@RequestParam("rev") int[] intArray) {
        // TODO loo 10 elemendile täisarvude massiiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras
        return Lesson2.exercise1(intArray);
    }   // --> http://localhost:8080/morsecode/tere     (-..-..)

    //Lesson2 YL2
//    public static void exercise2(int x) {
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("Sisesta number: ");
//        int input = scanner1.nextInt();
//        int[] massiiv = new int[input];
//        // TODO prindi välja x esimest paaris arvu
//        // Näide:
//        // Sisend 5
//        // Väljund 2 4 6 8 10
//
//        for (int i = 1; i <= input; i++) {
//            massiiv[i - 1] = i * 2;
//            System.out.println(massiiv[i - 1]);
//        }
//    }

    //Lesson2 YL3
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

    //Lesson2 YL4
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

    //Lesson2 YL5
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

    //Lesson2 YL6
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

    //Lesson2 YL7
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

    //Lesson2 YL8
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

    //Lesson2 YL9
    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    //Lesson2 YL10
    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

    //DTO ÜLESANNE - EMPLOYEES LIST             //Serveri restardiga läheb RAM mälu tühjaks ja andmed kaovad
    // 1. Get - Näitab kõiki objekte
    @GetMapping("employees")
    public List <EmployeeDTO> employees () {
        return employeeList;
    }   // web:   http://localhost:8080/employees      ([]) --> list on tühi, kuna pole veel kedagi lisatud

    // 2. Get - Näitab objekti vastavalt indeksile
    @GetMapping("employees/{id}")
    public EmployeeDTO showEmployees (@PathVariable ("id") int id) {
        return employeeList.get(id);
    }   // web:   http://localhost:8080/employees

    // 3. Post - Lisame objekti
    @PostMapping("employees")
    public void addEmployee(@RequestBody List<EmployeeDTO> employeeDTO) { // --> sisestame uue objekti Json formaadis Postmanis
        employeeList.addAll(employeeDTO);                       //--> @RequestBody - sisestan selle teksti Postman Body's!!!!
    } // web:   http://localhost:8080/employees

    // 4. PUT - Asendame objekti
    @PutMapping("employees/{id}")
    public void changeEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable ("id") int id) {  //Path variable, kui viide id'le
        employeeList.set(id,employeeDTO);
    } // web:   http://localhost:8080/employees/1

    // 5. DELETE - Kustutame töötaja
    @DeleteMapping ("employees/{id}")
    public void deleteEmployee(@PathVariable ("id") int id) {
        employeeList.remove(id);
    } // web:   http://localhost:8080/employees/1





    //private static final List <EmployeeDTO> employeeList = new ArrayList();

    //DTO SAMPLE, mis tunnis koos läbi tegime
    @GetMapping("dto")                      // ---> ENDPOINT!!!
    public SampleDTO sampleDTO() {          //tagastame uue enda loodud objekti, hall on meetodi nimi
        SampleDTO sample = new SampleDTO();
        sample.setStatus("pos");
        return sample;
    } // web:   http://localhost:8080/dto/      (pos)

    @PostMapping("dto")
    public void postTest(@RequestBody SampleDTO sample) {
        System.out.println(sample.getStatus());
    } // web:




}

//public class SampleDTO {
//    private String status;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}