<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Update Item</title>

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

/* Container */

.container{
    width:100%;
    max-width:600px;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    border-radius:28px;

    padding:40px;

    box-shadow:0 20px 45px rgba(0,0,0,0.3);

    position:relative;

    overflow:hidden;
}

/* Top Gradient Border */

.container::before{
    content:'';

    position:absolute;

    top:0;
    left:0;

    width:100%;
    height:5px;

    background:linear-gradient(135deg,#10b981,#3b82f6);
}

/* Title */

.title{
    text-align:center;
    margin-bottom:35px;
}

.title h1{
    color:white;
    font-size:2.5rem;
    margin-bottom:8px;
}

.title p{
    color:#cbd5e1;
    font-size:15px;
}

/* Input Group */

.input-box{
    margin-bottom:24px;
}

.input-box label{
    display:block;

    color:#e2e8f0;

    margin-bottom:10px;

    font-size:15px;

    font-weight:500;
}

.input-box input{
    width:100%;

    padding:16px;

    border:none;

    border-radius:16px;

    background:rgba(255,255,255,0.08);

    border:1px solid rgba(255,255,255,0.1);

    color:white;

    font-size:15px;

    transition:0.3s;
}

.input-box input:focus{
    outline:none;

    border-color:#10b981;

    background:rgba(255,255,255,0.12);
}

/* Remove Arrows */

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button{
    -webkit-appearance:none;
    margin:0;
}

/* Submit Button */

.btn{
    width:100%;

    padding:16px;

    border:none;

    border-radius:16px;

    background:linear-gradient(135deg,#10b981,#059669);

    color:white;

    font-size:16px;

    font-weight:600;

    cursor:pointer;

    transition:0.3s;

    margin-top:10px;

    box-shadow:0 10px 25px rgba(5,150,105,0.35);
}

.btn:hover{
    transform:translateY(-3px);
}

/* Back Link */

.back{
    margin-top:25px;
    text-align:center;
}

.back a{
    color:#cbd5e1;

    text-decoration:none;

    transition:0.3s;
}

.back a:hover{
    color:white;
}

/* Responsive */

@media(max-width:650px){

    .container{
        padding:30px 22px;
    }

    .title h1{
        font-size:2rem;
    }
}

</style>

</head>
<body>

<div class="container">

    <div class="title">

        <h1>Update Item</h1>

        <p>Edit item information</p>

    </div>

    <form action="/Items-Web-Application/ItemController">

        <div class="input-box">

            <label>Item Name</label>

            <input type="text"
                   name="itemName"
                   value="${itemSelected.name}"
                   required>

        </div>

        <div class="input-box">

            <label>Item Price</label>

            <input type="number"
                   step="0.01"
                   name="itemPrice"
                   value="${itemSelected.price}"
                   required>

        </div>

        <div class="input-box">

            <label>Total Quantity</label>

            <input type="number"
                   name="itemTotalNumber"
                   value="${itemSelected.totalNumber}"
                   required>

        </div>

        <input type="hidden"
               name="id"
               value="${itemSelected.id}">

        <input type="hidden"
               name="action"
               value="update-item">

        <button type="submit" class="btn">

            Update Item

        </button>

    </form>

    <div class="back">

        <a href="/Items-Web-Application/ItemController">

            ← Back To Items

        </a>

    </div>

</div>

</body>
</html>