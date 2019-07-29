	var name;
	function showTitle(name) {
		document.getElementById("choice").style.visibility = "visible";
		document.getElementById("choice").innerHTML = name;
	}
	
	function hideTitle(){
		document.getElementById("choice").style.visibility = "hidden";
	}