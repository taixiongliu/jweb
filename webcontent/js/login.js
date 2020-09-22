window.onload = _init;
var ajaxload;
function _init(){
	Ele.load(function(){
		ajaxload = new Ele.AjaxLoad();
	});
}

function loginSubmit(){
	var msg = document.getElementById("hint_login_msg");
	msg.innerHTML = "";
	ajaxload.show();
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var captcha = document.getElementById("captcha").value;
	if(username.trim() == ''){
		ajaxload.hide();
		msg.innerHTML = "账号不能为空";
	}
	if(password.trim() == ''){
		ajaxload.hide();
		msg.innerHTML = "密码不能为空";
	}
	if(captcha.trim() == ''){
		ajaxload.hide();
		msg.innerHTML = "验证码不能为空";
	}
	var ajax = new Ele.Ajax();
	ajax.setParameter("account="+username+"&passwd="+password+"&authcode="+captcha);
	ajax.request("login.jweb",function(res){
		console.log(res);
		ajaxload.hide();
		var json = JSON.parse(res);
		if(json.errorCode != 1000){
			msg.innerHTML = json.errorMsg;
			document.getElementById("codeImage").src = 'auth_code.jweb?name='+username+'&a='+Math.random();
			return ;
		}
		localStorage.setItem("session",JSON.stringify(json.data));
		//console.log(JSON.parse(localStorage.getItem("session")));
		window.location.replace("index.html?sid="+json.data.sid);
	});
}
 //回车登录
 function enterlogin(event){
     if (event.keyCode == 13){
         event.returnValue=false;
         event.cancel = true;
         loginSubmit();
     }
 }
 function getAuthCode(){
	 var msg = document.getElementById("hint_login_msg");
	 msg.innerHTML = "";
	 var name = document.getElementById("username").value;
	 if(name == ""){
		 msg.innerHTML = "请输入用户名";
	 }
	 var ajax = new Ele.Ajax();
	 ajax.setParameter("account="+name);
	 ajax.request("auth_name.jweb",function(res){
		 var json = JSON.parse(res);
		 if(json.errorCode != 1000){
			 msg.innerHTML = json.errorMsg;
			 return ;
		 }
		 document.getElementById("codeImage").src = 'auth_code.jweb?name='+name+'&a='+Math.random();
	 });
 }
