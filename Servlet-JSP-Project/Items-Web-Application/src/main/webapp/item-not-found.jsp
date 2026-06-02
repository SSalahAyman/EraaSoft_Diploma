<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Not Found</title>

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

    background:linear-gradient(135deg,#0f172a,#1e293b,#312e81);

    padding:20px;
}

.container{

    width:100%;
    max-width:650px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    border-radius:28px;

    padding:50px;

    text-align:center;

    position:relative;

    overflow:hidden;

    box-shadow:0 20px 45px rgba(0,0,0,0.3);
}

.container::before{

    content:'';

    position:absolute;

    top:0;
    left:0;

    width:100%;
    height:5px;

    background:linear-gradient(135deg,#ef4444,#dc2626);
}

.icon{

    font-size:70px;

    margin-bottom:20px;
}

h1{

    color:white;

    font-size:2.5rem;

    margin-bottom:15px;
}

.message{

    color:#cbd5e1;

    font-size:16px;

    line-height:1.8;

    margin-bottom:35px;
}

.btn{

    display:inline-block;

    text-decoration:none;

    padding:15px 30px;

    border-radius:16px;

    background:linear-gradient(135deg,#3b82f6,#2563eb);

    color:white;

    font-weight:600;

    transition:0.3s;

    box-shadow:0 10px 25px rgba(37,99,235,0.35);
}

.btn:hover{

    transform:translateY(-3px);
}

</style>

</head>
<body>

<div class="container">

    <div class="icon">
        ❌
    </div>

    <h1>Item Not Found</h1>

    <p class="message">

        The requested item does not exist or may have been deleted.

    </p>

    <a href="<%=request.getContextPath()%>/ItemController?action=show-items"
       class="btn">

        Back To Dashboard

    </a>

</div>

</body>
</html>