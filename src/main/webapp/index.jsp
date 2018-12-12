<html>
<header>
<script 
src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    function login() {
		console.log("login");
	    window.open("http://localhost:8080/spring002/user/toPage.form");
	    //$.ajax(
	    //{
	    	//url:"login/toPage.form",
	    	/* dataType:"text",
	    	success:function(resp){
	    		console.log("resp:"+resp);
	    	},
	    	error:function(XMLHttpRequest, textStatus, errorThrown){
	    		console.log("XMLHttpRequest:"+XMLHttpRequest);
	    		console.log("textStatus:"+textStatus);
	    		console.log("errorThrown:"+errorThrown);
	    	}
	     }
	    		); */
	}
    function registry() {
    	 window.open("http://localhost:8080/spring002/user/toRegistry.form");
    }
    
</script>
</header>
<body>
<h2>Hello World!</h2>
<%--<input type="button" value="login" onclick="login()">
<input type="button" value="registry" onclick="registry()">--%>
</body>
</html>
