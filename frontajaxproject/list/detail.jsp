<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<script type = "text/javascript" src = "../js/jquery-1.12.4.min.js"></script>
<script type = "text/javascript" src = "../js/jquery.bxslider.min.js"></script>

<script type = "text/javascript">

 
 var loadData=function(num){
	 $.ajax({
// 		 console.log("loadData");
		  url: 'one.do',
		  type: 'get',
		  contentType:'application/x-www-form-urlencoded; charset=UTF-8',
		  data: {num:num},
		  dataType: "json",
		  success: function(data){
							console.log(data);
					$('#content input')
							.eq(0).val(data.list[0].subject)
							.end().eq(1).val(data.list[0].content)
							
						},
			  error: function(xhr,status,err){
				  alert("에러("+status+")");
				  console.log(status);
				  console.log('---------------');
				  console.log(err);
			  }
			});
	};


	$(function(){
		var num=location.search.substr(location.search.indexOf('=')+1);
		loadData(num);
		
	});
</script>

</head>
<h2>detail page</h2>
<!-- <table class="table"> -->
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th>num</th> -->
<!-- 			<th>subject</th> -->
<!-- 			<th>content</th> -->
<!-- 			<th>date</th> -->
<!-- 			<th>content</th> -->
<!-- 		</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
<!-- <!-- 			<tr> --> -->
<%-- <%-- 				<td><a href="${detail }">${bean.deptno }</a> </td> --%> --%>
<%-- <%-- 				<td><a href="${detail }">${bean.dname }</a> </td> --%> --%>
<%-- <%-- 				<td><a href="${detail }">${bean.loc }</a> </td> --%> --%>
<%-- <%-- 				<td><a href="${detail }">${bean.loc }</a> </td> --%> --%>
<%-- <%-- 				<td><a href="${detail }">${bean.loc }</a> </td> --%> --%>
<!-- <!-- 			</tr> --> -->
<!-- 	</tbody> -->
<!-- </table> -->


<h2>상세페이지</h2>
<form id="content">
	<div class="form-group">
		<label for="subject">subject</label>
		<input type="text" name="subject" id="subject" class="form-control">
	</div>
	<div class="form-group">
		<label for="content">content</label>
		<input type="text" name="content" id="content" class="form-control">
	</div>
<!-- 	<div class="form-group"> -->
<%-- 		<label for="loc">loc</label><span>${FieldErrors.loc }</span> --%>
<%-- 		<input name="loc" id="loc" value="${bean.loc }" class="form-control"> --%>
<!-- 	</div> -->
	<div class="form-group">
		<button class="btn btn-primary" type="submit">수정</button>
		<button type="reset" class="btn btn-default">취소</button>
	</div>
</form>



</body>
</html>