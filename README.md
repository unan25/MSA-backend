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

[스프린트 & 스크럼](https://www.notion.so/8466652928564960977eed8f3a25b874?pvs=21) 

[개발 참고용](https://www.notion.so/33d421136a9d4783b3e48c31a1d9935f?pvs=21) 

[](https://www.notion.so/0d78b79081da4965aa5829bdea8a20ab?pvs=21) 

[T.T (Today Trend) 프로젝트 기획서](https://www.notion.so/T-T-Today-Trend-79c945ed044d4c6aabcb6f9706bbb447?pvs=21) 

기획서.docs :  https://docs.google.com/document/d/1c3OL-3ujFm0Qj7v2z1gZbOeI9wDKlpiqnzmeSQP9vQ8/edit?usp=sharing

[API 명세서](https://www.notion.so/0d78b79081da4965aa5829bdea8a20ab?pvs=21)

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
    

## |✨협업 Tool

Jira : https://unan.atlassian.net/jira/software/projects/SCRUM/boards/2

Git hub : https://github.com/unan25/-TodayTrend

[](https://www.figma.com/files/project/113809277)

[ERDCloud](https://www.erdcloud.com/team/EwjtbhTTawXqcpXA8)

ERD Detail : https://docs.google.com/spreadsheets/d/1C7iN0mrAWcfM2I1XmTWf0C-McXoGwBpusCJHVTlFz0g/edit?usp=sharing

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

## ⚙개발 규칙

📌 **Commit & Push 하실 때 Pull/Request 잘 남겨주시고, 이슈 관리도 잘 해주시기 바랍니다.**

**merge는 develop에 !!!**

1. **Git Commit 메시지 규칙 지키기 (아래 사진 참고)**
    
    ex) docs : README 수정 / feat : 유저 회원가입
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/38899a17-aac5-40af-ba91-7b187416a31a/b9ffbcba-d77f-4cc7-aa68-1b6f9691668e/Untitled.png)
    
2. **Git Branch 생성 규칙**
    1. master | main (배포 가능한 상태)
    2. develop (다음 출시 버전을 개발하는 브랜치)
    3. feture (기능을 개발하는 브랜치)
    4. relese (이번 출시 버전을 준비하는 브랜치)
    5. hotfix (출시 버전에서 발생한 버그를 수정하는 브랜치)
    
    ex)  회원가입 → feature/1-user-signup  |  sns feature/2-post-create
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/38899a17-aac5-40af-ba91-7b187416a31a/49241703-a5e6-40fd-a962-8fdd4908d0e2/Untitled.png)
    
    참고 : 
    
    [[Git] git branch & naming](https://ej-developer.tistory.com/75)
    

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

## 📜기능 명세서

[기능명세서](https://www.notion.so/c6ed862f4f064631ae33816b4b06f5f4?pvs=21)

- ← 한 눈에 보기
    
    (이미지 더블클릭)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/38899a17-aac5-40af-ba91-7b187416a31a/1188d4f7-12ea-4c9d-93c3-592a887bc190/Untitled.png)
    

이거는 선택 사항

- SNS
    - 게시물 : 게시물 업로드(+사진 필수)
        - 첫 화면은 캐시 데이터 …
        - 그 이후에는 서버에서 이미지 불러옴
        - 어케 구현함? 몰?루
    - 좋아요(+댓글), 댓글, 공유 기능
    - 검색 필터 라벨링
        - ex) onthelook App 필터 검색 기능
    - 친구 태그
        - GPS 연동 위치 표시
    - 스토리
    - 알람
    - 게시물 눌렀을 때
        - 아래에 게시물 올릴 때 선택한 태그 목록
        - 사진, 댓글, 해당 유저의 다른 스타일 업로드
        - 유저의 비슷한 스타일 업로드
- 유저
    - 회원가입 (+ 소셜 로그인)
        - 관심사 3개 선택 ( ex. 개발, 영화, 풍경, 패션 등…)
            - 위 관심사를 토대로 첫 화면 게시(데이터 관리…)
        - 관심사 3개 선택 ( ex. 캐주얼, 미니멀, 스트릿 등…) - 컨셉 : 패션
            - (팔로우, 팔로워 없을 때) 첫 게시물들은 위 관심사를 토대로 뱃지 개수, 등급 순, 좋아요, 팔로우 순 으로 게시물 노출
    - 마이페이지
        - 내가 작성한 게시물 조회 및 수정
        - 개인정보 수정
    - User간에 팔로워, 팔로잉
    - 프로필 : 본인 계정의 프로필 설정 (배경 및 프로필 사진, 자기소개 등)
    - 뱃지, 등급 : 특정 활동에 따른 뱃지 및 등급 지급(SNS 활성화 목적)
    - 알람 기능 : 게시물 댓글, 좋아요 반응에 따른 알람 기능
    - 랭킹 (포인트 지급)
        - 럭키드로우 할인 및 확률 업
- DM
    - 팔로우 끼리 DM
    - 팔로우가 아닌 경우 처리
- 관리자
    - 게시물, 게시글 관리
    - 커뮤니티 카테고리 관리(카테고리 생성 및 페이징 처리)
    - 댓글 관리
    - 뉴스 관리
    - 사이트 관리 (브라우저 탭, 설명, 규칙 등)
    - 관리자 권한
        - Master
            - 권한 관리 및 Admin의 기능 동일 관리
        - Admin
            - 위 기능 관리
        - Member = 유저
- 커뮤니티
    - 카테고리 별 게시글 작성
    - 댓글, 대댓글
    - 좋아요, 공유, 신고 기능
    - 인기게시글 표시(좋아요, 조회수)
    - 오늘의 패션왕
    - 투표 기능( ex) 뭐가 더 이뻐요? 투표 기능 올리기)
- ETC
    - 실시간 인기 검색어 랭킹 기능
        - 전체 및 카테고리 별 랭킹
        - ex) 패션 : 1위 후드티 / 2위 경량패딩 등…
    - 뉴스
        - 해당 카테고리 별 뉴스 스크랩

---
