$(document).ready(function() {
		$("#mysubmit").click(function() {
				 var mytextvalue=document.getElementById("mynumber").value;
				 var username=document.getElementById("myname").value;
				 var password=document.getElementById("mypassword").value;
			$.ajax( {
				url : "/supermarket/LoginControl?name=Login",
				type : "post",
				dataType : "json",
				cache : false,
				async :false,
				data : {
					"username" : username,
					"password" :password,
					"mynumber" : mytextvalue
				},
				success:function(data) {
					if(data.b=="输入验证码错误"){
						alert(data.b);
					}else if(data.f=="用户名或密码错误"){
						alert(data.f);
					}else if(data.a=="登录成功"){
						alert(data.a);
						window.location.href="/supermarket/managerjsp/admin.html";
					}
				},
				error:function(){
				alert("JSON ERROR");
				}
			});

		});
	});



function changeValidateCode() {  
    //获取当前的时间作为参数，无具体意义  
 var timenow = new Date().getTime();  
    //每次请求需要一个不同的参数，否则可能会返回同样的验证码  
 //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。  
 document.getElementById("code").src="/supermarket/GetAuthCode?update="+Math.random(); 
 return false; 
}  