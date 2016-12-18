<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>로그인페이지</title>  
</head>
<body>
<h2>로그인 </h2>
<form id="loginForm" name="loginForm" method="post" action="loginProcess">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<table>
    <tr height="40px">
        <td>사용자아이디</td>
        <td><input type="text" id="shopId" name="shopId"></td>
    </tr>
    <tr height="40px">
        <td>패스워드</td>
        <td><input type="text" id="shopPw" name="shopPw"></td>
    </tr>
</table>
<table>
    <tr>
        <td align="center"><input type="button" id="loginBtn" name="loginBtn" value="로그인"></td>
    </tr>
</table>
</form>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

$(function() {
	
	$('#loginBtn').click(function () {
		console.log($('#loginForm').serialize());
		 $.ajax({
	           type:"POST",
	           url:"/loginProcess",
	           data : $('#loginForm').serialize(),
	           dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	           success : function(data) {
	        	  	console.log('1');
	                 if (data.success) {
	                	 location.href=data.returnUrl 
	                 } else {
	                	 alert(data.message);
	                 }
	                 //console.log(data);
	               //alert('성공');
	           },
	           complete : function(data) {
	                 // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	                 // TODO
	           },
	           error : function(xhr, status, error) {
	                 //alert("에러발생");
	                 console.log(xhr);
	                 console.log(status);
	                 console.log(error);
	           }
	     });

	});
});


</script>

</body>
</html>