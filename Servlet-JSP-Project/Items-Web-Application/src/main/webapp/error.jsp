<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Error</title>

<head>

<meta charset="UTF-8">

<title>Error</title>

<link rel="preconnect"
      href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
      rel="stylesheet">

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

    background:linear-gradient(
        135deg,
        #0f172a,
        #1e293b,
        #312e81
    );

    overflow:hidden;
}

/* Background circles */

.circle{
    position:absolute;
    border-radius:50%;
    background:rgba(255,255,255,0.05);
    animation:float 8s infinite ease-in-out;
}

.circle1{
    width:250px;
    height:250px;
    top:-70px;
    left:-70px;
}

.circle2{
    width:300px;
    height:300px;
    bottom:-100px;
    right:-100px;
}

@keyframes float{

    0%{
        transform:translateY(0px);
    }

    50%{
        transform:translateY(20px);
    }

    100%{
        transform:translateY(0px);
    }
}

/* Error card */

.container{

    width:500px;

    padding:50px 40px;

    border-radius:30px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    box-shadow:0 20px 50px rgba(0,0,0,0.35);

    text-align:center;

    position:relative;

    z-index:2;
}

/* Error icon */

.icon{

    width:100px;
    height:100px;

    margin:0 auto 25px;

    border-radius:50%;

    background:linear-gradient(
        135deg,
        #ef4444,
        #dc2626
    );

    display:flex;
    justify-content:center;
    align-items:center;

    color:white;

    font-size:3rem;

    font-weight:700;

    box-shadow:0 10px 25px rgba(220,38,38,0.4);
}

/* Title */

.container h1{

    color:white;

    font-size:2.2rem;

    margin-bottom:15px;
}

/* Message */

.message{

    color:#cbd5e1;

    font-size:15px;

    line-height:1.8;

    margin-bottom:35px;
}

/* Button */

.back-btn{

    display:inline-block;

    text-decoration:none;

    padding:14px 28px;

    border-radius:14px;

    background:linear-gradient(
        135deg,
        #3b82f6,
        #2563eb
    );

    color:white;

    font-weight:600;

    transition:0.3s;

    box-shadow:0 10px 20px rgba(37,99,235,0.35);
}

.back-btn:hover{

    transform:translateY(-3px);
}

/* Responsive */

@media(max-width:600px){

    .container{

        width:90%;

        padding:40px 25px;
    }

    .container h1{

        font-size:1.8rem;
    }
}

</style>
</head>
<body>
	<div class="circle circle1"></div>
<div class="circle circle2"></div>

<div class="container">

    <div class="icon">
        !
    </div>

    <h1>
        Something Went Wrong
    </h1>

    <div class="message">

        <%
            String errorMessage =
                (String) request.getAttribute("errorMessage");

            if(errorMessage == null){
                errorMessage = "Unexpected server error";
            }
        %>

        <%= errorMessage %>

    </div>

    <a href="/Items-Web-Application/ItemController"
       class="back-btn">

        Back To Dashboard

    </a>

</div>
</body>
</html>