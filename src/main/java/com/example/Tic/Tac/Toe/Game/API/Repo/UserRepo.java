package com.example.Tic.Tac.Toe.Game.API.Repo;

import com.example.Tic.Tac.Toe.Game.API.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Player, Long> {
    Optional<Player> findByUsername(String username);
}
