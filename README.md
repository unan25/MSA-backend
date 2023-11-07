# MSA-backend
💻msa 실습 예제

1. 서버 연결
2. 필터 설정
3. 커스텀 필터 설정
4. 유레카 서버(Discovery Eureka Server / 로드밸런싱)
5. 유레카 클라이언트 예제(Discovery Eureka Client)
6. 회원가입 조회 서비스 예제
7. item-service 회원 연동 및 조회 서비스
8. Config 서버 연동 (민감정보 제공서버 구축)

파일
- apigateway - server : 게이트웨이

- first-service : 서비스 서버 1
   ㄴ 게이트 웨이, eureka 예제

- second-service : 서비스 서버 2
   ㄴ 게이트 웨이, eureka 예제

- discovery-server : Discovery Eureka Server

- discover-client : Discovery Client
   ㄴ eureka Client 예제
  
- user-service : 회원가입 조회 서비스

- item-service : 회원, 상품 연동 조회 서비스

- config-service : 민감정보 제공서버 구축

---

## | 📖프로젝트 소개

- 프로젝트 : Today Trend
- 개발 기간 : 2023.10.25 ~ 2023.12.27
- 개발인원 : 5명
    - 조장 : 권윤환
    - 부조장 : 임승혁
    - 팀원 : 최성민, 호지원
- 내용 : 패션 Web SNS


## | 👨‍👩‍👧‍👧역할 분담

- **권윤환**
    - 프로젝트 전체 관리
    - 회원, 인증/인가, 데브옵스
- **임승혁 (부조장 👑)**
    - React, 소셜 로그인, SNS
- **최성민**
    - React, 이미지 업로드
    - 관리자, 댓글
- **호지원**
    - SNS 전반적인 부분
    - 댓글
      
---    

## |✨협업 Tool

Jira, Git hub,, Figma, ERDCloud, GoolgleDocs 

---

## 📢커뮤니케이션 규칙

1. **자료방, 질문방, 자유채팅방 구분하기**
    1. ex) 디스코드 #자료방 #질문방 #채팅방
2. **궁금한 거 생기면 바로바로 물어보기**
    1. 디스코드 질문방에 물어보기 (모두가 공유할 수 있도록)
    2. 답장은 천천히 해도 됨
3. **결석 공유하기 (단톡방 공유)**
    1. 중요한 날, 타당한 사유 없이 결석하는 경우 커피☕ 쏘기
        1.  ex) 스프린트 작성 날, 스프린트 작성 날 제외 다 같이 따로 회의 약속 잡은 날
    2. 개인 스케줄, 스케줄에 적고 말해주기
        1. [](https://www.notion.so/2172e3b459ee4dcc838923b308577dd8?pvs=21) 
    3. 팀원 모두가 공유할 수 있도록 해주기
    4. 휴가는 언제든지 가능(미리 말 해주기)
    5. 지각 및 조퇴 공유하기
        1. ex) 오후 몇 시까지는 갑니다요 ~
    6. 결석 사유는 말 안 해줘도 됨.
4. **퇴근 시간은 정해지지 않음(칼퇴 가능)**
    1. 대신 정해진 일은 정해진 기간 내에 끝내기
5. **회의 및 스프린트,  스크럼**
    1. 회의 및 스프린트 작성 : 매주 월요일 16:00 (+유연)
    2. 스크럼 : 매일 (월요일 제외) 17:00
        1. 하위 이슈는 깃 허브 이슈에 등록 (개발 관련)
        2. https://blog.sphinfo.com/index.php/2021/04/20/agileplanning/ 블로그 참고
    3. 스프린트 작성은 돌아가면서 맡은 사람이 노션에 문서화 하기.
        1.  [스프린트 & 스크럼](https://www.notion.so/d9659392183e479c946aaf263d2f4955?pvs=21) 
6. **상대방 존중하기**
    1. 말 함 부로 하지 않기
        
        ex) 화나도 다같이 있는 곳에서는 함부로 말하지 않기 
        
        (기준은 강사님께 똑같이 행동했을 때 할 수 있을 것인가 아닌가)
        
    2. 서로 간의 의견 충돌 시, 조 원들의 의견 듣고 따르기
  
---

## ⚙개발 규칙

📌 **Commit & Push 하실 때 Pull/Request 잘 남겨주시고, 이슈 관리도 잘 해주시기 바랍니다.**

**merge는 develop에 !!!**

1. **Git Commit 메시지 규칙 지키기 (아래 사진 참고)**
    
    ex) docs : README 수정 / feat : 유저 회원가입
    
   노션 확인

---
    
3. **Git Branch 생성 규칙**
    1. master | main (배포 가능한 상태)
    2. develop (다음 출시 버전을 개발하는 브랜치)
    3. feture (기능을 개발하는 브랜치)
    4. relese (이번 출시 버전을 준비하는 브랜치)
    5. hotfix (출시 버전에서 발생한 버그를 수정하는 브랜치)
    
    ex)  회원가입 → feature/1-user-signup  |  sns feature/2-post-create
    
    참고 :  [[Git] git branch & naming](https://ej-developer.tistory.com/75)
    
---

## 🔧기술 스택

- ⌨ **백엔드 [최신 (LTS)]**
    - InteliJ
    - Java 17
    - SpringBoot 3.1.4
    - 스프링클라우드
    - Config Server
    - JPA
    - JWT
    - Spring Security
    - Gradle
    - Discovery Eureka
    - OAuth
    - Swagger
    

- 💿 **CI/CD**
    - Git
    - Docker
    - AWS
    - Jenkins
    
- 💾 **DB**
    - mySQL
    - Redis

- 🖥 **프론트**
    - React
    - React-Router-dom
    
- 📢 **ETC**
    - 소통
        - 디스코드 : 화면공유, #정보방, #공지방, #질문방
        - 카카오톡 : 자유
    - 프로젝트 관리
        - Git : 프로젝트 관리
        - Jira : 프로젝트 관리
        - Notion : 문서화
        - ERD Cloud, Figma : 설계용
