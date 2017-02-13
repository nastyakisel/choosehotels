<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" action="saveLoginData.htm">  <!-- modelAttribute="hotel"-->

                    <table width="250" cellpadding="5" cellspacing="0" border="0">
                        <tr>
                            <td bgcolor="F6F6F6">
                            <font face="Verdana" size="4">Регистрация</font>
                            </td>
                        </tr>
                          
                        <tr>
                            <td>
                                Адрес электронной почты:
                                <input type="text" name="email" size="30" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Пароль:
                                <input type="text" name="password" size="30" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <input type="submit" value="Сохранить" />
                            </td> 
                    </table>
                </sf:form>
</body>
</html>