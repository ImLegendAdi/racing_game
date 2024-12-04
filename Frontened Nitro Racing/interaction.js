document.addEventListener("DOMContentLoaded", () => {
    const mainPage = document.getElementById("main-page");
    const playerRegistration = document.getElementById("player-registration");
    const returningPlayer = document.getElementById("returning-player");
    const playerInfoPage = document.getElementById("player-info-page");
  
    const startGameButton = document.getElementById("start-game");
    const helpButton = document.getElementById("help");
    const registerPlayerButton = document.getElementById("register-player");
    const playerInfoButton = document.getElementById("player-info");
    const playNowButton = document.getElementById("play-now");
    const backToMainRegistrationButton = document.getElementById("back-to-main");
    const backToMainReturningButton = document.getElementById("back-to-main2");
    const backToMainInfoButton = document.getElementById("back-to-main3");
  
    const playerNameInput = document.getElementById("player-name");
    const infoName = document.getElementById("info-name");
    const infoId = document.getElementById("info-id");
  
    let playerId = localStorage.getItem("playerId");
    let playerName = localStorage.getItem("playerName");
  
    const generatePlayerId = () => `Player-${Math.floor(Math.random() * 10000)}`;
  
    const showPage = (page) => {
        // Hide all pages first
        [mainPage, playerRegistration, returningPlayer, playerInfoPage].forEach(el => el.classList.add("hidden"));
        // Show the target page
        page.classList.remove("hidden");
    };
  
    startGameButton.addEventListener("click", () => {
        if (!playerId) {
            showPage(playerRegistration);
        } else {
            showPage(returningPlayer);
        }
    });
  
    registerPlayerButton.addEventListener("click", () => {
        const name = playerNameInput.value.trim();
        if (name) {
            playerId = generatePlayerId();
            playerName = name;
            localStorage.setItem("playerId", playerId);
            localStorage.setItem("playerName", playerName);
            
            // Update the player info on the page without an alert
            infoName.textContent = playerName;
            infoId.textContent = playerId;
            showPage(returningPlayer);
        } else {
            alert("Please enter a valid name.");
        }
    });
  
    playerInfoButton.addEventListener("click", () => {
        infoName.textContent = playerName;
        infoId.textContent = playerId;
        showPage(playerInfoPage);
    });
  
    playNowButton.addEventListener("click", () => {
        // Show game start in the main window
        gameStatus.textContent = "Game Started!";
        // Add logic to initiate the game here.
    });
  
    // Back button functionality for each page
    backToMainRegistrationButton.addEventListener("click", () => {
        showPage(mainPage);
    });
  
    backToMainReturningButton.addEventListener("click", () => {
        showPage(mainPage);
    });
  
    backToMainInfoButton.addEventListener("click", () => {
        showPage(returningPlayer);
    });
  });
  