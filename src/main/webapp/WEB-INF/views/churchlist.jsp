<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link href="/resources/css/bootstrap.css" rel="stylesheet">

<style type="text/css">
#box
{
 position: absolute;
 width: 500px;
 left: 50%;
 top: 50%;
 margin-left: -250px;
 margin-top: -250px;
 border: #000 solid 1px;
}

</style>
</head>
<body>
	hello church list
	<br />
	<br />
	<br />
	<br />
	<br />

	<div id="box">
	<table border="5px solid black">
		<colgroup>
			<col width="20%">
			<col width="30%">
			<col width="40%">
		</colgroup>
		<thead>
			<tr>
				<th>FIRST</th>
				<th>SECOND</th>
				<th>THIRD</th>
			</tr>
		</thead>
		<c:forEach var="item" items="${list}">
		<tbody>
			<tr>
				<td style="text-align: center;">${item.name}</td>
				<td style="text-align: center;">${item.church_name}</td>
				<td style="text-align: center;">${item.church_category}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
		<nav class="text-center pt20">
						<ul class="pagination">
							<li>1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
						</ul>
					</nav>
	</div>
</body>
</html>