<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.job4j.cars02.AllCarsAds" %>
<%@ page import="ru.job4j.cars02.models.CarsAds" %>
<%@ page import="ru.job4j.cars02.models.CarsAdsHeatingDetails" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Все авто на продажу</title>
</head>
<body>

webapp/carsAds.jsp <br>

<% String error = request.getParameter("message"); %>
<c:if test="${error != ''}">
   <div style="background-color: red">
         ${error}
   </div><br>
</c:if>

<% String message = request.getParameter("message"); %>
<c:if test="${message != ''}">
   <h1>${message}</h1><br>
</c:if>


<% AllCarsAds allCarsAds = new AllCarsAds();
   List<CarsAds> listAds = allCarsAds.getAllAds();
%>


<table>
    <tr>
        <td>ID:</td>
        <td>Марка</td>
        <td>Модель</td>
        <td>Кузов</td>
        <td>Сцепление</td>
        <td>Двигатель</td>
        <td>Привод</td>
        <td>Heating</td>
        <td>ID Владельца</td>
        <td>Пробег</td>
        <td>Описание</td>
        <td>фото</td>
        <td></td>
        <td></td>
    </tr>
    <tr><td></td></tr>
    <% for (CarsAds carsAd : listAds) { %>
    <%--<c:forEach items="<%=listAds%>" var="carAd">--%>
        <tr>
            <%--<form action="${pageContext.servletContext.contextPath}/createedit02" method='post'>--%>
            <form action="${pageContext.servletContext.contextPath}/carAd_JSTL.jsp?adId=<%=carsAd.getId() %>" method='get'>
               <input type="hidden" value="<%=carsAd.getId() %>" name="adId">
               <td><%=carsAd.getId() %></td>
               <td><%=carsAd.getCarsBrand().getName() %></td>
               <td><%=carsAd.getCarsModel().getName() %></td>
               <td><%=carsAd.getCarsBodyType().getName() %></td>
               <td><%=carsAd.getCarsTransmission().getName() %></td>
               <td><%=carsAd.getCarsEngineType().getName() %></td>
               <td><%=carsAd.getCarsDriveUnit().getName() %></td>
               <td>
                     <% for (CarsAdsHeatingDetails heatingDetails : allCarsAds.getAllHeatingDetails(carsAd.getId())) { %>
                        <%=heatingDetails.getCarsHeating().getName() %> <br>
                     <% } %>
               </td>
               <td><%=carsAd.getUserId() %></td>
               <td><%=carsAd.getMileage() %></td>
               <td><%=carsAd.getDescription() %></td>
               <td><img src="${pageContext.servletContext.contextPath}/images/cars/<%=carsAd.getPhotoId() %>.jpg" alt="Smiley face" height="100"></td>
               <td><input type="submit" value="Details"></td>
            </form>
            <form action="${pageContext.servletContext.contextPath}/check/soldout02?adId=<%=carsAd.getId() %>&status=N&userid=<%=carsAd.getUserId() %>" method='post'>
               <input type="hidden" value="<%=carsAd.getId() %>" name="adId">
               <input type="hidden" value="<%=carsAd.getUserId() %>" name="userid">
               <input type="hidden" value="N" name="status">
               <td>
                  <input type="submit" value="Sold out"></td>
               </td>
            </form>
        </tr>
    <%--</c:forEach>--%>
    <% } %>

</table><br>

<% allCarsAds.closeSeesion(); %>


<form action="${pageContext.servletContext.contextPath}/check/createedit02" method='get'>
   <input type="submit" value="New Car"></td>
</form>


</body>
</html>
