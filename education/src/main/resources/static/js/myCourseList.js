const cancelBtn = document.getElementById("btn");


console.log(cancelBtn);

cancelBtn.addEventListener("click", function(event) {
    if (confirm("수강 신청을 취소하시겠습니까?")) {
        // 확인 버튼이 눌렸을 때의 동작
        console.log("수강 신청이 취소되었습니다.");
    } else {
        // 취소 버튼이 눌렸을 때의 동작
        console.log("수강 신청이 취소되지 않았습니다.");
        event.preventDefault();
        false;
    }
});