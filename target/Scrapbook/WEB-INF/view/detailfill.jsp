<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<html>
    <head>
        <style>
            body{
                background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvUee8AFVeGF-H3Fmb4BquBBGgXS7o-VoBvpYIGYAyLr0CaAzGqQ');
            background-repeat: no-repeat;
            opacity: 0.8;
            background-size: cover;
            
            }
            #in
            {
                background: transparent;
                border: none;
                border-bottom: 1px solid darkmagenta;
                outline: none;
                box-shadow: none;
                text-align: center;
            }
    tr,td{
        font-style: italic;
        font-size: 20px;
        padding: 4px;
        color: darkblue;
    }
    input
    {
        font-size: 20px;
    }
            
           
        </style>

    </head>
    <body>
        <div>
            <form:form action="save" modelAttribute="listofrecords">
                <table style="text-align: center;">
                <tr>
                <td><form:input path="id"/></td>
                </tr>
                    <tr>
                        <td>Your name:</td></tr>
                        <tr><td><form:input path="name" /></td>
                        </tr>
                    
                        <tr>
                        <td> Your relation with me:</td></tr><tr><td><form:input path="rel"/></td>
                    </tr>
                    <tr>
                            <td>Your date of birth:</td></tr><tr><td><form:input path="date"/></td>
                        </tr>
                        <tr>
                                <td>Zodiac Sign:</td></tr><tr><td><form:input path="zodiacsign"/></td>
                                </tr>
                                <tr>
                                        <td>Contact number :</td></tr><tr><td><form:input path="contactno"/></td>
                                        </tr>
                                        <tr><td>Lyrics of any song that describes you:</td></tr>
                                        <tr><td><form:input path="lyrics" /></td></tr>
                                    
                                        <tr><td><input style="width: 70%;"style="height: 60%;" type="submit" /></td></tr>
                                       
                </table>
            </form:form>
        </div>
    </body>
</html>