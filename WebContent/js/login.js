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
					if(data.b=="������֤�����"){
						alert(data.b);
					}else if(data.f=="�û������������"){
						alert(data.f);
					}else if(data.a=="��¼�ɹ�"){
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
    //��ȡ��ǰ��ʱ����Ϊ�������޾�������  
 var timenow = new Date().getTime();  
    //ÿ��������Ҫһ����ͬ�Ĳ�����������ܻ᷵��ͬ������֤��  
 //���������Ļ�������й�ϵ��Ҳ���԰�ҳ������Ϊ�����棬�����Ͳ�����������ˡ�  
 document.getElementById("code").src="/supermarket/GetAuthCode?update="+Math.random(); 
 return false; 
}  