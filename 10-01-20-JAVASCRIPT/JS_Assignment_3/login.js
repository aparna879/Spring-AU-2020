
function validate(){
    var flag=1;
    var email = document.getElementById("email").value;
    var pass  = document.getElementById("pass").value;
    var c_pass = document.getElementById("c_pass").value;

    console.log("email:"+ email + " "+ "password:" + pass );
    console.log(typeof pass);

    if(pass.length <8){
        alert("ATleast 8 Characters required");
        flag=0;
    }

    r1 = /[a-z]+/;
    r2 = /[A-Z]+/;
    r3 = /[$ @ *]+/;
    r4 = /abc/;

    if(!r1.test(pass)){
        alert("Atleast 1 Small Character required");
        flag=0;
    }

    if(!r2.test(pass)){
        alert("Atleast 1 Capital Character required");
        flag=0;
    }

    if(!r3.test(pass)){
        alert("Atleast 1 Special Character required");
        flag=0;
    }

    if(!r4.test(pass)){
        alert("abc must be present in password");
        flag=0;
    }

    if(pass != c_pass){
        alert("Password not matched....Enter Password Again");
        flag=0;
    }

    if(flag==1){
        alert("Login Successful");
    }

}