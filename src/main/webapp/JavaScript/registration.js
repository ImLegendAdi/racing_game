function validateForm() {
    var playerName = document.getElementById("player_name").value;
    var score = document.getElementById("score").value;
    var level = document.getElementById("level").value;

    // Check if player name is empty
    if (playerName == "") {
        alert("Player name is required!");
        return false;
    }

    // Check if score is a positive number
    if (score == "" || score <= 0) {
        alert("Score must be a positive number!");
        return false;
    }

    // Check if level is a positive number
    if (level == "" || level <= 0) {
        alert("Level must be a positive number!");
        return false;
    }

    return true; // Allow form submission
}