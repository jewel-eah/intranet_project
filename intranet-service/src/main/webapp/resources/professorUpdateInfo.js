function professorUpdateInfo(htmlForm) {

    let url = "professorUpdate?";

    const userCode = document.getElementById("userCode").value;
    const userName = document.getElementById("userName").value;
    const userPassword = document.getElementById("userPassword").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;
    const addressCode = document.getElementById("addressCode").value;
    const address = document.getElementById("address").value;

    let check = true;

    if (userCode !== "") {
        url += "&userCode=" + userCode;
    }
    if (userName !== "") {
        url += "&userName=" + userName;
    }
    if (userPassword !== "") {
        url += "&userPassword=" + userPassword;
    }
    if (phone !== "") {
        if (!validatePhone(phone)) {
            alert('유효한 전화번호 형식이 아닙니다. 다시 입력해주세요.');
            check = false;
        } else {
            url += "&phone=" + phone;
        }
    }
    if (email !== "") {
        if (!validateEmail(email)) {
            alert('유효한 이메일 형식이 아닙니다. 다시 입력해주세요.');
            check = false;
        } else {
            url += "&email=" + email;
        }
    }
    if (addressCode !== "") {
        url += "&addressCode=" + addressCode;
    }
    if (address !== "") {
        url += "&address=" + address;
    }

    if (userPassword === "") {
        alert('비밀번호를 확인해주세요.');
        check = false;
    }

    if (check === false) {
        location.href = url;
    } else {
        alert("회원정보 수정 완료!");
        htmlForm.submit();
    }
}

function validatePhone(phone) {
    var phonePattern = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;
    return phonePattern.test(phone);
}

function validateEmail(email) {
    var emailPattern = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i;
    return emailPattern.test(email);
}
