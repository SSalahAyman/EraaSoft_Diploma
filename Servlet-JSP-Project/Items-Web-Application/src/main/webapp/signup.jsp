<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp page</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
	<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins',sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    overflow:hidden;
}

.container{
    width:450px;
    background:rgba(255,255,255,0.15);
    backdrop-filter:blur(15px);
    border:1px solid rgba(255,255,255,0.2);
    border-radius:25px;
    padding:40px;
    box-shadow:0 10px 40px rgba(0,0,0,0.2);
}

.container h1{
    text-align:center;
    color:white;
    margin-bottom:30px;
    font-size:2.5rem;
}

.input-box{
    margin-bottom:22px;
}

.input-box label{
    display:block;
    margin-bottom:8px;
    color:white;
    font-weight:500;
}

.input-box input{
    width:100%;
    padding:15px;
    border:none;
    border-radius:12px;
    background:rgba(255,255,255,0.2);
    color:white;
    font-size:15px;
}

.input-box input::placeholder{
    color:#eee;
}

.input-box input:focus{
    outline:none;
    background:rgba(255,255,255,0.3);
}

.btn{
    width:100%;
    padding:15px;
    border:none;
    border-radius:12px;
    background:white;
    color:#20bf6b;
    font-size:17px;
    font-weight:600;
    cursor:pointer;
    transition:0.3s;
}

.btn:hover{
    transform:translateY(-3px);
}

.link{
    margin-top:22px;
    text-align:center;
    color:white;
}

.link a{
    color:white;
    text-decoration:none;
    font-weight:600;
}

.circle{
    position:absolute;
    border-radius:50%;
    background:rgba(255,255,255,0.1);
}

.circle1{
    width:250px;
    height:250px;
    top:-50px;
    left:-50px;
}

.circle2{
    width:220px;
    height:220px;
    bottom:-60px;
    right:-60px;
}
.toast-error{
    width:100%;
    background:#ff4d4f;
    color:white;
    padding:15px;
    border-radius:12px;
    margin-bottom:20px;
    text-align:center;
    font-weight:600;
    animation:fadeIn 0.4s ease;
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
	
	<div class="circle circle1"></div>
<div class="circle circle2"></div>

<div class="container">

    <h1>Create Account</h1>
    
    <%
		String errorMessage = (String)request.getAttribute("errorMessage");
	%>
	<% if(errorMessage != null){ %>

    <div class="toast-error">
        <%= errorMessage %>
    </div>

<% } %>
    
    <form action="/Items-Web-Application/AuthController" method="post">

        <input type="hidden" name="action" value="signup">

        <div class="input-box">
            <label>Username</label>
            <input type="text"
                   name="username"
                   placeholder="Enter username"
                   >
        </div>


        <div class="input-box">
            <label>Password</label>
            <input type="password"
                   name="password"
                   placeholder="Create password"
                   >
        </div>

        <div class="input-box">
            <label>Confirm Password</label>
            <input type="password"
                   name="confirmPassword"
                   placeholder="Confirm password"
                   >
        </div>

        <button type="submit" class="btn">
            Signup
        </button>
        
        <input type="hidden" name="action" value="signup">
        
    </form>

    <div class="link">
        Already have account ?
        <a href="login.jsp">Login</a>
    </div>

</div>
</body>
</html>