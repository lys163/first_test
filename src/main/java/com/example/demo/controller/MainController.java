package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping("/sbb")
    @ResponseBody
    //아래 함수의 리턴값을 그대로 브라우저에 표시
    // 아래 함수의 리턴값을 문자열화 해서 브라우저 응답을 바디에 담는다
    public String index(){
        return "hi";
    }

    @GetMapping("/page1")
    @ResponseBody
    public String showGet(){
        return """
                <form method="POST" action="/page2" />
                    <input type="number" name="age" placeholder="나이 입력" />
                    <input type="submit" value="page2로 Post 방식으로 이동" />
                </form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String Show2post(@RequestParam(name = "age", defaultValue = "0") int age){
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>post 방식.</h1>
                """.formatted(age);
    }

    @GetMapping("/page2")
    @ResponseBody
    public String showPost(@RequestParam(name = "age", defaultValue = "0")int age){
        return """
                <h1>입력된 나이:%d</h1>
                <h1>Get 방식</h1>
                """.formatted(age);
    }

    //test1
    @GetMapping("/plus")
    @ResponseBody
    public int test1(int a, int b){
        return a+b;
    }

    @GetMapping("/minus")
    @ResponseBody
    public int test2(int a, int b){
        return a-b;
    }

    private int num=-1;
    @GetMapping("/increase")
    @ResponseBody
    public int increasetest(){
        num++;
        return num;
    }
}
