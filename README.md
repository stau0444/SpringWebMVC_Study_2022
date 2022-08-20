## Spring Web MVC

---

#### WEB 애플리케이션이란?

- 인터넷을 통해 웹 브라우저에서 이용 할 수 있는 응용 소프트웨어를 말한다.
- SNS ,웹 메일 , 전자상거래 , 인터넷 게시판 ,블로그 등 다양한 기능을 제공한다.

---

#### HTTP(hyper Text Transfer Protocol)

- 웹 브라우저와 웹 애플리케이션 서버가 통신시 사용하는 프로토콜
- 클라이언트가 요청을 보내면 ,서버가 응답하는 단순한 구조로 만들어졌다.
- 무상태 프로토콜로 각각의 요청과 응답은 모두 독립적인 요청과 응답이다.
- Http 요청은 메서드 , 주소 , 헤더 세가지 요소로 구성되어 있다.

#### Http Method

- 서버에 요청을 보내는 방법으로 총 9가지 명령으로 이루어져 있다.
- 클라이언트는 요청시 메소드를 통해 주어진 자원에 수행하길 원하는 행동을 나타낸다.
- 웹 브라우저는 GET과 POST 2가지 메소드를 기본적으로 제공하며 나머지 명령은 Javascript같은 범용 프로그래밍 언어를 이용해야 사용가능하다.

#### 요청의 구조

| 구분   | 요청                                                                                          | 특징                                   |
|------|---------------------------------------------------------------------------------------------|--------------------------------------|
| 시작라인 | GET/blog/posts?page=1&size=10 HTTP/1.1                                                      | Http메소드 , 콘텐트 경로 , 프로토콜 버전이 명시되어 있다. |
| 요청헤더 | Host:blog.ugosdev.com                                                                       |                                      |
|      | User-Agent:Mozilla/5.0 (Machintosh; Intel Mac OS 10.9; rv:36.0) Gecko/20100101 Firefox/36.0 | 요청을 보내는 클라이언트에 대한 정보를 담고 있다.         |
|      | Accept:text:html , application/xhtml+xml , application/xml;q=0.9, * / *;q=0.8               | 응답 받을 컨텐츠의 형태를 Mime 타입으로 서버에 알려준다.   | 
|      | Accept-Language:en-US,en;q=0.5                                                              |                                      |
|      | Accept-Encoding:gzip,deflate                                                                |                                      |
|      | Connection:keep-alive                                                                       |                                      |
|      | Cache-Control:Max-age=0                                                                     |                                      |

#### 응답의 구조

| 구분    | 요청                                                         | 특징                         |
|-------|------------------------------------------------------------|----------------------------|
| 상태 라인 | HTTP/1.1 200 OK                                            | 프로토콜/버전 상태코드 상태코드 값 으로 이뤄짐 |
| 응답 헤더 | Content-Language:ko-KR                                     |                            |
|       | Content-Type :text/html;charset=UTF-8                      | 응답 본문의 타입을 Mime 타입으로 알려준다. |
|       | Content-Length:3432                                        |                            |
|       | Date:Tue , 16 Dec 2014 10:56:19 GMT                        |                            |
|       | Server:Apache-Coyote/1.1                                   |
|       | Set-Cookie:JSESSIONID=C124124124124124124124124124dA; Path=/ |                            |
| 응답 본문 | `<HTML><img src="asdasdasd.com"></HTML> `                    |                            |




#### 상태코드

- 요청에 대한 응답 상태 , 웹 브라우저는 상태코드에 따라 동작방식을 결정한다.
- 5가지유형(1xx,2xx,3xx,4xx,5xx)의 총 60여개 표준 상태가 정의되어있다.

| 유형           | 상태코드 예시                                                                                                                           |
|--------------|-----------------------------------------------------------------------------------------------------------------------------------|
| 1xx/조건부 응답   | 100(계속): 요청자는 요청을 계속해야 한다. </br> 101(프로토콜 전환):요청자가 서버에 프로토콜 전환을 요청했으며 서버는 이를 승인하는 중이다.                                            |
| 2xx/성공       | 200(성공) : 서버가 요청을 제대로 처리했다는 뜻이다. </br> 201(작성됨) : 성공적으로 요청되었으며 서버가 새 리소스를 작성했다.                                                   |
| 3xx/리다이렉션 완료 | 300(영구 이동): 요청한 페이지를 새 위치로 영구적으로 이동했다. </br> 302(임시 이동): 현재 서버가 다른 위치의 페이지로 요청에 응답하고 있지만 요청자는 향후 요청 시 원래 위치를 계속 사용해야한다.           |
| 4xx/클라이언트 오류 | 400(잘못된 요청): 서버가 요청의 구문을 인식하지 못함 </br> 404(찾을 수 없음): 서버가 요청한 페이지를 찾을 수 없음                                                         |
| 5xx/서버 오류    | 500(내부 서버 오류): 서버에 오류가 발생하여 요청을 수행할 수 없다. </br> 503(서비스를 사용할 수 없음): 서버가 오버로드되었거나 유지관리를 위해 다운되었기 떄문에 현재 서버를 사용할 수 없음  (대개는 임시적 상) |


#### MIME 타입

- 서버 또는 클라이언트에게 전송된 리소스의 유형을 알려주기 위한 메커니즘이다.
- 브라우저는 리소스를 받았을 때 해야 할 기본 동작을 결정하기 위해 대게 MIME 타입을 사용한다.
- 브라우저는 응답받은 데이터가 HTML이나 IMG 타입이라면 출력을 하고 바이너리 데이터 타입이라면 다운로드하여 로컬 디스크에 저장한다. 
- '/'로 구분된 두개의 무자열인 타입과 서브타입으로 구성된다.

---

#### HTML

- 웹 문서를 만들기 위한 언어로 웹 브라우저 위에서 동작하는 마크업 언어이다.
- 웹 문서를 구성하기 위해 만들어진 여러가지 태그로 작성한다.
- 발표된 후 여러번의 개선 과정을 통해 HTML5 버전까지 공개되어 있다.

---
#### URL (Uniform Resource Locators)

- 인터넷 상에서 자원이 어디 있는지를 알려주기 위한 주소 규약이다.
- 웹 페이지 뿐만 아니라 네트워크상의 모든 자원에 대한 주소를 표현할 수 있다.
- 대부분 URL은 다음과 같은 형식, []로 표시된 부분은 생략할 수 있다

```
protocol://[host.]domain[:port][/context][/resource]
```

- protocol : 클라이언트와 서버가 대화할때 사용하는 통신 규약 , 웹 애플리케이션은 HTTTP, HTTPS를 사용한다.
- domain: 네트워크에 연결된 장치에 부여된 고유한 이름이다 , 도메인 네임 시스템(DNS) 계층에서는 서브 도메인이라 부른다.
- port: 네트워크 장치의 특정 프로그램에 접근하기 위한 논리적 주소 생략시 프로토콜에 따라 지정된 포트를 사용한다.

---

#### 정적 콘텐트와 동적 콘텐트

- 정적 콘텐트 : 이미지 , 스타일 시트(css) , 자바스크립트 등 변하지 않는 콘텐트를 의미한다.
- 동적 콘텐트 : 서버가 HTTP 요청을 해석한 후 프로그램을 실행하고 그 결과값으로 만들어낸 콘텐츠를 의미한다(요청에 따라 응답하는 데이터가 달라진다.).
 

---

#### 자바 서블릿과 JSP

- Java EE에 속한 기술로 자바 웹 애플리케이션의 기반 기술이다 .
- 웹 콘텐트를 동적으로 생성하는 서버측 자바 프로그램이다.
- Java EE 컨테이너 또는 서블릿 컨테이너에서 동작한다.
- JSP는 자바 코드와 HTML을 섞어서 사용할 수 있는 기술이며 런타임시 자바의 서블릿으로 컴파일된다.
- JSP 만을 사용하여 개발하는 방식을 'Model 1'이라 부른다.
- modle1 방식은 빠르게 웹앱을 개발할 수 있지만 규모가 커지면 유지보수가 어려워지는 단점을 갖는다.

---

#### 서블릿 컨테이너란?

- 네트워크 통신 제어(http 요청/응답) , 스레드 기반 병렬처리를 담당한다.
- 서블릿고 JSP 생명주기를 관리한다.
- 다수의 웹 애플리케이션을 실행할 수 있고 개별로 환경을 관리한다.


---

#### 스프링 웹 애플리케이션

- 리액티브 스택 , 서블릿 스택 크게 두가지로 나뉜다.

#### Servlet Stack

- 스프링 5.0 이후로 리액티브스택이 추가되었으다 
- 서블릿 스택은 Spring MVC 기술을 기반으로 구성되어있으며
- Servlet API를 기반으로 스레드당 하나의 요청을 처리하는 모델로
- 동기화된 블록킹 I/O 아키텍처가 사용되었다.


#### Reactive Stack 

- 스프링 웹 플럭스 프레임워크를 기반으로 구축되었다
- 멀티 코어의 차세대 프로세스를 활용해서 동시에 많은 요청을 처리하기 위해 만들어진
- Non-Blocking I/O 방식의 웹 프레임 워크이다.
- Netty 혹은 Servlet 3.1 + 컨테이너에서 동작한다.

---

### Spring MVC

- 스프링 프레임워크를 구성하는 모듈 , 정식 명칭은 Spring Web MVC 이다
- 서블릿 API를 기반으로 작성된 웹 프레임워크이다.
- 프론트 컨트롤러 패턴과 MVC 아키텍쳐 패턱을 제공한다.
- 유연하고 확장성이 뛰어난 구조를 제공한다.
- 견고한 웹 애플리케이션을 만드는데 도움이 되는 풍부한 기능을 제공한다.
- 자바 언어의 애노테이션과 리플렉션 API를 적극 활용한다
- 애노테이션 기반 프로그래밍 모델을 제공한다.
- 경량 함수형 프로그래밍 모델을 지원한다.
- CoC(Convention over Configuration 설정보다 관례)를 지원한다.

#### Spring MVC 요청 , 응답 흐름

- 프론트 컨트롤러인 DispatcherServlet을 중심으로 동작한다.
- MVC가 협력해 웹 요청과 응답을 처리한다.

<img width="544" alt="스크린샷 2022-08-20 오전 10 48 38" src="https://user-images.githubusercontent.com/51349774/185724672-64cd6c01-e133-4999-8826-bbdc71c60a5e.png">

#### Model View Controller 패턴

- 화면의 구성요소와 데이터를 담은 모델
- 화면의 출력 로직을 담은 뷰
- 애플리케이션 제어 로직을 담은 컨트롤러
- 위 세가지의 요소로 구성되어 있다. 

#### 프론트 컨트롤러 패턴

- 컨트롤러를 대표해서 모든 요청과 응답을 대응한다.
- 요청 및 응답에 대한 횡단 관심사(예외처리 , 보안 등)을 적용한다.
- 적절한 하위 컨트롤러에게 작업 위임 , 뷰 선택 및 결과를 출력한다.


#### 애노테이션 기반 프로그래밍 모델

- @Controller , @RequestMapping 등 다양한 애노테이션을 제공한다.
- 애노테이션을 통한 요청 , 연결 , 데이터 가공 , 여외 처리 등을 구성한다.
- 메타 애노테이션을 통해 사용자 정의 애노테이션을 지원한다.
- 
