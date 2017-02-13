<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<meta charset="utf-8">
<html>
<head>
<body>

<title>Страница администратора</title>
<h3>Страница администратора</h3>

<sf:form method="post" action="saveRooms.htm">  

                    <table width="250" cellpadding="5" cellspacing="0" border="0">
                        <tr>
                            <td bgcolor="F6F6F6">
                            <font face="Verdana" size="4">Добавить комнату</font>
                            </td>
                        </tr>
                        <tr>
                            <td>Описание</td>
                            <td>Количество человек </td>
                            <td>Цена</td>
                            <td>Отель</td>
                        </tr>            
                        <tr>
                            <td>
                            	
                                <input type="text" name="description" size="30" /><br/>
                                
                            </td>
                            <td>
                                
                                <input type="text" name="number_of_persons" size="30" />
                            </td>
                            <td>
                                <input type="text" name="price" size="30" />
                            </td>
                            <td>
                                <input type="text" name="hotel_name" size="30" />
                            </td>
                        </tr>
                        <tr>
                            <td>Дата</td>
                            
                        </tr> 
                        <tr>
                            <td>
                            <input type="date" name="arr" min="2016-03-01" max="2017-03-01"/>
                            
                            </td>
                            
                        
                        
                 
                            <td colspan="2" align="left">
                                <input type="submit" value="Добавить" />
                            </td> 
                    </table>
                </sf:form>
  
<br>               
<sf:form method="post" action="saveHotels.htm" modelAttribute="hotel">  

                    <table width="250" cellpadding="5" cellspacing="0" border="0">
                        <tr>
                            <td bgcolor="F6F6F6">
                            <font face="Verdana" size="4">Добавить отель</font>
                            </td>
                        </tr>
                        <tr>
                            <td>Нименование</td>
                            <td>Адрес</td>
                            <td>Город</td>
                            
                        </tr>            
                        <tr>
                            <td>
                                <input type="text" name="hotelName" size="30" />
                            </td>
                            <td>
                                <input type="text" name="hotelAddress" size="30" />
                            </td>
                           <td>
                                <input type="text" name="city_name" size="30" />
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td colspan="2" align="right">
                                <input type="submit" value="Добавить" />
                            </td> 
                    </table>
                </sf:form>  

<sf:form method="post" action="showOrders.htm"> 
<input type="submit" value="Посмотреть заказы" />
</sf:form>
</body>
</html>