
### ✅ 정적 컨텐츠 (static content)
: 파일을 그대로 웹브라우저에 그대로 보여주기 

### ✅  MVC / template 엔진 

: 서버에서 변형을 해서 내보내 주는 방식 

⇒ `Model View Controller`

### ✅  API
: json 데이터 포맷 클라이언트에게 데이터 전달
-  <xml> 보다는 `json`으로 반환 기본 default 
- Getter/setter → `java Bean` 표준 방식 = `property` 접근 방식
- `json` 변환 라이버리 :`jackson`(spring 기본)  / gson 

- HttpMessageConverter
    : 클라이언트의 Http Accept 헤더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 '`HttpMessageConverter`' 가 선택됨.

