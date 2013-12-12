<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import= "java.util.Iterator,model.CommodityEntity,dao.ConnectionCommodity" %>
 <%! Iterable<CommodityEntity> goods=ConnectionCommodity.getCommodity();
     String email=null;
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <%email=(String)request.getSession().getAttribute("email");

 %>
<h3><%=email%>: welcome to come with us
</h3>
<body>
<form action="PlaceOrder" method="post">
<table width="500" border="1">
  <tr>
    <td width="200"><div align="center">Name</div></td>
    <td width="200"><div align="center">Price</div></td>
    <td width="100"><div align="center">Add</div></td>
  </tr>
    <% for(CommodityEntity commodity:goods){
	  
  %>

  <tr>
    <td width="200"><div align="center"><%=commodity.getPartitionKey() %></div></td>
    <td width="200"><div align="center"><%=commodity.getPrice() %></div></td>
   <td width="100"><div align="center"><input type="radio" name="goods" value="<%=commodity.getPartitionKey()%>"></input></div></td>
  </tr>
  <%} %>
</table>
<input type="submit" value="Submit"></input>
</form>
</body>
</html>