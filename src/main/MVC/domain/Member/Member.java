package jpabook.jpashop.domain;


/*
id [�ڽ��� �����ϴ� �г��� ����]

�ִ� 4-8���ڱ��� ����, �ùٸ��� ���� �Է� ���Ŀ� �ؿ� ��ʷ� �˸�

����, ���� ���� -> ���Խ�

email [���� ���� �α��� API ���� �α��� ���(����) or ȸ�� ���� �� �Է� ����]

�ִ� 32���� ���� ����->�ùٸ��� ���� �Է� ���Ŀ� �ؿ� ��ʷ� �˸�

XXX@XXX.XXXX�� �Է� -> ���Խ�

password [ȸ�� ���� �� ����, �α��� �� ���� �ο� ���θ� �����ϴ� ��� (Id, Password)]

�ִ� 8-12���ڱ��� ����, �ùٸ��� ���� �Է� ���Ŀ� ��ʷ� �˸�

����(��ҹ���), ����, Ư�� ���� ����-> ���Խ�
 */


//getter setter�� ������̼����� ���� �� ���� !!!


public class Member {

	private String name;
	private String birth;
	private String phone_num;
    private Long id;
    private String email;
    private String pwd;
    private int reg_num; //DB�� �ڵ����� �ο��ϴ� ���� ��ȣ
    private int reg_date;

    // HOW???????
    @Embedded
    private Address address;
    
    /*
 	���� ó�� Adress Ŭ������ ���� ���� �ƴϸ� �Ʒ� ó�� �ѹ��� �������� ,,
 	private String city;
 	private String street;
 	private String zipcode;
     */
    
    
    
    

}