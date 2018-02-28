<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.cars02.AllCarsOptions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
   <title>Create New Ad</title>

   <% AllCarsOptions allCarsOptions = new AllCarsOptions();  %>

</head>
<body>
webapp/createNewAd.jsp <br><br><br><br>


   <form action="${pageContext.servletContext.contextPath}/check/createedit02" method="post">

      Brand:
      <select name="brand">
         <c:forEach items="<%=allCarsOptions.getCarsBrand() %>" var="brand">
            <option value="${brand.id}">${brand.name}</option>
         </c:forEach>
      </select> <br><br>

      Model:
      <select name="model">
         <c:forEach items="<%=allCarsOptions.getCarsModel() %>" var="model">
            <option value="${model.id}">${model.name}</option>
         </c:forEach>
      </select><br><br>

      Body type:
      <select name="bodyType">
         <c:forEach items="<%=allCarsOptions.getCarsBodyType() %>" var="bodyType">
            <option value="${bodyType.id}">${bodyType.name}</option>
         </c:forEach>
      </select><br><br>

      Transmission:
      <select name="transmission">
         <c:forEach items="<%=allCarsOptions.getCarsTransmission() %>" var="transmission">
            <option value="${transmission.id}">${transmission.name}</option>
         </c:forEach>
      </select> <br><br>

      EngineType:
      <select name="engineType">
         <c:forEach items="<%=allCarsOptions.getCarsEngineType() %>" var="engineType">
            <option value="${engineType.id}">${engineType.name}</option>
         </c:forEach>
      </select> <br><br>

      Drive by:
      <select name="driveUnit">
         <c:forEach items="<%=allCarsOptions.getCarsDriveUnit() %>" var="driveUnit">
            <option value="${driveUnit.id}">${driveUnit.name}</option>
         </c:forEach>
      </select><br><br>

      Heating system:<br>
      <c:forEach items="<%=allCarsOptions.getCarsHeating() %>" var="driveUnit">
         <input type="checkbox" name="heating" value="${driveUnit.id}">${driveUnit.name}<br>
      </c:forEach> <br><br>

      Mileage:<input type="text" name="mileage" value=""><br><br>
      Description:<input type="text" name="description" value="Descr-"><br><br>

      <br><input type="submit" value="Create">
   </form>

   <% allCarsOptions.closeSeesion(); %>
</body>
</html>
