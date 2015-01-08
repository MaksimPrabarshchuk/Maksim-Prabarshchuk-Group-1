<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style type="text/css">
    .control-label {color: #ffffff;}
    .cng {color: #000000; display: inline-flex; width: 300px; margin-bottom: 20px;}
    .cng .cn {margin-left: 30px;}
</style>
<h1 class="cover-heading">Edit Employee Profile</h1>
<form class="form-horizontal" action="updateEmployee" method="post">
    <fieldset>
        <!-- Form Name -->
        <legend style="font-size:10px;">Add employee</legend>

        <input id="id" name="id" type="text" hidden="hidden" value="${employee.id}">
        <!-- Text input-->
        <div class="control-group cng">
            <label class="control-label" for="firstName">First Name</label>
            <div class="controls cn">
                <input id="firstName" name="firstName" type="text" placeholder="First name" class="input-xlarge" value="${employee.firstName}">
            </div>
        </div>
        </br>
        <!-- Text input-->
        <div class="control-group cng">
            <label class="control-label" for="lastName">Last Name</label>
            <div class="controls cn">
                <input id="lastName" name="lastName" type="text" placeholder="Last name" class="input-xlarge" value="${employee.lastName}">
            </div>
        </div>
        </br>
        <!-- Select Basic -->
        <div class="control-group cng">
            <label class="control-label" for="gender">Gender</label>
            <div class="controls cn">
                <select id="gender" name="gender" class="input-xlarge">
                    <option>Male</option>
                    <option>Female</option>
                </select>
            </div>
        </div>
        </br>
        <!-- Text input-->
        <div class="control-group cng">
            <label class="control-label" for="hireDate">Hire Date</label>
            <div class="controls cn">
                <input id="hireDate" name="hireDate" type="text" placeholder="dd.mm.yyyy" class="input-xlarge" value="${employee.hireDate}">
            </div>
        </div>
        </br>
        <!-- Text input-->
        <div class="control-group cng">
            <label class="control-label" for="jobTitle">Job Title</label>
            <div class="controls cn">
                <input id="jobTitle" name="jobTitle" type="text" placeholder="Job title" class="input-xlarge" value="${employee.jobTitle}">
            </div>
        </div>
        </br>
        <!-- Text input-->
        <div class="control-group cng">
            <label class="control-label" for="salary">Salary</label>
            <div class="controls cn">
                <input id="salary" name="salary" type="text" placeholder="$" class="input-xlarge" value="${employee.salary}">
            </div>
        </div>
        </br>
        <button type="submit" class="btn btn-default">Save</button>
    </fieldset>
</form>