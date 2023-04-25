function checkValues(htmlForm){
	let url = "writeBoard?";
	
	const title = document.getElementById("title").value;
	const content = document.getElementById("content").value;
	
	let check = true;

	if(title !== "")
		url += "&title=" + title;
	if(content !== "")
		url += "&content=" + content;

	
	if(title === "") {
		alert('제목이 입력되지 않았습니다.');
		check = false;
	}
	else if(content === "") {
		alert('내용이 입력되지 않았습니다.');
		check = false;
	}
	if(check === true) {
		htmlForm.submit();	
	}
	else{
		location.href=url;
	}
}