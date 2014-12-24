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
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="tg-031e">Jack</td>
			<td class="tg-031e">Sales</td>
			<td class="tg-031e">555-5555</td>
			<td class="tg-031e">555-5555</td>
			<td class="tg-031e">555-5555</td>
			<td class="tg-031e">555-5555</td>
			<td class="tg-031e">555-5555</td>
		</tr>
	<tbody>
</table>
<p class="lead"></p>
<p class="lead">
    <a href="#" class="btn btn-lg btn-default">Add Employee</a>
    <a href="#" class="btn btn-lg btn-default">Remove Employee</a>
</p>
<div class="popover-markup" style="color:#333;">
	<a href="#" class="trigger">Popover link</a> 
    <div class="head hide">Lorem Ipsum</div>
    <div class="content hide">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Type something...">
        </div>
        <button type="submit" class="btn btn-default btn-block">Submit</button>
    </div>
    <div class="footer hide">test</div>
</div>