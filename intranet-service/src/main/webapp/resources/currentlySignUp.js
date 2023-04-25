function deleteRow(button) {
	var row = button.parentNode.parentNode;
	row.parentNode.removeChild(row);
	var classCode = row.cells[1].innerHTML;
	alert('수강신청이 취소되었습니다.');
	location.href = "../service?command=deleteClass&classCode=" + classCode;
}