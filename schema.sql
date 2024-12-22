create database racing_game;
use racing_game;

CREATE TABLE player (
    player_id INT PRIMARY KEY AUTO_INCREMENT,  -- Unique identifier for each player
    player_name VARCHAR(255) NOT NULL,          -- Player's name
    score INT NOT NULL,                        -- Player's score
    level INT NOT NULL                    -- The level the player reached
 
    ) ;