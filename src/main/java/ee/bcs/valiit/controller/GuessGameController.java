package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GuessGameController {
    int counter = 0;
    public static int randomNumber;

    @PostMapping("guessnr")
    public String guessNumber(@RequestBody int guessedNr) {     //enne oli void
        Random random1 = new Random();
        randomNumber = random1.nextInt(100);
        return "Paku number 0st 100ni";
    }  // web:   http://localhost:8080/guessnr

    @GetMapping("guessnr")
    public String checkNumber(@RequestBody int guessedNr) {    //@PathVariable("check") boolean guessedRight
        String reply;
        counter++;
        if (guessedNr == randomNumber) {
            reply = "Juhhuuu, arvasid õigesti!";
        } else if (randomNumber > guessedNr) {
            reply = "Pakkusid väiksemat numbrit, proovi uuesti.";
        } else {
            reply = "Pakkusid suuremat numbrit, proovi uuesti.";
        }
        return reply;
    }// web:   http://localhost:8080/guessnr

    @GetMapping("guessnr/return")
    public String returnInfo(@RequestParam("continue") String x,
                             GuessGameDTO random) { //@RequestBody int guessedNr
        String answer = "Arvuti pakkus numbrit: " + randomNumber + ". Arvasid numbri ära " + counter + " korraga.";
        return answer;
    } // web:   http://localhost:8080/guessnr/return?continue=yes
}
