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
webapp/carAd_JSTL.jsp <br><br>
<% String error = request.getParameter("message"); %>
<c:if test="${error != ''}">
   <div style="background-color: red">
         ${error}
   </div><br><br>
</c:if>

<% String message = request.getParameter("message"); %>
<c:if test="${message != ''}">
   <h1>${message}</h1><br><br>
</c:if>


<c:set value="${AllCarsAds()}" var="allCarsAds" scope="request"/>
<c:set value="${param.adId}" var="adId" scope="session"/> <br><br>

   <c:if test="${adId != ''}">
      <c:set value="${allCarsAds.getCarAd(adId)}" var="carAd" scope="request"/>
      ID: ${carAd.id} <br>
      Brand: ${carAd.getCarsBrand().getName()}<br>
      Model: ${carAd.getCarsModel().getName()}<br>
      Body type: ${carAd.getCarsBodyType().getName()}<br>
      Transmission: ${carAd.getCarsTransmission().getName()}<br>
      Engine type: ${carAd.getCarsEngineType().getName()}<br>
      Drive unit: ${carAd.getCarsDriveUnit().getName()}<br><br>
      <c:set value="${allCarsAds.getAllHeatingDetails(adId)}" var="allHeatings" scope="request"/>

      Heating:
      <c:forEach items="${allCarsAds.getAllHeatingDetails(adId)}" var="heatingDetail">
         ${heatingDetail.getCarsHeating().getName()},
      </c:forEach> <br><br>

      User id: ${carAd.getUserId()}<br>
      Mileage: ${carAd.getMileage()}<br>
      Description: ${carAd.getDescription()}<br>
      Inserted Date: ${carAd.getInsertedDate()}<br>

      <c:forEach items="${carAd.getCarsPhotoslist()}" var="carsPhotos">
         <img src="${pageContext.servletContext.contextPath}/images/cars/${carsPhotos.getPhotoId()}.jpg" alt="Smiley face" height="400">
      </c:forEach> <br><br>


   </c:if> <br><br>

Все объявления:<br>
<form method="post" action="${pageContext.servletContext.contextPath}/carsAds.jsp">
   <input type="submit" value="All list">
</form>


   <h3>Car's pthoto upload:</h3>
   Select a photo to upload: <br><br>
   <form method="post" action="${pageContext.servletContext.contextPath}/check/uploadServlet02?adId=${carAd.id}&userid=${carAd.getUserId()}" enctype="multipart/form-data">
      <input type="hidden" name="userid" value="${carAd.getUserId()}">
      Select file to upload:
      <input type="file" name="uploadFile"><br/>
      <input type="submit" value="Upload">
   </form>


</body>
</html>
