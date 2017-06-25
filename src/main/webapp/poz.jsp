<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.WeatherGetter,domain.WeatherEntry" %>
<!doctype html>
<html>
<head>
<title>Pogodynka</title>
</head>
<body>
	
		<%! private WeatherGetter weatherGetter = new WeatherGetter(); %>
		<%! private WeatherEntry gdansk = weatherGetter.getWeather("Poznan"); %>
		<h1>Pogodynka</h1>
		<div style="background-color:#8888ff;border:1px solid black;padding:10px">
		<img src="http://openweathermap.org/img/w/<%=gdansk.getWeather().get(0).getIcon()%>.png" style="float:right">
			<h2>Pogoda w Poznaniu</h2>
			<ul>
				<li><b>Poziom zachmurzenia:</b> <%=gdansk.getClouds().getAll()%>%</li>
				<li><b>Temperatura:</b> <%=gdansk.getMain().getTemp()%>&deg;C</li>
				<li><b>Ciśnienie:</b> <%=gdansk.getMain().getPressure()%> hPa</li>
				<li><b>Prędkość wiatru:</b> <%=gdansk.getWind().getSpeed()%> m/s</li>
			</ul>
		</div>
		
		<b>Sprawdź też inne miasta:</b>
		<ul>
			<li><a href="/zadanie8/gda.jsp">Gdańsk</a></li>
			<li><a href="/zadanie8/war.jsp">Warszawa</a></li>
			<li><a href="/zadanie8/kra.jsp">Kraków</a></li>
			<li><a href="/zadanie8/wro.jsp">Wrocław</a></li>
			<li><a href="/zadanie8/poz.jsp">Poznań</a></li>
			<li><a href="/zadanie8/lod.jsp">Łódź</a></li>
			<li><a href="/zadanie8/kat.jsp">Katowice</a></li>
		</ul>
	
</body>
</html>