package com.example.Tic.Tac.Toe.Game.API.Controller;

import com.example.Tic.Tac.Toe.Game.API.Models.Player;
import com.example.Tic.Tac.Toe.Game.API.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

        @Autowired
        private UserRepo userRepo;
        @GetMapping(value = "/")
        public String getPage(){
            return "Welcome";
        }

        @GetMapping(value = "/players")
        public List<Player> getPlayers() {
            return userRepo.findAll();
        }

        @PostMapping(value = "/save")
        public ResponseEntity<String> savePlayer(@RequestBody Player player){
            Optional<Player> existingPlayer = userRepo.findByUsername(player.getUsername());

            if (existingPlayer.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }
            userRepo.save(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player registered successfully");

        }

        @PutMapping(value = "/update/{id}")
        public String updatePlayer(@PathVariable long id, @RequestBody Player player){
            Player updatedPlayer = userRepo.findById(id).get();
            updatedPlayer.setUsername(player.getUsername());
            updatedPlayer.setPasscode(player.getPasscode());
            userRepo.save(updatedPlayer);
            return "Updated...";
        }

        @DeleteMapping(value = "/delete/{id}")
        public String deletePlayer(@PathVariable long id){
            Player deletePlayer = userRepo.findById(id).get();
            userRepo.delete(deletePlayer);
            return "Delete user with the id: "+id;
        }

}
