<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home for Admin</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="<c:url value='/template/admin/css/styles.css'></c:url>"	rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"	crossorigin="anonymous"></script>
<!-- lib paging -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.js'></c:url>"></script>
<!-- lib paging -->
</head>
<body class="sb-nav-fixed">
	<%@include file="/common/admin/header.jsp"%>
	<div id="layoutSidenav">
		<%@include file="/common/admin/menu.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<dec:body></dec:body>
			</main>
			<%@include file="/common/admin/footer.jsp"%>
		</div>
	</div>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src='<c:url value='/template/admin/js/scripts.js'></c:url>'></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"	crossorigin="anonymous"></script>
</body>
</html>