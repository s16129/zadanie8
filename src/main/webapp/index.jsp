<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.WeatherGetter,domain.WeatherEntry" %>
<!doctype html>
<html>
<head>
<title>Pogodynka</title>
</head>
<body>
	
		<%! private WeatherGetter weatherGetter = new WeatherGetter(); %>
		<%! private WeatherEntry gdansk = weatherGetter.getWeather("Gdansk"); %>
		<%! private WeatherEntry warszawa = weatherGetter.getWeather("Warsaw"); %>
		<%! private WeatherEntry krakow = weatherGetter.getWeather("Cracow"); %>
		<%! private WeatherEntry wroclaw = weatherGetter.getWeather("Wroclaw"); %>
		<%! private WeatherEntry poznan = weatherGetter.getWeather("Poznan"); %>
		<%! private WeatherEntry lodz = weatherGetter.getWeather("Lodz"); %>
		<%! private WeatherEntry katowice = weatherGetter.getWeather("Katowice"); %>
		
		<h1>Pogodynka</h1>
		<b>Sprawdź pogodę w swoim mieście:</b>
		<ul>
			<li><img src="http://openweathermap.org/img/w/<%=gdansk.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/gda.jsp">Gdańsk</a></li>
			<li><img src="http://openweathermap.org/img/w/<%=warszawa.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/war.jsp">Warszawa</a></li>
			<li><img src="http://openweathermap.org/img/w/<%=krakow.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/kra.jsp">Kraków</a></li>
			<li><img src="http://openweathermap.org/img/w/<%=wroclaw.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/wro.jsp">Wrocław</a></li>
			<li><img src="http://openweathermap.org/img/w/<%=poznan.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/poz.jsp">Poznań</a></li>
			<li><img src="http://openweathermap.org/img/w/<%=lodz.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/lod.jsp">Łódź</a></li>
			<li><img src="http://openweathermap.org/img/w/<%=katowice.getWeather().get(0).getIcon()%>.png" width="32" height="32"> <a href="/zadanie8/kat.jsp">Katowice</a></li>
		</ul>
	
</body>
</html>