package com.example.Tic.Tac.Toe.Game.API.Service;

import com.example.Tic.Tac.Toe.Game.API.Models.Player;
import com.example.Tic.Tac.Toe.Game.API.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private UserRepo userRepo;

    public Optional<Player> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public void savePlayer(Player player) {
        userRepo.save(player);
    }
}
