package main.player.application.ports;

public interface PasswordHasher{
    public String hash(String input);
    public boolean check(String encodedPassword, String input);
}