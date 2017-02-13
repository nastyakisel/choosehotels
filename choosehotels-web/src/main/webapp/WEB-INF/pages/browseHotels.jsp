<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List"%>
<%@ page import="com.kiselproject.choosehotels.domain.City"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>Отели</h3>
		<table>	
         <c:forEach items="${rooms}" var="oneroom">
         <tr> 
           
           <td>
           <c:out value="${oneroom.description}" />
           </td>
           <td>
           <c:out value="${oneroom.price}" />
           </td>
         </tr>
        </c:forEach>
    </table>
</body>
</html>