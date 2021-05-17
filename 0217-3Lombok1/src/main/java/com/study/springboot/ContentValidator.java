package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

    @Override
    public boolean supports(Class<?> arg0) {
        return ContentDto.class.isAssignableFrom(arg0); //검증할 클래스 타입 정보
    }

    @Override
    public void validate(Object obj, Errors errors) { //원하는 커맨드 객체 obj
        ContentDto dto = (ContentDto) obj; //형변환하 변수에 저장

        String sWriter = dto.getWriter(); //컨맨드 객체로부터 작성자의 값을 구해와서

        if (sWriter == null || sWriter.trim().isEmpty()) { //커멘드 객체로 부터 작성자의 값을 구해와서
            System.out.println("Writer is null or empty"); //값이 널이지 공백인지를 체크하는 로직이다
            errors.rejectValue("writer", "trouble");
        }

        String sContent = dto.getContent(); //커맨드 객체로부터 내용값을 구해온다.
        if (sContent == null || sContent.trim().isEmpty()) { //값이 널이지 공백인지를 체크하는 로직이다.
            System.out.println("Content is null or empty");
            errors.rejectValue("content", "trouble");
        }

    }
    /**
     *  데이터가 유효성 검사에서 통과를 못했다면 errors 객체 변수에 에러내용을 담는다.
     *  모든 요소를 검증할 필요는 없다. 필요한 필드나 (요소)만을 검증하는 로직을 만들면 된다.
     */

}
