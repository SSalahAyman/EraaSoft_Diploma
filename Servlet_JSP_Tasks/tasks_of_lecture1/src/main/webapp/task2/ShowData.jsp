<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #74ebd5, #ACB6E5);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background: white;
        padding: 30px;
        border-radius: 12px;
        width: 350px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    .data {
        background: #f7f7f7;
        padding: 10px;
        margin: 10px 0;
        border-radius: 8px;
        font-size: 16px;
        color: #444;
    }

    .label {
        font-weight: bold;
        color: #222;
    }
</style>

</head>
<body>
	<%
		String fullName= request.getParameter("full_name");
		String password = request.getParameter("Password");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String radioAddress = request.getParameter("address_radio");
		String selectAddress = request.getParameter("address_select");
	%>
	
	<div class="container">
    <h2>User Data</h2>

    <div class="data">
        <span class="label">Full Name:</span> <%= fullName %>
    </div>

    <div class="data">
        <span class="label">Password:</span> <%= password %>
    </div>

    <div class="data">
        <span class="label">Age:</span> <%= age %>
    </div>

    <div class="data">
        <span class="label">Radio Address:</span> <%= radioAddress %>
    </div>

    <div class="data">
        <span class="label">Selected Address:</span> <%= selectAddress %>
    </div>
</div>
	
	
</body>
</html>