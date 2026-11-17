package main.player.application.ports;

import com.kosprov.jargon2.api.Jargon2.Hasher;
import com.kosprov.jargon2.api.Jargon2.Verifier;

public interface PasswordHasher{
    public String hash(String input);
    public boolean check(String encodedPassword, String input);
}