const idVerified=document.getElementById("id_check");
const checkBtn=document.getElementById("checkbtn");

checkBtn.onclick=check_id;
// joinBtn.onclick=join_check;

//아이디 중복 체크
function check_id(){
    let userId=document.getElementById("loginId").value;
    fetch(`/signup/id?userId=${userId}`)
        .then(response => response.json())
        .then(object => {
            if (object){
                alert("사용 가능한 아이디 입니다");
                idVerified.value="idVerified";
            }else{
                alert("이미 사용 중인 아이디 입니다");
                idVerified.value="none";
            }
        })
        .catch();
}
function join_check(){
    if(idVerified.value!=="idVerified"){
        alert("아이디 중복 여부를 확인해주세요");
        return false;
    }
    return true;
}