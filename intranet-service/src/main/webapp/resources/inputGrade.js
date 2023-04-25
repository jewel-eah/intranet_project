function inputGrade(htmlForm) {

	let url = "inputGrade?";

	const classCode = document.getElementById("classCode").innerText;
	const className = document.getElementById("className").innerText;
	const userCode = document.getElementById("userCode").innerText;
	const userName = document.getElementById("userName").innerText;
	const major = document.getElementById("major").innerText;
	const grade = document.getElementById("score").value;

	let check = true;

	if (classCode != "")
		url += "&classCode=" + classCode;
	if (className != "")
		url += "&className=" + className;
	if (userCode != "")
		url += "&userCode=" + userCode;
	if (userName != "")
		url += "&userName=" + userName;
	if (major != "")
		url += "&major=" + major;
	if (grade != "")
		url += "&grade=" + grade;
	
	
	if (grade === ""){
		alert('성적이 입력되지 않았습니다.');
		check = false;
	}
	
	if(check == false) {
		location.href = url;
	}
}

$('.modify').click(e => {
	const studentCode = e.target.parentNode.parentNode.id;
	console.log(e.target);
	console.log("student code: ",studentCode);
	
	const classCode = $('#classCode').val();
	console.log("classCode : ",classCode);
	const grade = $(`#${studentCode}`).children('#select-grade').children('#score').val();

	$.ajax({
		"url": `../service?command=inputGrade&userCode=${studentCode}&classCode=${classCode}&grade=${grade}`,
		"method": "GET",
		"timeout": 0,
	}).done(function(response) {
		const target = $(`#${studentCode}`).children('#grade')[0];
		target.innerText = response;
		
		alert("성적등록이 완료되었습니다.");
	});
})


