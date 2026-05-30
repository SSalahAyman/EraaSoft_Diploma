<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Update Item Details</title>

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
    max-width:700px;

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

    background:linear-gradient(135deg,#10b981,#059669);
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

.input-box input,
.input-box textarea{

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

/* textarea */

.input-box textarea{

    resize:none;

    min-height:130px;
}

.input-box input::placeholder,
.input-box textarea::placeholder{

    color:#94a3b8;
}

.input-box input:focus,
.input-box textarea:focus{

    outline:none;

    border-color:#10b981;

    background:rgba(255,255,255,0.12);

    box-shadow:0 0 0 4px rgba(16,185,129,0.15);
}

/* Remove Number Arrows */

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button{

    -webkit-appearance:none;

    margin:0;
}

/* Buttons */

.actions{

    margin-top:30px;

    display:flex;

    gap:15px;
}

.update-btn{

    flex:1;

    padding:16px;

    border:none;

    border-radius:16px;

    background:linear-gradient(135deg,#10b981,#059669);

    color:white;

    font-size:16px;

    font-weight:600;

    cursor:pointer;

    transition:0.3s;

    box-shadow:0 10px 25px rgba(5,150,105,0.35);
}

.cancel-btn{

    flex:1;

    display:flex;

    justify-content:center;

    align-items:center;

    text-decoration:none;

    border-radius:16px;

    background:linear-gradient(135deg,#ef4444,#dc2626);

    color:white;

    font-size:16px;

    font-weight:600;

    transition:0.3s;

    box-shadow:0 10px 25px rgba(220,38,38,0.35);
}

.update-btn:hover,
.cancel-btn:hover{

    transform:translateY(-3px);
}

/* Responsive */

@media(max-width:650px){

    .container{
        padding:30px 22px;
    }

    .title h1{
        font-size:2rem;
    }

    .actions{
        flex-direction:column;
    }
}

</style>

</head>
<body>

<div class="container">

    <div class="title">

        <h1>Update Item Details</h1>

        <p>
            Edit the existing details of your item
        </p>

    </div>

    <form action="/Items-Web-Application/ItemDetailsController"
          method="post">

        <!-- ITEM ID -->

        <input type="hidden"
               name="itemId"
               value="${itemDetails.itemId}">

        <input type="hidden"
               name="detailsId"
               value="${itemDetails.id}">

        <input type="hidden"
               name="action"
               value="update-item-details">

        <!-- DESCRIPTION -->

        <div class="input-box">

            <label>Description</label>

            <textarea name="description"
                      required>${itemDetails.description}</textarea>

        </div>

        <!-- BRAND -->

        <div class="input-box">

            <label>Brand</label>

            <input type="text"
                   name="brand"
                   value="${itemDetails.brand}"
                   required>

        </div>

        <!-- COLOR -->

        <div class="input-box">

            <label>Color</label>

            <input type="text"
                   name="color"
                   value="${itemDetails.color}">

        </div>

        <!-- WEIGHT -->

        <div class="input-box">

            <label>Weight (KG)</label>

            <input type="number"
                   step="0.01"
                   name="weight"
                   value="${itemDetails.weight}">

        </div>

        <!-- ACTIONS -->

        <div class="actions">

            <button type="submit"
                    class="update-btn">

                Update Details

            </button>

            <a href="/Items-Web-Application/ItemController?action=show-items"
               class="cancel-btn">

                Cancel

            </a>

        </div>

    </form>

</div>

</body>
</html>