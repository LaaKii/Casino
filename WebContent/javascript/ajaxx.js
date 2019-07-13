$(document).ready(function() {
	$.get("/Casino/KontoServlet", function(responseText) { 
		$("#kontostand").text(responseText); 
	});
});
