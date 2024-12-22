<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Space Invaders</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="bootstrap.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <!-- Background Video -->
    <video autoplay muted loop id="background-video" aria-hidden="true">
        <source src="car.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>

    <!-- Main Content Container -->
    <div id="main-page" class="center-container">
        <h1 class="text-primary text-center">Nitro Racing</h1>
        <div class="text-center">
            <button id="start-game" class="btn btn-primary">Start Game</button>
            <button id="help" class="btn btn-secondary">Help</button>
        </div>
    </div>

    <div id="player-registration" class="center-container hidden">
        <h2>Enter Player Name</h2>
        <form action="RegisterPlayerServlet" method="POST">
            <input type="text" name="playerName" id="player-name" placeholder="Your Name" class="form-control w-50 mx-auto">
            <button type="submit" id="register-player" class="btn btn-success mt-3">Register</button>
            <button type="button" id="back-to-main" class="btn btn-warning mt-3">Back</button>
        </form>
    </div>

    <div id="returning-player" class="center-container hidden">
        <h2>Welcome Back!</h2>
        <div class="text-center">
            <button id="player-info" class="btn btn-info">Player Info</button>
            <button id="play-now" class="btn btn-success">Play Now</button>
        </div>
        <button id="back-to-main2" class="btn btn-warning mt-3">Back</button>
    </div>

    <div id="player-info-page" class="center-container hidden">
        <h2>Player Information</h2>
        <p><strong>Player Name:</strong> <span id="info-name"><%= request.getAttribute("playerName") %></span></p>
        <p><strong>Player ID:</strong> <span id="info-id"><%= request.getAttribute("playerId") %></span></p>
        <p><strong>Score:</strong> <span id="info-score"><%= request.getAttribute("playerScore") != null ? request.getAttribute("playerScore") : "0" %></span></p>
        <p><strong>Level:</strong> <span id="info-level"><%= request.getAttribute("playerLevel") != null ? request.getAttribute("playerLevel") : "1" %></span></p>
        <button id="back-to-main3" class="btn btn-warning">Back</button>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+pasUiw5yYdYy9STmUh0f38YTkwK3" crossorigin="anonymous"></script>
    <!-- Custom JS -->
    <script src="interaction.js"></script>
</body>
</html>
