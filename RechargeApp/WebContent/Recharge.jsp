
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="RechargeController">
Mobile no<input type="text" name="mob"><br>
Amount<input type="text" name="amt"><br>
 Select Operator<select name="oper"><br>
<option>Airtel</option>
<option>Vodafone</option>
<option>Idea</option>
<option>Jio</option>
<option>TataDocomo</option>
<option>BSNL</option>
</select><br>
<input type="submit" value="submit">

</form>
</body>
</html>