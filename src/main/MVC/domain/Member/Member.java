package jpabook.jpashop.domain;


/*
id [자신이 설정하는 닉네임 개념]

최대 4-8글자까지 설정, 올바르지 않은 입력 형식에 밑에 배너로 알림

영어, 숫자 조합 -> 정규식

email [구글 계정 로그인 API 사용시 로그인 요소(미정) or 회원 가입 시 입력 정보]

최대 32글자 까지 설정->올바르지 않은 입력 형식에 밑에 배너로 알림

XXX@XXX.XXXX로 입력 -> 정규식

password [회원 가입 시 설정, 로그인 시 권한 부여 여부를 결정하는 요소 (Id, Password)]

최대 8-12글자까지 설정, 올바르지 않은 입력 형식에 배너로 알림

영어(대소문자), 숫자, 특수 문자 조합-> 정규식
 */


//getter setter를 어노테이션으로 쓰는 것 같다 !!!


public class Member {

	private String name;
	private String birth;
	private String phone_num;
    private Long id;
    private String email;
    private String pwd;
    private int reg_num; //DB가 자동으로 부여하는 고유 번호
    private int reg_date;

    // HOW???????
    @Embedded
    private Address address;
    
    /*
 	위에 처럼 Adress 클래스를 따로 뺄까 아니면 아래 처럼 한번에 선언할지 ,,
 	private String city;
 	private String street;
 	private String zipcode;
     */
    
    
    
    

}