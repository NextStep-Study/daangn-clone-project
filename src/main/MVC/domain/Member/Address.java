package jpabook.jpashop.domain;

public class Address {

    private String city; //do, ��
    private String si;
    private String code;
    
    
    //getter seterr ����? SPRING�� ��Ѱ�
   
    protected Address() {
    }
    
    protected Address(String city, String si, String code) {
    	this.city=city;
    	this.si=si;
    	this.code=code;
    }


}
