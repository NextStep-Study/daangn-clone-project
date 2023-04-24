<!--
    private String name;
	private String birth;
	private String phone_num;
    @Id
    @GeneratedValue

    private Long id;
    private String email;
    private String pwd;
    private int reg_num;
    private int reg_date;

    private Address address;
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>상품 정보 등록</h2>
	  <form id="registForm" method="POST" action="${root}/product/write" >


	  	<input type="hidden" name="action" value="">

	    <div class="form-group">
	      <label for="productCode">이름</label>
	      <input type="text" class="form-control" id="userName" name="userName" placeholder="이름 입력">
	    </div>

	    <div class="form-group">
	      <label for="model">생년월일</label>
	      <input type="text" class="form-control" id="userBirth" name="userBirth" >
	    </div>

	    <div class="form-group">
          <label for="model">핸드폰번호</label>
          <input type="text" class="form-control" id="userPhone" name="userPhone" >
        </div>

	    <div class="form-group">
	      <label for="price">아이디</label>
	      <input type="number" class="form-control" id="userId" name="userId" placeholder="아이디 입력" >
	    </div>

	    <div class="form-group">
  	      <label for="price">이메일</label>
  	      <input type="number" class="form-control" id="userEmail" name="userEmail" placeholder="이메일 입력" >
       	</div>

       	<div class="form-group">
          <label for="price">비밀번호</label>
          <input type="number" class="form-control" id="userPwd" name="userPwd" placeholder="비밀번호 입력" >
      	</div>

	    <button type="submit" class="btn btn-primary" id="regist">등록</button>
	    <a class="btn btn-secondary" href="#" >취소</a>



	  </form>
	
	
	</div>
	 <script>
      document.querySelector("#userName").addEventListener("click", function () {
        if (!document.querySelector("#productCode").value) {
          alert("고유 번호!!");
          return;
        } else if (!document.querySelector("#userId").value) {
          alert("모델명 입력!!");
          return;
        } else if (!document.querySelector("#userBirth").value) {
                    alert("모델명 입력!!");
                    return;
        } else if (!document.querySelector("#model").value) {
                    alert("모델명 입력!!");
                    return;
        } else if (!document.querySelector("#model").value) {
                    alert("모델명 입력!!");
                    return;
        }
        else {
          let form = document.querySelector("#registForm");
     /*      form.setAttribute("action", "${root}/shop"); */
          form.submit();
        }
      });
    </script>
	<%-- --%>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
