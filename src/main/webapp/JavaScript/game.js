const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');
const startButton = document.getElementById('startButton');
const scoreDisplay = document.getElementById('scoreDisplay');

let player, bullets, enemies, score, gameInterval, enemyInterval;

// Initialize the game elements
function initializeGame() {
    player = {
        x: canvas.width / 2 - 25,
        y: canvas.height - 40,
        width: 50,
        height: 30,
        speed: 5
    };

    bullets = [];
    enemies = [];
    score = 0;
    updateScore();

    // Add enemies
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 3; j++) {
            enemies.push({
                x: 50 + i * 100,
                y: 50 + j * 50,
                width: 40,
                height: 30,
                speed: 1
            });
        }
    }

    gameInterval = setInterval(updateGame, 1000 / 60);
    enemyInterval = setInterval(moveEnemies, 1000 / 60);
}

// Update the game every frame
function updateGame() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Draw player
    ctx.fillStyle = 'green';
    ctx.fillRect(player.x, player.y, player.width, player.height);

    // Draw bullets
    ctx.fillStyle = 'red';
    for (let i = 0; i < bullets.length; i++) {
        let bullet = bullets[i];
        ctx.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        bullet.y -= 4;
        if (bullet.y < 0) {
            bullets.splice(i, 1); 
            i--;
        }
    }

    // Draw enemies
    ctx.fillStyle = 'blue';
    for (let i = 0; i < enemies.length; i++) {
        let enemy = enemies[i];
        ctx.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
    }

    // Check for collisions
    checkCollisions();
}

// Move enemies down
function moveEnemies() {
    for (let i = 0; i < enemies.length; i++) {
        let enemy = enemies[i];
        enemy.y += enemy.speed;
        if (enemy.y > canvas.height) {
            gameOver();
        }
    }
}

// Check if bullet hits any enemy
function checkCollisions() {
    for (let i = 0; i < bullets.length; i++) {
        let bullet = bullets[i];
        for (let j = 0; j < enemies.length; j++) {
            let enemy = enemies[j];
            if (bullet.x < enemy.x + enemy.width &&
                bullet.x + bullet.width > enemy.x &&
                bullet.y < enemy.y + enemy.height &&
                bullet.y + bullet.height > enemy.y) {
                // Collision detected
                enemies.splice(j, 1);
                bullets.splice(i, 1);
                score += 10;
                updateScore();
                i--;
                break;
            }
        }
    }
}

// Update the score display
function updateScore() {
    scoreDisplay.textContent = score{score};
}

// Handle key events for player movement and shooting
document.addEventListener('keydown', function (e) {
    if (e.key === 'ArrowLeft' && player.x > 0) {
        player.x -= player.speed;
    } else if (e.key === 'ArrowRight' && player.x + player.width < canvas.width) {
        player.x += player.speed;
    } else if (e.key === ' ' || e.key === 'Enter') {
        bullets.push({
            x: player.x + player.width / 2 - 2,
            y: player.y,
            width: 5,
            height: 10
        });
    }
});

// Start the game when the "Start Game" button is clicked
startButton.addEventListener('click', function () {
    initializeGame();
    startButton.style.display = 'none'; // Hide the start button after game starts
});

// End the game
function gameOver() {
    clearInterval(gameInterval);
    clearInterval(enemyInterval);
    alert("Game Over! Your score is: " + score);
    startButton.style.display = 'block'; // Show the start button again
}