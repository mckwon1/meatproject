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
	<table id="dataList" class="display" cellspacing="0" width="100%">
		<colgroup>
		<col width="20%">
		<col width="50%">
		<col width="20%">
		</colgroup>
		
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>포인트</th>
			</tr>
		</thead>


	</table>
</body>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.13/css/dataTables.jqueryui.min.css"/>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/dataTables.jqueryui.min.js"></script>
<style type="text/css">
table tr td{text-align: center; }
</style>
<script>
$(function(){
	/* dataTable Start */
	var table = $('#dataList').DataTable({
			"processing": true,
	        "ajax": '/user/listMember',
	        "info":     false,
        	 "columns": [
                 { "data": "user_name" },
                 { "data": "phone" },
                 { "data": "user_point" },
             ],
             "language": {
                 "lengthMenu": "Show _MENU_",
                 "zeroRecords": "테이터가 없습니다.",
                 "search": "검색 :",
                 "paginate": {
                     "first":      "처음",
                     "last":       "마지막",
                     "next":       "다음",
                     "previous":   "이전"
                 },
             }
	});
	
	$('#dataList tbody').on('click', 'tr', function(){
	        var data = table.row( this ).data();
	        location.href = "/user/memberView?id="+data.seq;
	 });
	
});
</script>
</html>
