<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<td><input type="text" name="userPhon1" id="userPhon1" maxlength="3">-</td>
			<td><input type="text" name="userPhon2" id="userPhon2" maxlength="4">-</td>
			<td><input type="text" name="userPhon3" id="userPhon3" maxlength="4"></td>
		</tr>
		<tr>
			<td>포인트</td>
			<td colspan="3"><input type="text" name="userPoint" value="0"></td>
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
			  if(ob.result == 1){
				  alert('등록완료');
			  }else{
				  alert('실패');
			  }
		  },
	});
	
}

</script>
</html>