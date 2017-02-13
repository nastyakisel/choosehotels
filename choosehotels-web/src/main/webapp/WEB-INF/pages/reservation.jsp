<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored ="false" %>

<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<sf:form method="post" action="hibernateSearchResults2.htm" modelAttribute="orders">

                    <table width="450" cellpadding="5" cellspacing="0" border="0">
                        <tr>
                            <td bgcolor="F6F6F6">
                            <font face="Verdana" size="4">Бронирование отеля</font>
                            </td>
                        </tr>
                        <td> Отель</td>
                            <td> Комната</td>
                            <td> Цена</td>
                        </tr>            
                        <tr>
                            <td>
                                <input type="text" value="${myroom.getHotel().hotelName}" disabled="true" size="30" />
                            </td>
                            <td>
                                <input type="text" value="${myroom.description}" disabled="true" size="30" />
                            </td>
                            <td>
                                <input type="text" value="${myroom.price}" disabled="true" size="5"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Дата прибытия</td>
                            <td>Дата отъезда</td>
                            <td>
                        </tr>
                        <tr>
                        	<td>
                            <input type="text" value="${arrival2}" disabled="true"/>                           
                            </td>
                            <td>
                            <input type="text" value="${departure2}" disabled="true"/>
                            </td>
                            <td>Количество ночей:<input type="text" value="" disabled="true" size="3"/>
                            </td>
                        </tr> 
                        <tr>
                            <td> 
                            <font face="Verdana">Имя</font>
                            </td>
                            <td> 
                            <font face="Verdana">Фамилия</font>
                            </td>
                        </tr>            
                        <tr>
                            <td>
                                <input type="text" name="contactName" placeholder="Имя" size="30" />
                            </td>
                            <td>
                                <input type="text" name="surname" placeholder="Фамилия" size="30" />
                            </td>
                        </tr>
                        <tr>
                            <td> 
                            <font face="Verdana">Адрес</font>
                            </td>
                            <td> 
                            <font face="Verdana">Электронная почта</font>
                            </td>
                        </tr>  
                         <tr>
                            <td>
                                <input type="text" name="address" placeholder="Адрес" size="30" />
                            </td>
                            <td>
                                <input type="text" name="email" placeholder="e-mail" size="30" />
                            </td>
                        </tr>   
                        <tr>
                            <td> 
                            <font face="Verdana">CCNumber</font>
                            
                        </tr>    
                        <tr>
                            <td>
                                <input type="text" name="CCNumber" placeholder="CCNumber" size="30" />
                            </td>
                            </td>
                            <td> Количество человек:<input type="text" value="${myroom.number_of_persons}" disabled="true" size="3"/></td>
                        </tr>       
                        <tr>
                            <td colspan="2" align="right">
                                <input type="submit" value="Забронировать" />
                            </td> 
                    </table>
                </sf:form>
</body>
</html>