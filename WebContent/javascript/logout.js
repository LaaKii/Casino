	$(document).ready(function() {
			$('a[href="#logout"]').click(function(){
				$.get("/Casino/LogoutServlet", function(responseText) { 
					window.location.href = "/Casino/index.jsp";
				});
				}); 
		});