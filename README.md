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
- ...
  
![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)


## 📂 파일 구조
```bash
.
└── main
    ├── java
    │   └── com
    │       └── poscodx
    │           └── jblog
    │               ├── controller
    │               │   ├── BlogController.java
    │               │   ├── MainController.java
    │               │   └── UserController.java
    │               ├── repository
    │               │   └── UserRepository.java
    │               ├── security
    │               │   ├── Auth.java
    │               │   ├── AuthInterceptor.java
    │               │   ├── AuthUser.java
    │               │   ├── AuthUserHandlerMethodArgumentResolver.java
    │               │   ├── LoginInterceptor.java
    │               │   └── LogoutInterceptor.java
    │               ├── service
    │               │   └── UserService.java
    │               └── vo
    │                   └── UserVo.java
    ├── resources
    │   ├── applicationContext.xml
    │   ├── logback.xml
    │   └── mybatis
    │       ├── configuration.xml
    │       └── mappers
    │           ├── board.xml
    │           ├── guestbook.xml
    │           ├── site.xml
    │           └── user.xml
    └── webapp
        ├── WEB-INF
        │   ├── spring-servlet.xml
        │   ├── views
        │   │   ├── blog
        │   │   │   ├── admin-basic.jsp
        │   │   │   ├── admin-category.jsp
        │   │   │   ├── admin-write.jsp
        │   │   │   └── main.jsp
        │   │   ├── error
        │   │   │   ├── 404.jsp
        │   │   │   └── 500.jsp
        │   │   ├── includes
        │   │   │   └── menu.jsp
        │   │   ├── main
        │   │   │   └── index.jsp
        │   │   └── user
        │   │       ├── join.jsp
        │   │       ├── joinsuccess.jsp
        │   │       └── login.jsp
        │   └── web.xml
        └── assets
            ├── css
            │   └── jblog.css
            ├── images
            │   ├── bul1.gif
            │   ├── bul2.gif
            │   ├── check.png
            │   ├── delete.jpg
            │   ├── logo.jpg
            │   └── spring-logo.jpg
            └── js
                └── jquery
                    └── jquery-1.9.0.js
```
   
## 🛠️ 구현 과정
### DB 설계
> <img width="700" alt="image" src="https://github.com/newjee/jblog/assets/31722578/1971f22e-926b-4af9-b404-a56768c4a977">

### 회원 기능
- UserController -> UserService -> UserRepository
기능          |  description
-------------|----------------------------------------------------------------------
회원가입을 한다. |  UserController>join
로그인을 한다.  |  UserController>login </br> -> AuthenticationFilter
회원가입을 하면 해당 사용자의 블로그가 자동 생성.   |  데이터 저장 및 조회

#### auth 설정

### 블로그 기능

### admin 기능

### 로그 설정
- logback.xml


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)


## 🍃 spring 나만의 wa-ggu 정리

### MVC 구조

MVC          |  description
-------------|----------------------------------------------------------------------
Controller   |  웹 브라우저의 req을 받음 -> req param 바인딩, 검증, res화면, res화면에 담을 model 결정 
Service      |  비즈니스 로직 수행, 트랜잭션 경계 설정, 접근 권한 확인
Repository   |  데이터 저장 및 조회
- 객체지향 분석 설계 원칙 중 '단일 책임 원칙'
***
### e.g. member 모듈
1. 사용자가 웹 브라우저에 **http:localhost:8080/member/list** URL 입력
2. 이 req는 /로 시작 -> local에서 Tomcat을 사용해 실행 -> web.xml에 등록한 DS가 처리
3. DS는 **/member/list**를 보고, MemberController가 이 req를 처리해야 함을 catch
4. MemberController는 MemberService를 사용해서 회원 목록 req
5. MemberService는 MemberRep를 사용해서 DB에 있는 회원 목록 조회
***
### 개발 전 설정
#### 0. maven 설정
- pom.xml : 메이븐 설정 파일
  - 기본 정보, 의존성(dependency), 저장소, 빌드 정보, 플러그인 정보 설정  
#### 1. DispatcherServlet 설정
- web.xml


settings               |  description                                                     
-----------------------|--------------------------------------------------------------------------------------------------------
서블릿 이름 설정           |  `<servlet> <servlet-name>...<serlvet-class>... </servlet>` </br> -> web/WEB-INF에 "서블릿 이름"-servlet.xml 파일을 스프링 설정파일로 사용   </br> </br> <img width="500" alt="image" src="https://github.com/newjee/jblog/assets/31722578/4365b259-0d5e-4827-af89-41988ab4931e">
서블릿 매핑               |  `<servlet-mapping> <servlet-name> ... <url-pattern>... </servlet-mapping>` </br> -> e.g. `<url-pattern>`가 / 일 경우 모든 url을 대상으로 서블릿 처리 
리스너 설정               | `<listener> ... ContextLoaderListener....` </br> -> 웹앱이 서블릿 컨테이너에 로딩될 때 실행되는 리스너  </br> -> CLL이 WebApplicationContext를 만들고 </br> -> WAC는 contextConfigLocation에 설정한 빈 설정 파일을 사용해 객체 관리 </br></br><img width="500" alt="image" src="https://github.com/newjee/jblog/assets/31722578/50fa5c01-d737-4e76-a288-3b8d1895cb85">

#### + WebApplicationContext

설정 파일    | applictionContenxt.xml |  "서블릿 이름"-servlet.xml
-----------|------------------------|-------------------------
generate   |CLL                     |DS</br>(CLL의 WAC가 있다면 상속)
descprition|웹에 종속적이지 않은 Bean    |웹에 종속적인 Bean 
e.g.       |Service, Repository     |Controller, MVC 관련
count      |애플리케이션 당 1개          |서블릿 설정 당 1개

<!--
설정 파일                | generate                           |   description         |  e.g.              | 개수 
-----------------------|------------------------------------|-----------------------|--------------------|-------------
applictionContenxt.xml | CLL                                | 웹에 종속적이지 않은 Bean  | Service, Repository| 애플리케이션 당 1개
"서블릿 이름"-servlet.xml | DS</br>(CLL의 WAC가 있다면 상속)  | 웹에 종속적인 Bean       | Controller, MVC 관련| 서블릿 설정 당 1개
-->

#### 2. applicationContext.xml 설정
- `<context:component-scan base-package="com.poscodx.jblog.service, com.poscodx.jblog.repository">`
  - @Service, @Repository를 사용한 클래스를 빈으로 등록하고 해당 빈에서 필요한 의존성을 주입
- DataSource, SqlMapClient


#### 3. spring-servlet.xml 설정
- `<context:component-scan base-package=.../controller>`
  - @Controller을 사용한 클래스를 빈으로 등록하고 해당 빈에서 필요한 의존성을 주입
- `<mvc:annotation-driven/>`
  - 애노테이션 기반의 스프링MVC를 사용할 때 필요한 모든 빈을 등록
- Content Negotiating **View Resolver**
  - 사용자에게 보여줄 뷰를 찾아주는 빈
  - 사용자가 원하는 뷰가 무엇인 지 판단 한 후, 컨트롤러의 뷰와 대조하여 최종적인 뷰를 결정
  
### 개발 (MVC)

#### 1. Controller
- 스프링 MVC의 모든 요청은 DispatcerServlet으로 처리
  - url로 들어온 요청을 DS가 catch
  - 이 요청을 처리할 Controller을 탐색
  - Ct에서 요청을 처리한 후 View 정보를 문자열(e.g. "/WEB-INF/views/hello.jsp)로 제공
  - DS에서 문자열을 기반으로 hello.jsp 파일을 찾은 후, Ct가 Model에 담은 정보를 이용해 View를 만들어 **response**


- applicationWebContext -> spring-sevlet.xml에서 설정
  - View Resolver가 view(.jsp)와 연결 -> return "" 경로 설정

- autowired로 Service 주입   
#### 2. Service
- autowired로 Repository 주입
- applicationWebContext -> applicationContext.xml에서 설정
- 


![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)


## 🗒️ IoC Container Configuration = Bean Configuration
### Configuration
- Auto configuration
 - Xml
 - Java
- Explicit Configuration
  - Xml
  - Java


 

