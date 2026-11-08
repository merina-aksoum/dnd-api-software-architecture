package main.player.application;

public record CreatePlayerCommand(
                String id,
                String username,
                String password,
                String email) {
}