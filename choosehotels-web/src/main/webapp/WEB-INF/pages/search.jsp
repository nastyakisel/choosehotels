<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form method="post" action="hibernateSearchResults2.htm">  <!-- modelAttribute="hotel"-->

                    <table width="250" cellpadding="5" cellspacing="0" border="0">
                        <tr>
                            <td bgcolor="F6F6F6">
                            <font face="Verdana" size="4">Найти отель</font>
                            </td>
                        </tr>
                        <tr>
                            <td bgcolor="F6F6F6" > 
                            <font face="Verdana">Введите название отеля или города</font>
                            </td>
                        </tr>            
                        <tr>
                            <td>
                                <input type="hidden" name="action" value="search" />
                                <input type="text" name="hotelName" size="30" />
                            </td>
                        </tr>
                        <tr>
                            <td>Дата прибытия</td>
                        </tr> 
                        <tr>
                            <td>
                            <input type="date" name="arrival" min="2016-03-01" max="2017-03-01"/>
                            
                            </td>
                        </tr> 
                        <tr>
                            <td>Дата отъезда</td>
                        </tr> 
                        <tr>
                            <td>
                            <input type="date" name="departure" min="2016-03-01" max="2017-03-01"/>
                            </td>
                        </tr> 
                        <tr>
                            <td>Количество номеров
                            <select name="number_of_rooms">
                            <option value =1>1</option>
                            <option value =2>2</option>
                            <option value =3>3</option>
                            <option value =4>4</option>
                            <option value =5>5</option>
                            <option value =6>6</option>
                            <option value =7>7</option>
                            <option value =8>8</option>
                            <option value =9>9</option>
                            <option value =10>10</option>
                            </select>
                            </td>
                            
                            <td>Количество человек
                            <select name="number_of_persons">
                            <option value =1>1</option>
                            <option value =2>2</option>
                            <option value =3>3</option>
                            <option value =4>4</option>
                            <option value =5>5</option>
                            <option value =6>6</option>
                            <option value =7>7</option>
                            <option value =8>8</option>
                            <option value =9>9</option>
                            <option value =10>10</option>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <input type="submit" value="Искать" />
                            </td> 
                    </table>
                </sf:form>
                


<sf:form method="post" action="saveDates.htm"> 
<input type="date" name="room_date" min="2016-03-01" max="2017-03-01" />
<input type="submit" value="SaveDate" />
</sf:form>
