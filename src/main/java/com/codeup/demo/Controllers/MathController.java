package com.codeup.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}") @ResponseBody
    public int sum(@PathVariable int num1, @PathVariable int num2){
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/from/{num2}") @ResponseBody
    public int difference(@PathVariable int num1, @PathVariable int num2){
        return num1 - num2;
    }

    @GetMapping("/multiply/{num1}/and/{num2}") @ResponseBody
    public int product(@PathVariable int num1, @PathVariable int num2){
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/by/{num2}") @ResponseBody
    public int multiple(@PathVariable int num1, @PathVariable int num2){
        return num1 / num2;
    }
}
