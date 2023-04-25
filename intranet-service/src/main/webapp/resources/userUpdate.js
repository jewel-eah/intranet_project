function optionChange() {
	const department = $('#department').val();

	$.ajax({
		"url": `http://localhost:8080/service?command=listOfMajors&depCode=${department}`,
		"method": "POST",
		"timeout": 0
	}).done(function(list) {
		$("#mainMajor").empty()
		list.forEach(major => {
			$('#mainMajor').append(`<option value="${major.majorName}">${major.majorName}</option>`);
		});
	});
}
