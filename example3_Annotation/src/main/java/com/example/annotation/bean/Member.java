package com.example.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {

    @Value("홍길동")
    private String name;

    @Value("도사")
    private String nickname;


    @Autowired
    @Qualifier("printerA")
    // 유사한 객체가 여러개 있을때 빈의 이름으로 정확하게 지정한다
    private Printer printer;

    public Member() {

    }

    public Member(String name, String nickname, Printer printer) {
        this.name = name;
        this.nickname = nickname;
        this.printer = printer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print() {
        printer.print("Hello" + name + ":" + nickname);
    }

}
