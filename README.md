# WelcomeCoffee
자바 스윙을 이용한 커피 주문 어플리케이션.

## 사용법
로그인을 하고 원하는 커피를 선택할 수 있다.
1. 사이즈
2. 시럽 추가
3. 샷 추가

## 데이터 저장
+ 유저가 회원가입을 완료하면 Users.txt 파일에 회원 정보가 저장된다.
+ 주문을 하면 Orders.txt 파일에 주문 정보가 저장된다.
+ 모든 파일은 프로그램이 시작될때 ```ArrayList``` 로 변환되어 프로그램에서 사용된다.


## 프로그램 설명
+ ```Singletone Pattern``` 으로 만들어진 ```Delegator``` 에서 유저와 커피, 주문정보가 관리된다.
+ 주문 정보는 현재 로그인된 유저의 주문 정보만 출력된다.
+ 현재 로그인된 유저는 ```Delegator``` 내부에 ```Current_user``` 에 저장된다.

## 추가할 항목
+ 관리자 페이지
  + 커피 추가 등

