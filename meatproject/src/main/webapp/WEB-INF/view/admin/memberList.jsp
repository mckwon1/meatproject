<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"> </script>
<!-- <script src="//cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"> </script> -->
<h1>회원 목록</h1>
	<table id="dataList">
		<colgroup>
		<col width="50px;">
		<col width="20%">
		<col width="50%">
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

<script>
$(function(){
	
	/* dataTable Start */
	 $('#dataList').dataTable( {
	        "ajax": '/admin/listMember',
        	 "columns": [
                 { "data": "name" },
                 { "data": "position" },
                 { "data": "office" },
                 { "data": "extn" },
             ]
	    } );
		
});
</script>
</html>
