<%@ page language="java" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
         <c:forEach items="${hotels}" var="onehotel">
         <tr> 
           <td>
           <a href="browseHotel.htm?id=${onehotel.id}"><c:out value="${onehotel.hotelName}" /></a>
           </td>
           
         </tr>
        </c:forEach>
    </table>
</body>
</html>