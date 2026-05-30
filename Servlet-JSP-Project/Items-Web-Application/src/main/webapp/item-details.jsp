<%@page import="model.ItemDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Item Details</title>

<link rel="preconnect" href="https://fonts.googleapis.com">

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

    padding:30px;

    background:linear-gradient(135deg,#0f172a,#1e293b,#312e81);
}

.container{
    width:100%;
    max-width:800px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    border-radius:28px;

    padding:40px;

    box-shadow:0 20px 45px rgba(0,0,0,0.3);

    position:relative;

    overflow:hidden;
}

.container::before{
    content:'';

    position:absolute;

    top:0;
    left:0;

    width:100%;
    height:5px;

    background:linear-gradient(135deg,#3b82f6,#8b5cf6);
}

.title{
    text-align:center;

    margin-bottom:35px;
}

.title h1{
    color:white;

    font-size:2.4rem;

    margin-bottom:10px;
}

.title p{
    color:#cbd5e1;
}

.details-grid{
    display:grid;

    grid-template-columns:1fr 1fr;

    gap:20px;
}

.detail-card{
    background:rgba(255,255,255,0.06);

    border:1px solid rgba(255,255,255,0.08);

    border-radius:20px;

    padding:22px;
}

.detail-card span{
    display:block;

    color:#94a3b8;

    margin-bottom:8px;

    font-size:14px;
}

.detail-card strong{
    color:white;

    font-size:17px;

    line-height:1.6;
}

.back-btn{
    display:block;

    width:100%;

    margin-top:35px;

    text-align:center;

    text-decoration:none;

    padding:16px;

    border-radius:16px;

    background:linear-gradient(135deg,#3b82f6,#2563eb);

    color:white;

    font-weight:600;

    transition:0.3s;
}

.back-btn:hover{
    transform:translateY(-3px);
}

@media(max-width:700px){

    .details-grid{
        grid-template-columns:1fr;
    }

    .container{
        padding:25px;
    }
}

</style>

</head>

<body>

<%
    ItemDetails details =
        (ItemDetails) request.getAttribute("itemDetails");
%>

<div class="container">

    <div class="title">

        <h1>Item Details</h1>

        <p>
            Full information about this item
        </p>

    </div>

    <div class="details-grid">

        <div class="detail-card">

            <span>Description</span>

            <strong>
                <%= details.getDescription() %>
            </strong>

        </div>

        <div class="detail-card">

            <span>Brand</span>

            <strong>
                <%= details.getBrand() %>
            </strong>

        </div>

        <div class="detail-card">

            <span>Color</span>

            <strong>
                <%= details.getColor() %>
            </strong>

        </div>

        <div class="detail-card">

            <span>Weight</span>

            <strong>
                <%= details.getWeight() %>
            </strong>

        </div>

    </div>

    <a href="/Items-Web-Application/ItemController?action=show-items"
       class="back-btn">

        Back To Dashboard

    </a>

</div>

</body>
</html>