<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

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
    overflow:hidden;
}

.background{
    position:absolute;
    width:100%;
    height:100%;
    overflow:hidden;
}

.background span{
    position:absolute;
    display:block;
    width:200px;
    height:200px;
    border-radius:50%;
    background:rgba(255,255,255,0.05);
    animation:move 10s linear infinite;
}

.background span:nth-child(1){
    top:10%;
    left:20%;
}

.background span:nth-child(2){
    bottom:10%;
    right:15%;
}

@keyframes move{
    0%{
        transform:translateY(0px) rotate(0deg);
    }
    100%{
        transform:translateY(-40px) rotate(360deg);
    }
}

.container{
    width:900px;
    height:550px;
    display:flex;
    border-radius:30px;
    overflow:hidden;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(20px);
    box-shadow:0 25px 50px rgba(0,0,0,0.4);
    z-index:2;
}

.left{
    flex:1;
    background:linear-gradient(135deg,#6a11cb,#2575fc);
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    color:white;
    padding:40px;
}

.left h1{
    font-size:3rem;
    margin-bottom:20px;
}

.left p{
    text-align:center;
    line-height:1.8;
    opacity:0.9;
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
    margin-bottom:40px;
    color:#333;
    font-size:2rem;
}

.input-box{
    margin-bottom:25px;
}

.input-box input{
    width:100%;
    padding:16px;
    border:none;
    background:#f1f5f9;
    border-radius:12px;
    font-size:15px;
    transition:0.3s;
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
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:0.3s;
}

.btn:hover{
    transform:translateY(-3px);
}

.link{
    margin-top:20px;
    text-align:center;
}

.link a{
    color:#2575fc;
    text-decoration:none;
    font-weight:600;
}

@media(max-width:900px){

    .container{
        width:95%;
        flex-direction:column;
        height:auto;
    }

    .left{
        padding:30px;
    }

    .right{
        padding:40px 30px;
    }
}

/* Toast Error Message */

.toast-error{
    width:100%;
    padding:14px 18px;
    margin-bottom:25px;
    border-radius:12px;
    background:rgba(255,77,77,0.12);
    border-left:5px solid #ff4d4d;
    color:#d90429;
    font-size:14px;
    font-weight:500;
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

<div class="background">
    <span></span>
    <span></span>
</div>

<div class="container">

    <div class="left">
        <h1>Items App</h1>
        <p>
            Manage your items easily with a modern dashboard.
            Add, update, delete and manage item details.
        </p>
    </div>

    <div class="right">

        <h2>Welcome Back</h2>
        
        <%
    		String errorMessage = (String) request.getAttribute("errorMessage");
		%>
		
		<% if(errorMessage != null){ %>

    		<div class="toast-error">
        		<%= errorMessage %>
    		</div>

		<% } %>

        <form action="/Items-Web-Application/LoginController" method="post">

            <input type="hidden" name="action" value="login">

            <div class="input-box">
                <input type="text"
                       name="username"
                       placeholder="Username"
                       required>
            </div>

            <div class="input-box">
                <input type="password"
                       name="password"
                       placeholder="Password"
                       required>
            </div>

            <button class="btn">
                Login
            </button>

        </form>

        <div class="link">
            Don't have account ?
            <a href="signup.jsp">Signup</a>
        </div>

    </div>

</div>

</body>
</html>