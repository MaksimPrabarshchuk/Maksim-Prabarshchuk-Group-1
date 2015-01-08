<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 class="cover-heading">List of Employees</h1>
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
        <c:forEach var="em" items="${page.content}">
            <tr>
                <td class="tg-031e">${em.id}</td>
                <td class="tg-031e">${em.firstName}</td>
                <td class="tg-031e">${em.lastName}</td>
                <td class="tg-031e">${em.gender}</td>
                <td class="tg-031e">${em.hireDate}</td>
                <td class="tg-031e">${em.jobTitle}</td>
                <td class="tg-031e">$${em.salary}</td>
                <td class="tg-031e">
                    <a href="editEmployee?id=${em.id}" class="actionButton"><img src="img/edit.png"></a>
                    <a href="removeEmployee?id=${em.id}" class="actionButton"><img src="img/delete.png"></a>
                </td>
            </tr>
        </c:forEach>
	<tbody>
</table>
<p class="lead">
	<c:if test="${page.totalPages > 0}">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<c:forEach var="i" begin="0" end="${page.totalPages - 1}" varStatus="loop">
				<c:choose>
				    <c:when test="${page.number == i}">
				       <li class="active"><a href="?page=${i}">${i + 1}</a></li>
				    </c:when>
				    <c:otherwise>
		    			<li><a href="?page=${i}">${i + 1}</a></li>
				    </c:otherwise>
				</c:choose>
			</c:forEach>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</c:if>
</p>
<div class="lead" style="display: inline-flex;">
    <a href="addEmployee" class="btn btn-lg btn-default addEmployeeButton">Add Employee</a>
	<div class="popover-markup" style="color:#333;">
    	<a href="#" id="openFindDialog" class="trigger btn btn-lg btn-default">Find Employee</a>
	    <div class="head hide">Find Employee</div>
	    <div class="content hide">
	        <div class="form-group">
	            <input id="fistName" type="text" class="form-control" placeholder="Fist name">
	            <input id="lastName" type="text" class="form-control" placeholder="Last name">
	            <span id="errorMsg" hidden="hidden">Such employee not found!</span>
	        </div>
			<button type="submit" class="btn btn-default btn-block submitSearchButton">Search</button>
		</div>
	    <div class="footer hide">test</div>
	</div>
</div>
