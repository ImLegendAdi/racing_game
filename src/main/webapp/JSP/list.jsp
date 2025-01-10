<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Player List</title>
</head>
<body>
    <h1>All Players</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Player ID</th>
                <th>Name</th>
                <th>Score</th>
                <th>Level</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="player" items="${players}"> <%-- JSTL: Iterating over the list of players --%>
                <tr>
                    <td>${player.player_id}</td>
                    <td>${player.player_name}</td>
                    <td>${player.score}</td>
                    <td>${player.level}</td>
                    <td><a href="profile?id=${player.player_id}">View</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>