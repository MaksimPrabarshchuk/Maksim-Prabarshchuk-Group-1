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

	$(".submitSearchButton").click(function() {
		findEmployee($(this));
	});
});

$(".submitSearchButton").mouseover(function() {
	alert(111 + $(this));
	$(this).css('background-color', '#e6e6e6');
});

$(".submitSearchButton").mouseleave(function() {
	alert(222 + $(this));
	$(this).css('background-color','#fff');
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