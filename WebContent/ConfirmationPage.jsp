<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
<link rel="stylesheet" type="text/css" href="StyleSheet.css">
<script type="text/javascript">
window.close = function() {
  while (w = openedWindows.shift()) {
    //cascade to children
    w.close();
  }
  window._close();
}
</script>
</head>
<body bgcolor="#408080">

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" sql="Select Max(applNumber) as applNumber from applicant;" var="result">
</sql:query>


<img class="imageposition" src="http://www.pmbl-ng.com/images/about.jpg" style="width:100px;height:100px;">


 <fieldset class="applicationposition">
 <Legend style="font-size: 16pt" class="Legend2">Loan Interest Information</Legend>
         <table>         
            <tr>
               <td class="confirmmsg1">Congratulations!!. Your application is successfully submitted. Application Number is:</td>
              </tr>
              <c:forEach var="row" items="${result.rows}" varStatus = "status">
				<tr>
				<td class="confirmmsg2">
				<c:out value="${row.applNumber}"/></td>
				</tr>
			</c:forEach>
			<tr>
			<td class="confirmmsg3">Additionally, you are eligible for Loan Amount selected with Interest Rate of:  <%= request.getAttribute("interestrate") %> </td>
              </tr>
              <tr>
                    <td><input type="button" id="close" value="Close" style="width: 100px" class="box7" onclick="javascript:window.close();"/></td>
                </tr>
            </table>
 </fieldset>

</body>
</html>