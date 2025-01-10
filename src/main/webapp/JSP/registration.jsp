<html>
<head>
    <title>Player Registration</title>
</head>
<body>
    <h1>Register Player</h1>
    <form action="register" method="post">
        <label for="player_name">Player Name:</label>
        <input type="text" name="player_name" id="player_name" required><br>
        <label for="score">Score:</label>
        <input type="number" name="score" id="score" required><br>
        <label for="level">Level:</label>
        <input type="number" name="level" id="level" required><br>
        <button type="submit">Register</button>
    </form>
</body>
</html>