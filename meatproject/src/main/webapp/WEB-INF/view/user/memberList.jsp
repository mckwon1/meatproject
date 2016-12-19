<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList</title>
</head>
<body>
<jsp:include page="memberHeader.jsp"/>
<h1>회원 목록</h1>
	<table id="dataList" width="100%">
		<colgroup>
		<col width="10%">
		<col width="20%">
		<col width="50%">
		<col width="20%">
		</colgroup>
		
		<thead>
			<tr>
				<th>No</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>포인트</th>
			</tr>
		</thead>


	</table>
</body>

<script src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script>
$(function(){
	/* dataTable Start */
	var table = $('#dataList').DataTable( {
			"processing": true,
	        "ajax": '/user/listMember',
	        "info":     false,
        	 "columns": [
                 { "data": "seq" },
                 { "data": "user_name" },
                 { "data": "phone" },
                 { "data": "user_point" },
             ]
	    } );
	
	
	
});
</script>
</html>
