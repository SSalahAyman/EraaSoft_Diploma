<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#141e30,#243b55);
}

.container{
    width:900px;
    min-height:550px;
    display:flex;
    border-radius:30px;
    overflow:hidden;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(20px);
    box-shadow:0 25px 50px rgba(0,0,0,.4);
}

.left{
    flex:1;
    background:linear-gradient(135deg,#6a11cb,#2575fc);
    color:white;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    padding:40px;
}

.left h1{
    font-size:3rem;
    margin-bottom:20px;
}

.left p{
    text-align:center;
    line-height:1.8;
}

.right{
    flex:1;
    background:white;
    padding:60px;
    display:flex;
    flex-direction:column;
    justify-content:center;
}

.right h2{
    margin-bottom:35px;
    color:#333;
}

.input-box{
    margin-bottom:20px;
}

.input-box input{
    width:100%;
    padding:16px;
    border:none;
    border-radius:12px;
    background:#f1f5f9;
}

.input-box input:focus{
    outline:none;
    background:#e2e8f0;
}

.btn{
    width:100%;
    padding:16px;
    border:none;
    border-radius:12px;
    background:linear-gradient(135deg,#6a11cb,#2575fc);
    color:white;
    cursor:pointer;
    font-size:16px;
    font-weight:600;
}

.btn:hover{
    transform:translateY(-2px);
}

.link{
    margin-top:20px;
    text-align:center;
}

.link a{
    color:#2575fc;
    text-decoration:none;
}

.toast{

    width:100%;

    margin-bottom:25px;

    padding:16px 20px;

    border-radius:16px;

    background:#fef2f2;

    border-left:5px solid #ef4444;

    color:#991b1b;

    font-size:14px;

    font-weight:600;

    animation:fadeIn .3s ease;
}

@keyframes fadeIn{

    from{
        opacity:0;
        transform:translateY(-10px);
    }

    to{
        opacity:1;
        transform:translateY(0);
    }
}

</style>
</head>

<body>

<div class="container">

    <div class="left">
        <h1>Forgot Password</h1>

        <p>
            Enter your username to verify your account
            before resetting your password.
        </p>
    </div>

    <div class="right">

        <h2>Recover Account</h2>
        
 
        <%
            String errorMessage =
            (String)session.getAttribute("errorMessage");

            session.removeAttribute("errorMessage");
        %>

        <% if(errorMessage != null){ %>

            <div id="toast" class="toast">
	   			 <%= errorMessage %>
			</div>

        <% } %>

        <form action="/Items-Web-Application/ForgetPasswordController"
              method="post">
              
              <input type="hidden"
           			name="action"
           			value="check-username">

            <div class="input-box">

                <input type="text"
                       name="username"
                       placeholder="Enter Username"
                       required>

            </div>

            <button class="btn"
            		type="submit">	
                Continue

            </button>

        </form>

        <div class="link">

            <a href="login.jsp">

                Back To Login

            </a>

        </div>

    </div>

</div>

<script>
	
	const toast = document.getElementById("toast");
	
	if(toast){
	
	    setTimeout(() => {
	
	        toast.style.display = "none";
	
	    },6000);
	}
	
	</script>

</body>
</html>