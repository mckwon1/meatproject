<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
 
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberHeader</title>
</head>
<body>
<jsp:include page="memberHeader.jsp"/>
<h1>회원 가입</h1>

<form id='newMember'>
	<table>
		<tr>
			<td>이름</td>
			<td colspan="3"><input type="text" name="userNm"></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="number" name="userPhon1" id="userPhon1" maxlength="3">-</td>
			<td><input type="number" name="userPhon2" id="userPhon2" maxlength="4">-</td>
			<td><input type="number" name="userPhon3" id="userPhon3" maxlength="4"></td>
		</tr>
		<tr>
			<td>포인트</td>
			<td colspan="3"><input type="number" name="userPoint" value="0"></td>
		</tr>
		<tr>
			<td colspan="2"><input id="saveBtn" type="button" value="등록"></td>
		</tr>
	</table>
</form>
</body>
<script>
$(function(){
	
	$('#saveBtn').on('click', formSave);
	$('#userPhon1').on('keyup', function(){
		if($('#userPhon1').val().length >= 3){
			$('#userPhon2').focus();
		}
		
	});
	$('#userPhon2').on('keyup', function(){
		if($('#userPhon2').val().length >= 4){
			$('#userPhon3').focus();
		}
		
	});
	
	
});

function formSave(){
	
	$.ajax({
		  url: '/user/newMemberInsert',
		  data: $('#newMember').serialize(),
		  success: function(ob){
			  alert(ob.result);
		  },
	});
	
}

</script>
</html>