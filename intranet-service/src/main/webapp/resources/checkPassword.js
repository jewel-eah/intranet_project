function checkPassword(htmlForm){
	
	let url = "professorLogCheck";
	
	const userPassword = document.getElementById("userPassword").value;
	const presentPassword = document.getElementById("presentPassword").value;
	let check = true;
	
	
	if (userPassword === ""){
		alert('비밀번호를 확인해주세요.');
		check = false;
	}
	
	else if (userPassword != presentPassword) {
		alert('비밀번호가 일치하지 않습니다.');
		check = false;
	}
	
	if(check == false) {
		location.href = url;
	}
 	else {
		 htmlForm.submit();
	 }
}