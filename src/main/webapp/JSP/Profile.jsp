<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Player Profile</title>
</head>
<body>
    <h1>Player Profile</h1>
    <p><b>Player ID:</b> ${player.player_id}</p>  <%-- EL in JSP Pages --%> 
    <p><b>Name:</b> ${player.player_name}</p>
    <p><b>Score:</b> ${player.score}</p>
    <p><b>Level:</b> ${player.level}</p>
</body>
</html>