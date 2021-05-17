package com.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    // Bean : Spring 의 IoC방식으로 관리하는 객체
    // 빈 팩토리 (Beanfactory) : 스프링의 IoC 를 담당하는 핵심 컨테이너
    // 어플리케이션 컨텍스트 (applicationContext): 빈 팩토리를 확장한 IoC Container

    @Bean
    public Member member1() {
        //Setter injection (setter메서드를 이용한 의존성 주입)
        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setNickname("도사");
        member1.setPrinter(new PrinterA());
        return member1;
    }

    @Bean(name = "hello")
    public Member member2() {
        //Constructor Injection (생성자를 이용한 의존성 주입)
        return new Member("전우치", "도사", new PrinterA());
    }

    @Bean
    public PrinterA printerA() {
        return new PrinterA();
    }

    // 이름을 지정하지 않으면 메서드의 이름이 빈의 이름을 등록된다.
    @Bean
    public PrinterB printerB() {
        return new PrinterB();
    }

}
