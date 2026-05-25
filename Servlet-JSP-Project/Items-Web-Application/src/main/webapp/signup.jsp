<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Signup</title>

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

/* Background Animation */

.background{
    position:absolute;
    width:100%;
    height:100%;
    overflow:hidden;
}

.background span{
    position:absolute;
    display:block;
    border-radius:50%;
    background:rgba(255,255,255,0.05);
    animation:move 12s linear infinite;
}

.background span:nth-child(1){
    width:250px;
    height:250px;
    top:-50px;
    left:-60px;
}

.background span:nth-child(2){
    width:200px;
    height:200px;
    bottom:-50px;
    right:-40px;
}

.background span:nth-child(3){
    width:150px;
    height:150px;
    top:40%;
    left:60%;
}

@keyframes move{

    0%{
        transform:translateY(0px) rotate(0deg);
    }

    100%{
        transform:translateY(-40px) rotate(360deg);
    }
}

/* Main Container */

.container{
    width:950px;
    min-height:600px;
    display:flex;
    border-radius:30px;
    overflow:hidden;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(20px);
    box-shadow:0 25px 50px rgba(0,0,0,0.4);
    z-index:2;
}

/* Left Side */

.left{
    flex:1;
    background:linear-gradient(135deg,#6a11cb,#2575fc);
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    padding:50px;
    color:white;
}

.left h1{
    font-size:3rem;
    margin-bottom:20px;
}

.left p{
    text-align:center;
    line-height:1.8;
    opacity:0.9;
    font-size:15px;
}

/* Right Side */

.right{
    flex:1;
    background:white;
    padding:50px;
    display:flex;
    flex-direction:column;
    justify-content:center;
}

.right h2{
    font-size:2.2rem;
    margin-bottom:35px;
    color:#222;
}

/* Input */

.input-box{
    margin-bottom:22px;
}

.input-box label{
    display:block;
    margin-bottom:8px;
    color:#444;
    font-weight:500;
}

.input-box input{
    width:100%;
    padding:16px;
    border:none;
    border-radius:14px;
    background:#f1f5f9;
    font-size:15px;
    transition:0.3s;
}

.input-box input:focus{
    outline:none;
    background:#e2e8f0;
    transform:translateY(-2px);
}

/* Button */

.btn{
    width:100%;
    padding:16px;
    border:none;
    border-radius:14px;
    background:linear-gradient(135deg,#6a11cb,#2575fc);
    color:white;
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:0.3s;
    margin-top:10px;
}

.btn:hover{
    transform:translateY(-3px);
    box-shadow:0 10px 25px rgba(37,117,252,0.3);
}

/* Link */

.link{
    margin-top:25px;
    text-align:center;
    color:#555;
}

.link a{
    color:#2575fc;
    text-decoration:none;
    font-weight:600;
}

/* Error Toast */

.toast-error{
    width:100%;
    background:#ef4444;
    color:white;
    padding:14px;
    border-radius:12px;
    margin-bottom:20px;
    text-align:center;
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

/* Responsive */

@media(max-width:900px){

    .container{
        width:95%;
        flex-direction:column;
    }

    .left{
        padding:35px;
    }

    .right{
        padding:35px;
    }

    .left h1{
        font-size:2.3rem;
    }
}

</style>

</head>
<body>

<div class="background">
    <span></span>
    <span></span>
    <span></span>
</div>

<div class="container">

    <!-- Left Side -->

    <div class="left">

        <h1>Items App</h1>

        <p>
            Create your account and start managing your items
            with a modern and powerful dashboard system.
        </p>

    </div>

    <!-- Right Side -->

    <div class="right">

        <h2>Create Account</h2>

        <%
            String errorMessage =
            (String)request.getAttribute("errorMessage");
        %>

        <% if(errorMessage != null){ %>

            <div class="toast-error">
                <%= errorMessage %>
            </div>

        <% } %>

        <form action="/Items-Web-Application/SignupController"
              method="post">

            <input type="hidden"
                   name="action"
                   value="signup">

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

            <button type="submit"
                    class="btn">

                Signup

            </button>

        </form>

        <div class="link">

            Already have account ?

            <a href="login.jsp">
                Login
            </a>

        </div>

    </div>

</div>
