package com.example.Tic.Tac.Toe.Game.API.Models;

import jakarta.persistence.*;

@Entity
public class Player {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column
        private String username;
        @Column
        private String passcode;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPasscode() {
            return passcode;
        }

        public void setPasscode(String passcode) {
            this.passcode = passcode;
        }


}
