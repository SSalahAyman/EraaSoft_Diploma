<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
    background:linear-gradient(135deg, #667eea 0%, #764ba2 100%);;
    overflow:hidden;
}

.container{
    width:420px;
    background:rgba(255,255,255,0.15);
    backdrop-filter:blur(15px);
    border:1px solid rgba(255,255,255,0.2);
    border-radius:25px;
    padding:45px;
    box-shadow:0 10px 40px rgba(0,0,0,0.2);
}

.container h1{
    text-align:center;
    color:white;
    margin-bottom:35px;
    font-size:2.5rem;
}

.input-box{
    margin-bottom:25px;
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
    color:#00b4db;
    font-size:17px;
    font-weight:600;
    cursor:pointer;
    transition:0.3s;
}

.btn:hover{
    transform:translateY(-3px);
}

.link{
    margin-top:25px;
    text-align:center;
    color:white;
}

.link a{
    color:white;
    font-weight:600;
    text-decoration:none;
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
    width:200px;
    height:200px;
    bottom:-50px;
    right:-50px;
}

</style>
</head>
<body>
	<div class="circle circle1"></div>
<div class="circle circle2"></div>

<div class="container">

    <h1>Login</h1>

    <form action="/Items-Web-Application/AuthController" method="post">

        <input type="hidden" name="action" value="login">

        <div class="input-box">
            <label>Username</label>
            <input type="text"
                   name="username"
                   placeholder="Enter username"
                   required>
        </div>

        <div class="input-box">
            <label>Password</label>
            <input type="password"
                   name="password"
                   placeholder="Enter password"
                   required>
        </div>

        <button type="submit" class="btn">
            Login
        </button>
        
        <input type="hidden" name="action" value="login">
        

    </form>

    <div class="link">
        Don't have account ?
        <a href="signup.jsp">Signup</a>
    </div>

</div>
	
</body>
</html>