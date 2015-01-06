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
	
	$("#openFindDialog").click(function() {
		$("#errorMsg").css('display', 'none');
	});

	$(".popover-markup").on("click", ".submitSearchButton", function() {
		findEmployee($(this));
	});
	
	$(".popover-markup").on("mouseover", ".submitSearchButton", function() {
		$(this).css('background-color', '#e6e6e6');
	});

	$(".popover-markup").on("mouseleave", ".submitSearchButton", function() {
		$(this).css('background-color','#fff');
	});
});

function findEmployee(that) {
	$.ajax({
		type : "POST",
		url : "findEmployee",
		data : {fistName: $(that).parent().find("#fistName").val(), 
				lastName: $(that).parent().find("#lastName").val()},
		success: function(data) {
			if (data.toString() == 0)
				$(that).parent().find("#errorMsg").css('display', 'block');
			else {
				$(that).parent().find("#errorMsg").css('display', 'none');
				window.location.replace("editEmployee?id=" + data.toString());
			}
		}
	});
}