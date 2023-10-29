package com.example.Tic.Tac.Toe.Game.API.Models;

import jakarta.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private char currentPlayer;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private char[][] gameBoard;
}
