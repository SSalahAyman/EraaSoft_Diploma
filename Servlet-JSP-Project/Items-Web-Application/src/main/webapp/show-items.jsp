<%@page import="model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items Dashboard</title>

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
    background:linear-gradient(135deg,#0f172a,#1e293b,#312e81);
    background-size:cover;
    padding:30px;
    overflow-x:hidden;
}

/* Navbar */

.navbar{
    width:100%;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border:1px solid rgba(255,255,255,0.1);
    border-radius:20px;
    padding:20px 30px;
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:35px;
    box-shadow:0 10px 30px rgba(0,0,0,0.25);
}

.logo{
    font-size:1.9rem;
    font-weight:700;
    color:white;
    letter-spacing:1px;
}

.nav-right{
    display:flex;
    align-items:center;
    gap:15px;
}

/* Buttons */

.add-btn,
.logout-btn{
    text-decoration:none;
    padding:12px 22px;
    border-radius:14px;
    font-weight:600;
    transition:0.3s;
    color:white;
}

.add-btn{
    background:linear-gradient(135deg,#3b82f6,#2563eb);
    box-shadow:0 10px 20px rgba(37,99,235,0.35);
}

.logout-btn{
    background:linear-gradient(135deg,#ef4444,#dc2626);
    box-shadow:0 10px 20px rgba(220,38,38,0.35);
}

.add-btn:hover,
.logout-btn:hover{
    transform:translateY(-3px);
}

/* Page Heading */

.page-title{
    margin-bottom:30px;
}

.page-title h1{
    color:white;
    font-size:2.4rem;
    margin-bottom:8px;
    font-weight:700;
}

.page-title p{
    color:#cbd5e1;
    font-size:15px;
}

/* Items Grid */

.items-container{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(320px,1fr));
    gap:25px;
}

/* Item Card */

.card{
    position:relative;
    overflow:hidden;

    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    border-radius:24px;

    padding:28px;

    box-shadow:0 15px 35px rgba(0,0,0,0.25);

    transition:0.35s;
}

/* Top Gradient Line */

.card::before{
    content:'';
    position:absolute;
    top:0;
    left:0;
    width:100%;
    height:5px;
    background:linear-gradient(135deg,#3b82f6,#8b5cf6);
}

.card:hover{
    transform:translateY(-6px) scale(1.01);
    box-shadow:0 20px 45px rgba(0,0,0,0.35);
}

/* Item ID */

.item-id{
    display:inline-block;
    background:rgba(59,130,246,0.15);
    color:#93c5fd;

    padding:7px 14px;

    border-radius:30px;

    font-size:13px;
    font-weight:600;

    margin-bottom:18px;
}

/* Item Name */

.card h2{
    font-size:1.6rem;
    color:white;
    margin-bottom:22px;
    font-weight:600;
}

/* Item Info */

.info{
    margin-bottom:18px;
}

.info span{
    display:block;
    color:#cbd5e1;
    font-size:14px;
    margin-bottom:6px;
}

.info strong{
    color:white;
    font-size:1.1rem;
    font-weight:600;
}

/* Actions */

.actions{
    margin-top:30px;
    display:flex;
    gap:12px;
    flex-wrap:wrap;
}

.actions form{
    flex:1;
}

.actions a,
.actions button{

    width:100%;

    text-align:center;

    text-decoration:none;

    padding:12px;

    border-radius:14px;

    color:white;

    font-weight:600;

    transition:0.3s;

    border:none;

    cursor:pointer;

    font-size:15px;

    display:flex;
    justify-content:center;
    align-items:center;
}

/* Update Button */

.update-btn{
    background:linear-gradient(135deg,#10b981,#059669);
    box-shadow:0 10px 20px rgba(5,150,105,0.3);
}

/* Delete Button */

.delete-btn{
    background:linear-gradient(135deg,#ef4444,#dc2626);
    box-shadow:0 10px 20px rgba(220,38,38,0.3);
}

.actions a:hover,
.actions button:hover{

    transform:translateY(-2px);
}

/* Empty State */

.empty{
    width:100%;

    background:rgba(255,255,255,0.08);

    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,0.1);

    border-radius:25px;

    padding:60px;

    text-align:center;

    box-shadow:0 10px 30px rgba(0,0,0,0.25);
}

.empty h2{
    color:white;
    margin-bottom:12px;
    font-size:2rem;
}

.empty p{
    color:#cbd5e1;
    font-size:15px;
}

/* Responsive */

@media(max-width:768px){

    body{
        padding:15px;
    }

    .navbar{
        flex-direction:column;
        align-items:flex-start;
        gap:20px;
    }

    .nav-right{
        width:100%;
        flex-direction:column;
    }

    .add-btn,
    .logout-btn{
        width:100%;
        text-align:center;
    }

    .page-title h1{
        font-size:2rem;
    }

    .items-container{
        grid-template-columns:1fr;
    }

    .actions{
        flex-direction:column;
    }
}

/* Scrollbar */

::-webkit-scrollbar{
    width:8px;
}

::-webkit-scrollbar-track{
    background:#111827;
}

::-webkit-scrollbar-thumb{
    background:linear-gradient(135deg,#3b82f6,#8b5cf6);
    border-radius:20px;
}

.details-btn{
    flex:1;

    background:linear-gradient(135deg,#8b5cf6,#7c3aed);

    box-shadow:0 10px 20px rgba(124,58,237,0.3);
}

.view-details-btn{

    flex:1;

    background:linear-gradient(135deg,#06b6d4,#0891b2);

    box-shadow:0 10px 20px rgba(8,145,178,0.3);
}

</style>

</head>
<body>

<!-- Navbar -->

<div class="navbar">

    <div class="logo">
        Items App
    </div>

    <div class="nav-right">

        <a href="/Items-Web-Application/add-Item.html" class="add-btn">
            + Add Item
        </a>

        <a href="/Items-Web-Application/AuthController?action=logout"
           class="logout-btn">
            Logout
        </a>

    </div>

</div>

<!-- Page Heading -->

<div class="page-title">

    <h1>Items Dashboard</h1>

    <p>
        Manage all your items easily
    </p>

</div>

<!-- Items -->

<div class="items-container">

<%
    List<Item> items =(List<Item>) request.getAttribute("allItems");
%>

<%
    if(items == null || items.isEmpty()){
%>

<div class="empty">

    <h2>No Items Found</h2>

    <p>
        Start by adding your first item
    </p>

</div>

<%
    }else{

        for(Item item : items){
%>

<div class="card">

    <div class="item-id">
        ID #<%= item.getId() %>
    </div>

    <h2>
        <%= item.getName() %>
    </h2>

    <div class="info">

        <span>Price</span>

        <strong>
            $ <%= item.getPrice() %>
        </strong>

    </div>

    <div class="info">

        <span>Total Quantity</span>

        <strong>
            <%= item.getTotalNumber() %>
        </strong>

    </div>

    <div class="actions">

    <!-- UPDATE -->

    <a class="update-btn"
       href="/Items-Web-Application/ItemController?action=show-item&id=<%= item.getId()%>">

        Update

    </a>

    <!-- DELETE -->

    <form action="/Items-Web-Application/ItemController"
          method="post">

        <input type="hidden"
               name="action"
               value="delete-item">

        <input type="hidden"
               name="id"
               value="<%= item.getId() %>">

        <button type="submit"
                class="delete-btn">

            Delete

        </button>

    </form>

    <!-- ITEM DETAILS -->
    
    <% if(!item.isHasDetails()) { %>
    	
    	<a class = "details_btn" 
    	   href = "/Items-Web-Application/ItemDetailsController?action=show-add-details-form&id=<%= item.getId() %>">
    	   
    	    Add Details
         </a>

    <% } else { %>
    
    	<!-- VIEW DETAILS -->

	    <a class="view-details-btn"
	       href="/Items-Web-Application/ItemDetailsController?action=view-item-details&id=<%= item.getId() %>">
	
	        View Details
	
	    </a>
    	
    	<a class="details-btn"
       href="/Items-Web-Application/ItemDetailsController?action=show-update-details-form&id=<%= item.getId() %>">

        Update Details

    	</a>
    
    <% } %>

	</div>

</div>

<%
        }
    }
%>

</div>

</body>
</html>





