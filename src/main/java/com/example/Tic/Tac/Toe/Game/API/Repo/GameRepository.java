package com.example.Tic.Tac.Toe.Game.API.Repo;

import com.example.Tic.Tac.Toe.Game.API.Models.Game;
import com.example.Tic.Tac.Toe.Game.API.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByPlayer(Player player);
}
