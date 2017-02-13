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

<td><%@include file="/WEB-INF/pages/administrator.jsp" %></td>
<table border="1px" width="400" modelAttribute="orders">
				<c:forEach items="${orders}" var="order">	
                <tr>
                        <td>Заказ №</td>
                        <td>
                            <c:out value="${order.id}" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Имя</td>
                        <td>Фамилия</td>
                        <td>Адрес</td>
                        <td>e-mail</td>
                        <td>Номер карты</td>
                    </tr>
                    <tr>
                       <td>
                            <c:out value="${order.contactName}" />
                        </td>
                        <td>
                            <c:out value="${order.surname}" />
                        </td>
                        <td>
                            <c:out value="${order.address}" />
                        </td>
                        <td>
                            <c:out value="${order.email}" />
                        </td>
                        <td>
                            <c:out value="${order.ccNumber}" />
                        </td>
                        </tr>
                        <tr>
                        <td>Отель</td>
                        <td>Комната №</td>
                        <td>Описание</td>
                        <td>Дата заезда</td>
                        <td>Дата выбытия</td>
                        </tr>
                        <tr>
                       <td>
                            <c:out value="${order.getRoom().getHotel().getHotelName()}" />
                        </td>
                        <td>
                            <c:out value="${order.getRoom().getId()}" />
                        </td>
                        <td>
                            <c:out value="${order.getRoom().description}" />
                        </td>
                        <td>
                            <c:out value="${order.dateOfArrival}" />
                        </td>
                        <td>
                            <c:out value="${order.dateOfDispature}" />
                        </td>
                        
                        </tr>
                      
                </c:forEach>
                </table>
				

</td>

</table>
</body>
</html>