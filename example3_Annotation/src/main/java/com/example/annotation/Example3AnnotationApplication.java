package com.example.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example3AnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Example3AnnotationApplication.class, args);
    }

}

/*
 *  @SpringBootApplication 세가지 기능이 있다.
 *  1. @Configuration
 *  : 빈을 생성할 때 Singleton으로 한번만 생성한다 그리고는 각종 설정을 세팅한다.
 *
 *  2. @EnableAutoConfiguration
 *  : 스프링 어플리케이션 컨텍스트를 만들때 자동으로 설정하는 기능을 킨다.
 *    사용자가 필요할 것 갗은 빈을 추측해서 ApplicationContext 만들 필요한 설정을 한다.
 *    클래스 패스를 기준으로 클래스를 찾아서 설정을 하게 한다.
 *
 *  3. @ComponentScan
 *  : 지정한 위치 이하에서 있는 @Component 와 @Configuration 이 붙은 클래스를 스캔해서 빈으로 등록
 *    이때 내장 톰캣이 사용된다 기본으로 8080을 사용하게 된다. 다른포트번호로 수정 --> application.properties수정
 *    @Component 어노테이션만 지정하면 클래스의 이름의 첫 글자를 소문자로 한 클래스의 이름이 빈의 이름으로 등록
 *    빈의 매핑 방식은 RequestMapping 에 등록된 메소드가 호출되는 방식 (주소창에서 URL 입력 방식)
 */
