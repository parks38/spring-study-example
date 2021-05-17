package com.study.springboot;

import lombok.Data;

@Data
public class ContentDto {
    private int id;
    private String writer;
    private String content;
}
/**
 * 폼 데이터의 유효성은 검증 온 두단계에서 이루어진다.
 * 클라이언트인 Html 페이지에서 자바스크립트를 통한 겁증
 * 거버 페이지인 Jsp.Servlet에서 파라미터로 받은 후 검증
 */
