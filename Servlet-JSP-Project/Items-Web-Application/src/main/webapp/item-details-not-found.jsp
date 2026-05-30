<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
أيوه، إحنا اتكلمنا قبل كده إن لو المستخدم ضغط View Details على Item ملوش Details أصلاً، نعرض صفحة مخصصة بدل Error.

ممكن تعمل صفحة اسمها:

item-details-not-found.jsp

بنفس تصميم المشروع:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Details Not Found</title>

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
}

.container{

    width:500px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    border-radius:28px;

    padding:50px;

    text-align:center;

    box-shadow:0 20px 45px rgba(0,0,0,0.3);

    position:relative;
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

    width:90px;
    height:90px;

    margin:auto;

    border-radius:50%;

    background:linear-gradient(135deg,#ef4444,#dc2626);

    color:white;

    display:flex;
    justify-content:center;
    align-items:center;

    font-size:42px;

    margin-bottom:25px;

    box-shadow:0 10px 25px rgba(220,38,38,0.35);
}

h1{

    color:white;

    margin-bottom:15px;

    font-size:2rem;
}

p{

    color:#cbd5e1;

    line-height:1.8;

    margin-bottom:30px;
}

.btn{

    display:inline-block;

    padding:14px 28px;

    border-radius:14px;

    text-decoration:none;

    color:white;

    font-weight:600;

    background:linear-gradient(135deg,#3b82f6,#2563eb);

    box-shadow:0 10px 25px rgba(37,99,235,0.35);

    transition:.3s;
}

.btn:hover{

    transform:translateY(-3px);
}

</style>

</head>
<body>

<div class="container">

    <div class="icon">
        !
    </div>

    <h1>Details Not Found</h1>

    <p>
        This item does not have any details yet.
    </p>

    <a class="btn"
       href="/Items-Web-Application/ItemController?action=show-items">

        Back To Dashboard

    </a>

</div>

</body>
</html>