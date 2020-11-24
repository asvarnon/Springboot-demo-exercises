package com.codeup.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String showNumberOptions() {
        return "/dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String showAnswer(@PathVariable int num, Model model) {
        int rolledNum = rollDice(1, 6);
        boolean correctGuess = (num == rolledNum);
        model.addAttribute("num", num);
        model.addAttribute("randomNumber", rolledNum);
        model.addAttribute("correctGuess", correctGuess);

        return "/dice";
    }

    public static int rollDice(int number, int nSides) {
        int num = 0;
        int roll = 0;
        Random r = new Random();
        if (nSides >= 3) {
            for (int i = 0; i < number; i++) {
                roll = r.nextInt(nSides) + 1;
                System.out.println("Roll is:  " + roll);
                num = num + roll;
            }
        } else {
            System.out.println("Error num needs to be from 3");
        }
        return num;
    }




}

