package com.example.Tic.Tac.Toe.Game.API.Service;

import com.example.Tic.Tac.Toe.Game.API.Models.Game;
import com.example.Tic.Tac.Toe.Game.API.Models.Player;
import com.example.Tic.Tac.Toe.Game.API.Repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Optional<Game> findGameByPlayer(Player player) {
        return gameRepository.findByPlayer(player);
    }

    public void startNewGame(Player player) {
        Game game = new Game();
        game.setPlayer(player);
        game.setCurrentPlayer('X');
        gameRepository.save(game);
    }

    public void resetGame(Game game) {
        gameRepository.save(game);
    }

    public void makeMove(Game game, int row, int col) {
        gameRepository.save(game);
    }


}
