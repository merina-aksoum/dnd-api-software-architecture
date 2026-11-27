package player.infra;

import player.application.ports.PasswordHasher;

import static com.kosprov.jargon2.api.Jargon2.*;

public class Jargon2PasswordHash implements PasswordHasher {
    private final Hasher hasher = jargon2Hasher()
            .type(Type.ARGON2id)
            .saltLength(16)
            .hashLength(128);
    private final Verifier verifier = jargon2Verifier();

    @Override
    public String hash(String input) {
        String result;
        try (ByteArray passwordByteArray = toByteArray(input.toCharArray()).clearSource()) {
            result = hasher.password(passwordByteArray).encodedHash();
        } catch (Exception e) {
            result = "";
        }

        return result;
    }

    @Override
    public boolean check(String encodedPassword, String input) {
        try (ByteArray passwordByteArray = toByteArray(input.toCharArray()).clearSource()) {
            return verifier.hash(encodedPassword).password(passwordByteArray).verifyEncoded();
        } catch (Exception e) {
            return false;
        }
    }
}