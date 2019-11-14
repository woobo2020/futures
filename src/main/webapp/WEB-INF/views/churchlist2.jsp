<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/resources/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/ui.jqgrid.css" />


<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>

<script type="text/javascript" src="/resources/js/i18n/grid.locale-en.js"></script>
<script type="text/javascript" src="/resources/js/jquery.jqGrid.js"></script>

<script type="text/javascript"> 
        $(document).ready(function () {
            $("#jqGrid").jqGrid({
                url: '/churchlist2.do',
                mtype: "GET",
                datatype: "json",
                colNames: ["OrderID", "CustomerID", 
                    "OrderDate", "Freight","ShipName"],
                colModel: [
                    { label: 'OrderID', name: 'OrderID', key: true, width: 75 },
                    { label: 'Customer ID', name: 'CustomerID', width: 150 },
                    { label: 'Order Date', name: 'OrderDate', width: 150 },
                    { label: 'Freight', name: 'Freight', width: 150 },
                    { label:'Ship Name', name: 'ShipName', width: 150 }
                ],
                viewrecords: true,
                height: 250,
                rowNum: 101,
                pager: "#jqGridPager"
            });
        });
</script>

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
	<div>
		<table id="jqGrid"></table>
		<div id="jqGridPager"></div>
	</div>
</body>
</html>