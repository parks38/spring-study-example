package com.example.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.Config;
import com.example.bean.Member;
import com.example.bean.Printer;

//@SpringBootApplication
public class Example1Application {

    public static void main(String[] args) {
        //SpringApplication.run(Example1Application.class, args);

        // 1. IoC 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // 2. Member Bean 가져오기
        Member member1 = (Member) context.getBean("member1");
        member1.print();

        // 3. Member bean 가져오기
        Member member2 = context.getBean("hello", Member.class);
        member2.print();

        // 4. PrintB Bean 가져오기
        Printer printer = context.getBean("printerB", Printer.class);
        member1.setPrinter(printer);
        member1.print();

        // 5. 싱글톤인지 확인
//		if(member1 == member2) {
//			System.out.println("동일한 객체 입니다");
//		} else {
//			System.out.println("서로 다른 객체입니다. ")
//		}


    }

}
