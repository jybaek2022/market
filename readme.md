## 쇼핑몰 ##
본 프로젝트는 "건강한 펫"이라는 쇼핑몰이다.

### 개발 환경 ### 
    Programming Language - Java 1.8
    IDE - Eclipse
    DB - MySQL
    Server Framework - Spring 4, JSP, JSTL
    ORM - MyBatis
    Build Tool - Maven

### 주요 기능 ###
* 사용자 기능
  * 회원가입/로그인
  * 마이페이지
* 쇼핑몰 기능
  * 장바구니
  * 판매하기, 구매하기
  * 판매, 구매내역보기
  * 상품 추천하기
* 관리자 기능
  * 통계
* 게시판
  * 이벤트
  * 커뮤니티
  
### 설계 및 구조 ###
* MVC Model
* Pagination
* DB
  * cart : 장바구니
  * category : 카테고리
  * member : 회원
  * product : 제품
  * sales : 거래내역
  * board : 게시판