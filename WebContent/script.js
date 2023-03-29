
$(document).ready(function() {

$("#login_button").click(function() {
var email = $("#email").val(); 
var password = $("#password").val(); 

if (email == "admin" && password == "123") {
$("#message").html("Account Validated!!!");
    window.location.replace("index.html");
}
else if(email!="admin"){
	$("#login").effect("shake");

	    $("#email").val('');
	    $(".change").html( "<b>Invalid email</b>" );
	    $(".change").css( "color", "red" );
	}
else {
$("#login").effect("shake");

    $("#password").val('');
    $(".change").html( "<b>Invalid Password</b>" );
    $(".change").css( "color", "red" );
}
});
    
    
    $("#database").click(function(){
        
        /*  Database adding code goes here.!!*/
        $("#inputText").val('');
        $("#inputAnswer").val('');
        $(".keep").html("<h2>Keep adding questions</h2>");
        $(".keep").css( "color", "red" );
        
        
    });
    
     $("#logout").click(function(){
    
        window.location.replace("admin.html");

     });
    
    
});


