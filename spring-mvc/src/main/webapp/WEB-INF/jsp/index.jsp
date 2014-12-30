<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 class="cover-heading">List of Employees</h1>
<style type="text/css">
	.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;width:100%;}
	.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
	.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
	.tg .tg-bsv2{background-color:#efefef;text-align:center;}
</style>
<script language="javascript">
	$(document).ready(function() {
		$('.popover-markup>.trigger').popover({
		    html: true,
		    title: function () {
		        return $(this).parent().find('.head').html();
		    },
		    content: function () {
		        return $(this).parent().find('.content').html();
		    }
		});
	});
	
	$("#openFindDialog").click(function() {
		$("#errorMsg").css('display', 'none');
	});

	function findEmployee(that) {
		$.ajax({
			type : "POST",
			url : "/spring-mvc/findEmployee",
			data : {fistName: $(that).parent().find("#fistName").val(), 
					lastName: $(that).parent().find("#lastName").val()},
			success: function(data) {
				if (data.toString() == 0)
					$(that).parent().find("#errorMsg").css('display', 'block');
				else {
					$(that).parent().find("#errorMsg").css('display', 'none');
					window.location.replace("http://localhost:8080/spring-mvc/editEmployee?id=" + data.toString());
				}
			}
		});
	}
</script>
<table class="tg">
	<thead>
		<tr>
			<th class="tg-bsv2">ID</th>
			<th class="tg-bsv2">First Name</th>
			<th class="tg-bsv2">Last Name</th>
			<th class="tg-bsv2">Gender</th>
			<th class="tg-bsv2">Hire Date</th>
			<th class="tg-bsv2">Job Title</th>
			<th class="tg-bsv2">Salary</th>
			<th class="tg-bsv2">Action</th>
		</tr>
	</thead>
	<tbody>
        <c:forEach var="em" items="${employees}">
            <tr>
                <td class="tg-031e">${em.id}</td>
                <td class="tg-031e">${em.firstName}</td>
                <td class="tg-031e">${em.lastName}</td>
                <td class="tg-031e">${em.gender}</td>
                <td class="tg-031e">${em.hireDate}</td>
                <td class="tg-031e">${em.jobTitle}</td>
                <td class="tg-031e">$${em.salary}</td>
                <td class="tg-031e">
                    <a href="editEmployee?id=${em.id}" style="color: #333; font-weight: bold"><img src="img/edit.png"></a>
                    <a href="removeEmployee?id=${em.id}" style="color: #333; font-weight: bold"><img src="img/delete.png"></a>
                </td>
            </tr>
        </c:forEach>
	<tbody>
</table>
<p class="lead"></p>
<div class="lead" style="display: inline-flex;">
    <a href="addEmployee" class="btn btn-lg btn-default" style="margin-right: 10px;">Add Employee</a>
	<div class="popover-markup" style="color:#333;">
    	<a href="#" id="openFindDialog" class="trigger btn btn-lg btn-default">Find Employee</a>
	    <div class="head hide">Find Employee</div>
	    <div class="content hide">
	        <div class="form-group">
	            <input id="fistName" type="text" class="form-control" placeholder="Fist name" style="margin-bottom: 10px;">
	            <input id="lastName" type="text" class="form-control" placeholder="Last name">
	            <span id="errorMsg" hidden="hidden" style="color: red; margin-top: 10px; text-align: center;">Such employee not found!</span>
	        </div>
	        <button type="submit" class="btn btn-default btn-block" style=" border: 1px solid #fff; border-color: #ccc;" 
	        	onmouseover="$(this).css('background-color','#e6e6e6');" onmouseleave="$(this).css('background-color','#fff');"
	        	onclick="findEmployee($(this));">Find</button>
	    </div>
	    <div class="footer hide">test</div>
	</div>
</div>
