var a = ["harsh", "harsha", "harshita", "adarsh", "adi", "aparna", "anu", "tarun", "arun", "tushar"];
var b;
function uname_search() {
    var username = document.getElementById("uname").value;
    r = new RegExp(username);
    var list = a.filter((item) => r.test(item));
    //console.log(typeof list);
    if(Object.keys(list).length==0){
        alert("No username present");
    }
    b = list;
    document.getElementById("u_search").innerHTML = list;
}

function sort() {
    //console.log(typeof b);
    var s_list = b.sort();
    document.getElementById("sorted_list").innerHTML = s_list;
}