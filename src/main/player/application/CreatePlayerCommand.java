package main.player.application;

public record CreatePlayerCommand(
                String username,
                String password,
                String email) {
}