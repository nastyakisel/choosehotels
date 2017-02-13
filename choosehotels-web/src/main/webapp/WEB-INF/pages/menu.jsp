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

<h3>Выберите город</h3>
		<table>	
         <c:forEach items="${allcities}" var="onecity">
         <tr> 
           <td>
           <a href="browseCatalog.htm?id=${onecity.id}"><c:out value="${onecity.cityName}" /></a>
           </td>
           
         </tr>
         </c:forEach>
    </table>
     
</body>
</html>



