package player.config;

import player.PlayerInstaller;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public final class ApplicationContext {

    private ApplicationContext() {
    }

    public static ResourceConfig createResourceConfig() {
        ResourceConfig resourceConfig = new ResourceConfig().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        PlayerInstaller playerInstaller = new PlayerInstaller();
        playerInstaller.install(resourceConfig);

        return resourceConfig;
    }
}