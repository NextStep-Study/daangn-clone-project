package com.daangn.daangn.domain.Member;

public class Address {

    private String city; //do, ��
    private String si;
    private String code;
    

    protected Address() {
    }
    
    protected Address(String city, String si, String code) {
    	this.city=city;
    	this.si=si;
    	this.code=code;
    }


}
