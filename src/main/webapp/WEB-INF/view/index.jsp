<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
 body{
                background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvUee8AFVeGF-H3Fmb4BquBBGgXS7o-VoBvpYIGYAyLr0CaAzGqQ');
            background-repeat: no-repeat;
            opacity: 0.8;
            background-size: cover;
            font-size: 25px;
            font-style: italic;
            font-family: cursive;
            
            }
           
            tr,td{
        font-style: italic;
        font-size: 25px;
        margin: 2px;
        padding: 6px;
        color: darkblue;
          }
          table
          {
          margin-top: 5px;
          }
</style>
</head>
<body>
<h1>Scrap Book application</h1>
<a href="detail">New Contact</a>

<table border="1" >
<tr>
<th>Id</th>
<th>Name</th>
<th>Date of birth</th>
<th>Zodiac Sign</th>
<th>contact number</th>
<th>Lyrics that describes you</th>
<th>Action</th>
</tr>

<c:forEach items="${listofrecords }" var="records" varStatus="status">
<tr>
<td>${status.index +1}</td>
<td>${records.name}</td>
<td>${records.date}</td>
<td>${records.zodiacsign}</td>
<td>${records.contactno}</td>
<td>${records.lyrics}</td>
<td><a href="edit?id=${records.id}">Edit</a> &nbsp;&nbsp;
<a href="delete?id=${records.id}">Delete</a>
</td>

</tr>

</c:forEach>
</table>
</body>
</html>
