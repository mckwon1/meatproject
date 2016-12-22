<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberHeader</title>
</head>
<body>
<jsp:include page="memberHeader.jsp"/>
<h1>회원 정보 상세</h1>
<form id="member">
<input type="hidden" name="seq" value="${user.seq}">
	<table>
		<tr>
			<th>적립율</th>
			<td>
				<select id="pointReserve" name="pointReserve">
					<option value="5">5%</option>
					<option value="10">10%</option>
					<option value="15">15%</option>
					<option value="">직접</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" value="${user.user_name}" name="user_name"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="number" value="${user.phone1}" name="userPhon1" id="userPhon1" maxlength="3"></td>
			<td><input type="number" value="${user.phone2}" name="userPhon2" id="userPhon2" maxlength="4"></td>
			<td><input type="number" value="${user.phone3}" name="userPhon3" id="userPhon3" maxlength="4"></td>
		</tr>
		<tr>
			<th>현재 포인트</th>
			<td>${user.user_point}</td>
		</tr>
		<tr>
			<th>적립 포인트</th>
			<td><input type="number" id="newPoint" name="newPoint" value="0"></td>
		</tr>
		<tr>
			<th>사용 금액</th>
			<td><input type="number" id="pay" name="pay"></td>
		</tr>
		<tr>
			<td><input type="button" value="등록" id="saveBtn"></td>
		</tr>
	</table>
</form>
</body>
<script>
$(function(){
	//사용 금액 입력 적립금 적용 이벤트
	$('#pay').on('keyup', evPoint1);
	
	//적립율 변경 이벤트
	$('#pointReserve').on('change', evPoint2);
	
	//등록
	$('#saveBtn').on('click', saveUser);
	
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
	
})

function evPoint1(){
	
	var tem = $('#pointReserve').val();
	
	switch (tem) {
	case "5" :
		$('#newPoint').val(Number($('#pay').val()) * 0.05); 
		break;
	case "10" :
		$('#newPoint').val(Number($('#pay').val()) * 0.1); 
		break;
	case "15" :
		$('#newPoint').val(Number($('#pay').val()) * 0.15); 
		break;
	}
}

function evPoint2(){
	
	var tem = $('#pointReserve').val();
	
	switch (tem) {
	case "5" :
		$('#newPoint').val(Number($('#pay').val()) * 0.05); 
		break;
	case "10" :
		$('#newPoint').val(Number($('#pay').val()) * 0.1); 
		break;
	case "15" :
		$('#newPoint').val(Number($('#pay').val()) * 0.15); 
		break;
	default:
		$('#newPoint').val('0');
		break;
	}
	
}

function saveUser(){
	$.ajax({
		  url: '/user/memberUpdate',
		  data: $('#member').serialize(),
		  success: function(ob){
			  alert(ob.result);
		  },
	});
	
}
</script>

</html>