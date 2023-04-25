$(".signUp").click(e => {
    const tr = e.target.closest('tr');
    const classification = tr.querySelector("#classification").innerText;
    const className = tr.querySelector("#classname").innerText;
    const major = tr.querySelector("#major").innerText;
    const department = tr.querySelector("#department").innerText;
    const professorName = tr.querySelector("#professorname").innerText;
    const classroom = tr.querySelector("#classroom").innerText;
    const credit = tr.querySelector("#credit").innerText;

    // 중복 체크를 위한 변수
    let isDuplicate = false;

    // 기존에 추가된 강의 정보를 가져옴
    const lectureInfos = document.querySelectorAll('#signupList tr[name="lectureInfo"]');
    const signupList = document.querySelectorAll('#signupList tr[name="currentlySignUpList"]');
    // 강의 정보 중복 체크
    for (let i = 0; i < lectureInfos.length; i++) {
        const lectureCheck = lectureInfos[i];
        const checkClassification = lectureCheck.querySelector('input[name="classification"]').value;
        const checkClassName = lectureCheck.querySelector('input[name="classname"]').value;
        const checkProfessorName = lectureCheck.querySelector('input[name="professorname"]').value;
        if (checkClassification === classification && checkClassName === className && checkProfessorName === professorName) {
            isDuplicate = true;
            break;
        }
    }
    for (let i = 0; i < signupList.length; i++) {
        const listCheck = signupList[i];
        const checkClassification = listCheck.querySelector('input[name="myclassification"]').value;
        const checkClassName = listCheck.querySelector('input[name="myclassname"]').value;
        const checkProfessorName = listCheck.querySelector('input[name="myusername"]').value;
        if (checkClassification === classification && checkClassName === className && checkProfessorName === professorName) {
            isDuplicate = true;
            break;
        }
    }

    // 중복되는 강의 정보가 없으면 추가
    if (!isDuplicate) {
        $("#signupList").append(`
            <tr name="lectureInfo" id="lectureInfo">
                <td><input type="text" id="classification" name="classification" value="${classification}" readonly></td>
                <td><input type="text" id="classname" name="classname" value="${className}" readonly></td>
                <td><input type="text" id="major" name="major" value="${major}" readonly></td>
                <td><input type="text" id="department" name="department" value="${department}" readonly></td>
                <td><input type="text" id="professorname" name="professorname" value="${professorName}" readonly></td>
                <td><input type="text" id="classroom" name="classroom" value="${classroom}" readonly></td>
                <td><input type="text" id="credit" name="credit" value="${credit}" readonly></td>
                <td><input type="button" name="delBtn" value="취소"></td>
            </tr>
        `);
    } else {
        alert('중복되는 강의가 이미 있습니다.');
    }
});

$("#signupList").on('click', 'input[name="delBtn"]', function() {
	alert('취소되었습니다.');
    $(this).closest('tr').remove();
});

$(".lectureEnroll").click(function(){
	if($("#signupList tr:not(#currentlySignUpList)").length > 1){
		alert("신청이 완료되었습니다.");
	}
	else {
		alert("신청목록이 없습니다.");
	}
});