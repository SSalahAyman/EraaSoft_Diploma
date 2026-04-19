<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task 1 of lecture 1</title>
</head>
<body>
	<%!
	// here define two variables (id,name) with specific values
		Integer id =1 ;
		String name ="Salah";
	// here define function that accept two inputs (id,name) and return return concatination with id and name
		public String concatinateTwoInputs(){
			String afterConcatinate = id.toString().concat(name);
			return afterConcatinate;
		}
	%>
	
	<%
	// here we call function and use [out.print] to print the result on jsp file
		String result = concatinateTwoInputs();
		out.print("<h1>"+ result +"</h1>");
	%>
	
</body>
</html>