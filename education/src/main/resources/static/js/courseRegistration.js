const registerBtn=document.getElementById("registerBtn");
const cur_num=document.getElementsByClassName("cur_num");
console.log(cur_num);
document.addEventListener("click", function() {
    if(cur_num>30){
        alert("인원이 초과 하였습니다");
    }
});
