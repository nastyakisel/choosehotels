<%@ page language="java" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
 

<!DOCTYPE html>
<meta charset="utf-8">
<html>
<head>
<body>

<title>Страница администратора</title>
<h3>Страница администратора</h3>

<table border="1px" width="200" modelAttribute="room">
     
                    <tr>
                        <td>ID Комнаты</td>
                       <td>
                            <c:out value="${id}" />
                        </td>
                       
                </table> 
<sf:form method="post" action="save.htm" modelAttribute="room">

                    <table width="200" cellpadding="5" cellspacing="0" border="0">
                       <tr>
                       <td>ID Комнаты</td>
                            <td>
                                <input type="text" name ="room_id" value="${id}" disabled="true" size="30" />
                            </td>
                        </tr>            
                        
                        <tr>
                            <td>Дата</td>
                            <td>
                            <input type="date" name="room_date" min="2016-03-01" max="2017-03-01" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <input type="submit" value="Сохранить" />
                            </td> 
                           </tr>	
                    </table>
                </sf:form>
<sf:form method="post" action="saveDates.htm"> 
<input type="date" name="room_date" min="2016-03-01" max="2017-03-01" />
<input type="submit" value="SaveDate" />
</sf:form>
</body>
</html>