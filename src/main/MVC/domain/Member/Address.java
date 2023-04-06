package jpabook.jpashop.domain;

public class Address {

    private String city; //do, 도
    private String si;
    private String code;
    
    
    //getter seterr 생성? SPRING은 어떠한가
   
    protected Address() {
    }
    
    protected Address(String city, String si, String code) {
    	this.city=city;
    	this.si=si;
    	this.code=code;
    }


}
