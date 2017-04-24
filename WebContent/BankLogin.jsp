<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cognizant Bank Portal</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
</head>
<body bgcolor="#408080">

<img class="imageposition" src="http://www.pmbl-ng.com/images/about.jpg" style="width:100px;height:100px;">

    <form action="LoginPage" method="post">
        <fieldset class="loginposition">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" required="required" style="width: 200px" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" required="required" style="width: 200px"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" style="width: 60px" class="box1"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>