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

    setInterval(function() {
        $.ajax({
            type : "POST",
            url : "getEmployees",
            success: function(json) {
                var table = $(".employeeTable");
                if (table != undefined) {
					table.empty();
                    for (var i = 0; i < json.length; i++) {
                        var em = json[i];
                        table.append("<tr>" +
                            "<td class='tg-031e'>" + em.id + "</td>" +
                            "<td class='tg-031e'>" + em.firstName + "</td>" +
                            "<td class='tg-031e'>" + em.lastName + "</td>" +
                            "<td class='tg-031e'>" + em.gender + "</td>" +
                            "<td class='tg-031e'>" + em.hireDate + "</td>" +
                            "<td class='tg-031e'>" + em.jobTitle + "</td>" +
                            "<td class='tg-031e'>" + em.salary + "</td>" +
                            "<td class='tg-031e'>" +
                                "<a href='editEmployee?id=" + em.id + "' class='actionButton'><img src='img/edit.png'></a>" +
                                "<a href='removeEmployee?id=" + em.id + "' class='actionButton'><img src='img/delete.png'></a>" +
                            "</td>" +
                            "</tr>");
                    }
                }
            }
        });
    }, 1000 * 3);
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