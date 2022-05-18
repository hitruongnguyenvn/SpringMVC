<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News List</title>
</head>
<body>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<c:if test="${not empty alert}">
					<div class="alert alert-${alert}" role="alert">
						<strong>${message}</strong>
					</div>
				</c:if>
				<div>
					<form id="login-form" style='display: inline-block;' class="form"
						action="#" method="post">
						<button id="" type="submit"
							class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
							data-toggle="tooltip" title='Them Bai Viet'>
							<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
							</span>
						</button>
					</form>
					<button id="btnDelete" type="button"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Xoa bai viet'>
						<span> <i class="fa fa-trash-o bigger-110 pink"></i>
						</span>
					</button>
				</div>

				<div class="row">
					<div class="col-xs-12">
						<table class="table table-striped">
							<thead>
								<tr>
									<th><input type="checkbox" value="" id="checkBoxAll"></th>
									<th>Ten bai viet</th>
									<th>Mo ta ngan</th>
									<th>Thao Tac</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model.getModels()}">
									<tr>
										<td><input type="checkbox" value="${item.getId()}"
											id="checkBox_${item.getId()}"></td>
										<td>${item.getTitle()}</td>
										<td>${item.getShortDescription()}</td>
										<td>
											<form id="login-form" style='display: inline-block;'
												class="form"
												action="<c:url value='/admin-news?id=${item.getId()}'></c:url>"
												method="post">
												<button id="" type="submit"
													class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
													data-toggle="tooltip" title='Cap nhat bai viet'>
													<span> <i class="fa fa-pencil-square-o"
														aria-hidden="true"></i>
													</span>
												</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<form action="<c:url value='/admin/news/list'></c:url>" id="formSubmit" name="formSubmit">
						<ul class="pagination" id="pagination"></ul>
						<input type="hidden" id="page" name="page" value="">
						<input type="hidden" id="maxPageItem" name="maxPageItem" value="">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	<script>
		$(function() {
			var currentPage = ${model.getPage()};
			var fetchNextRows = 3;
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : ${model.getTotalPage()},
				visiblePages : 4,
				startPage: currentPage,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#page').val(page);
						$('#maxPageItem').val(fetchNextRows);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</body>
</html>