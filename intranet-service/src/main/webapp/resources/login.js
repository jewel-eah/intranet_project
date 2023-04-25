function checkValues(htmlForm){
	let url = "login"
	
	const userCode = document.getElementById("userCode").value;
	const userPassword = document.getElementById("userPassword").value;
	
	let check = true;
	
	if(userCode === ""){
		alert("아이디를 입력해주세요");
		check = false;
	}
	else if(userPassword === ""){
		alert("페스워드를 입력해주세요");
		check = false;
	}
	
	
	if(check === false){
		location.href = url;
	}
	else{
		htmlForm.submit();
		}
}