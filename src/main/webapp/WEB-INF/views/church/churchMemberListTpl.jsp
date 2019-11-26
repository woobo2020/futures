<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List"%>
<%@ page import="com.escape.domain.ChurchMember"%>
<%@ page import="com.escape.common.Pager"%>

<%

@SuppressWarnings("unchecked")
List<ChurchMember> list = (List<ChurchMember>)request.getAttribute("list");

String totalCnt = (String)request.getAttribute("totalCnt");
Pager pager = (Pager)request.getAttribute("pager");
int index = 1;
if(pager != null){
	index = pager.startItem;
}

%>

<div class="row" style="display: block;">
	<div class="col-md-12 col-sm-12  ">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					총 갯수(<%=totalCnt %>)
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-wrench"></i></a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#">이메일 발송</a> <a
								class="dropdown-item" href="#">센터 발송</a>
						</div></li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>

			<div class="x_content">

				<p>
					Add class
					<code>bulk_action</code>
					to table for bulk actions options on row select
				</p>

				<div class="table-responsive">
					<table class="table table-striped jambo_table bulk_action">
						<thead>
							<tr class="headings">
								<th><input type="checkbox" id="check-all" class="flat">
								</th>
								<th class="column-title text-center">No.</th>
								<th class="column-title text-center">이름</th>
								<th class="column-title text-center">교회</th>
								<th class="column-title text-center">교단</th>
								<th class="column-title text-center">직책/직무</th>
								<th class="column-title text-center">이메일</th>
								<th class="column-title text-center">이메일 발송 상태</th>
								<th class="column-title no-link last text-center"><span
									class="nobr">센터 발송 상태</span></th>
							</tr>
						</thead>
						<tbody>
							<% if(list != null && list.size() > 0) { %>
								<% for(ChurchMember member : list){ %>
								<tr class="even pointer">
									<td class="a-center "><input type="checkbox" class="flat" name="table_records"></td>
									<td style="text-align: center;"><%= index++%></td>
									<td style="text-align: center;"><%= member.getName()%></td>
									<td style="text-align: center;"><%= member.getChurch_name()%></td>
									<td style="text-align: center;"><%= member.getChurch_root()%></td>
									<td style="text-align: center;"><%= member.getChurch_category()%></td>
									<td style="text-align: center;"><%= member.getEmail()%></td>
									<td style="text-align: center;"><%= member.getSend_email_yn()%></td>
									<td style="text-align: center;"><%= member.getSend_zc_yn()%></td>
								</tr>
								<%} %>
							<%} else{ %>
								<tr class="even pointer">
									<td class="a-center" colspan="8">데이터가 없습니다.</td>
								</tr>
							<%} %>
						</tbody>
					</table>
					<nav class="text-center pt20">
						<ul class="pagination">
							<%if(null!=pager){%>
							<%=pager.getPagingPrintString("goPage", "<span aria-hidden=\"true\">&lt;</span>", "<span aria-hidden=\"true\">&gt;</span>")%>
							<%} %>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function goPage(page){	
   var param = "&curPageNum="+page;
   reload(param)
}
</script>