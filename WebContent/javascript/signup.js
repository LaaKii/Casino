/**
 * 
 */

function formCheck(){
		
		var username = document.getElementById('usernameInput');
		var firstname = document.getElementById('firstnameInput');
		var lastname = document.getElementById('lastnameInput');
		var email = document.getElementById('emailInput');
		var password1 = document.getElementById('passwordInput');
		var password2 = document.getElementById('passwordRepeatedInput');
		var agb = document.getElementById("agbCheck");
		var isOk = true;
		
		username.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("usernameError").style.visibility = "collapse";
		firstname.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("firstnameError").style.visibility = "collapse";
		lastname.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("lastnameError").style.visibility = "collapse";
		email.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("emailError").style.visibility = "collapse";
		password1.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("password1Error").style.visibility = "collapse";
		password2.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("password2Error").style.visibility = "collapse";
		document.getElementById("agbErrorMessage").style.visibility = "hidden";
		
		
		if(username.value == "" || isNaN(username.value.charAt(0)) == false || username.value.match(" ") != null || username.value.length<3){
			username.style.borderColor = "red";
			document.getElementById("usernameError").style.visibility = "visible";
			document.getElementById("usernameErrorMessage").innerHTML = "Benutzername ung&uuml;ltig"
			isOk = false;
		}
		
		if(firstname.value == "" || firstname.value.match(/\d/) != null || firstname.value.match(" ") != null){
			firstname.style.borderColor = "red";
			document.getElementById("firstnameError").style.visibility = "visible";
			document.getElementById("firstnameErrorMessage").innerHTML = "Vorname ung&uuml;ltig"
			isOk = false;
		}
		
		if(lastname.value == "" || lastname.value.match(/\d/) != null || lastname.value.match(" ") != null){
			lastname.style.borderColor = "red";
			document.getElementById("lastnameError").style.visibility = "visible";
			document.getElementById("lastnameErrorMessage").innerHTML = "Nachname ung&uuml;ltig"
			isOk = false;
		}
		
		if(email.value == ""){
			email.style.borderColor = "red";
			document.getElementById("emailError").style.visibility = "visible";
			document.getElementById("emailErrorMessage").innerHTML = "E-Mail ung&uuml;ltig"
			isOk = false;
		}
		
		if(password1.value != password2.value){
			password1.style.borderColor = "red";
			password2.style.borderColor = "red";
			document.getElementById("password2Error").style.visibility = "visible";
			document.getElementById("password2ErrorMessage").innerHTML = "Passw&ouml;rter nicht identisch"
			isOk = false;
		}
		
		if(password1.value == "" || password1.value.match(" ") != null){
			password1.style.borderColor = "red";
			document.getElementById("password1Error").style.visibility = "visible";
			document.getElementById("password1ErrorMessage").innerHTML = "Passwort ung&uuml;ltig"
			isOk = false;
		}
		
		if(password2.value == "" || password2.value.match(" ") != null){
			password2.style.borderColor = "red";
			document.getElementById("password2Error").style.visibility = "visible";
			document.getElementById("password2ErrorMessage").innerHTML = "Passwort ung&uuml;ltig"
			isOk = false;
		}
			
		if(agb.checked == false){
			document.getElementById("agbErrorMessage").style.visibility = "visible";
		}
		
		
		return isOk;
	}