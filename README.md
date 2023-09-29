<h1 align="center"> jblog03 </h1>
<!-- <h3 align="center"> A Comparative Study between Different Pre-processing Approaches and Classifiers </h3>  
 -->

## :pencil: 프로젝트 개요
### 서비스 설명
- spring 프레임워크를 활용한 블로그 서비스 개발


### 서비스 기능
- 회원가입 / 로그인
- 블로그 포스팅
- 블로그 관리(admin)
  
![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)



## 🛠️ 구현 과정
### DB 설계
> ![image](https://github.com/newjee/jblog/assets/31722578/1971f22e-926b-4af9-b404-a56768c4a977)


### 회원 기능
1. 회원가입/로그인 UserController -> UserService -> UserRepository
2. 

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)


## 🍃 spring 나만의 wa-ggu 정리

### MVC 구조

MVC       |  description
----------|----------------------------------------------------------------------
Controller   |  웹 브라우저의 req을 받음 -> req param 바인딩, 검증, res화면, res화면에 담을 model 결정 
Service      |  비즈니스 로직 수행, 트랜잭션 경계 설정, 접근 권한 확인
Repository          |  데이터 저장 및 조회
- 객체지향 분석 설계 원칙 중 '단일 책임 원칙'

### e.g. member 모듈
1. 사용자가 웹 브라우저에 **http:localhost:8080/member/list** URL 입력
2. 이 req는 /로 시작 -> local에서 Tomcat을 사용해 실행 -> web.xml에 등록한 DS가 처리
3. DS는 **/member/list**를 보고, MemberController가 이 req를 처리해야 함을 catch
4. MemberController는 MemberService를 사용해서 회원 목록 req
5. MemberService는 MemberRep를 사용해서 DB에 있는 회원 목록 조회

   d
### 개발 흐름
0. **maven 설정**
   - pom.xml : 메이븐 설정 파일
      - 기본 정보, 의존성(dependency), 저장소, 빌드 정보, 플러그인 정보 설정
       
1. **DispatcherServlet 설정**
   - web.xml
      - 서블릿 이름 설정 및 매핑
      - <servlet> <servlet-name>...<serlvet-class>... </servlet>
      - <servlet-mapping> <servlet-name> ... <url-pattern>... </servlet-mapping>
      - -> web/WEB-INF에 "서블릿 이름"-servlet.xml 파일을 스프링 설정파일로 사용
      - -> e.g.<url-pattern>/ 일 경우 모든 url을 대상으로 서블릿 처리

1-1. **spring-servlet.xml 설정**
   - <context:component-scan base-package=.../controller>


2. **Controller**
   - 스프링 MVC의 모든 요청은 DispatcerServlet으로 처리
      - url로 들어온 요청을 DS가 catch
      - 이 요청을 처리할 Controller을 탐색
      - Ct에서 요청을 처리한 후 View 정보를 문자열(e.g. "/WEB-INF/views/hello.jsp)로 제공
      - DS에서 문자열을 기반으로 hello.jsp 파일을 찾은 후, Ct가 Model에 담은 정보를 이용해 View를 만들어 **response**
    
   
   - applicationWebContext -> spring-sevlet.xml에서 설정
     - View Resolver가 view(.jsp)와 연결 -> return "" 경로 설정
    
  - autowired로 Service 주입
3. **Service**
   - autowired로 Repository 주입
   - applicationWebContext -> applicationContext.xml에서 설정
   - 

   

