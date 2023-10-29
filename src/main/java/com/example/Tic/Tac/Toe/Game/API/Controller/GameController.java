package com.example.Tic.Tac.Toe.Game.API.Controller;

import com.example.Tic.Tac.Toe.Game.API.Models.Game;
import com.example.Tic.Tac.Toe.Game.API.Models.Player;
import com.example.Tic.Tac.Toe.Game.API.Repo.GameRepository;
import com.example.Tic.Tac.Toe.Game.API.Service.GameService;
import com.example.Tic.Tac.Toe.Game.API.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

        @Autowired
        private GameService gameService;

        @Autowired
        private PlayerService playerService;

        @Autowired
        private GameRepository gameRepository;

        @PostMapping("/start")
        public ResponseEntity<String> startNewGame(@RequestParam String username) {
            Optional<Player> playerOptional = playerService.findByUsername(username);

            if (playerOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player not found");
            }

            Player player = playerOptional.get();
            Optional<Game> existingGame = gameService.findGameByPlayer(player);

            if (existingGame.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player already has an ongoing game");
            }

            gameService.startNewGame(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("New game started");
        }

        @PostMapping("/reset")
        public ResponseEntity<String> resetGame(@RequestParam Long gameId) {
            Optional<Game> gameOptional = gameRepository.findById(gameId);

            if (gameOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game not found");
            }

            Game game = gameOptional.get();
            gameService.resetGame(game);

        return ResponseEntity.status(HttpStatus.OK).body("Game reset successfully");

        }

        @PostMapping("/play")
        public ResponseEntity<String> playTurn(
                @RequestParam Long gameId,
                @RequestParam int row,
                @RequestParam int col
        ) {
            Optional<Game> gameOptional = gameRepository.findById(gameId);

            if (gameOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game not found");
            }

            Game game = gameOptional.get();
            gameService.makeMove(game, row, col);

            return ResponseEntity.status(HttpStatus.OK).body("Move made successfully");

        }
}
