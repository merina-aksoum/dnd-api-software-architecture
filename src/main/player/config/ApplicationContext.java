package main.player.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import main.player.PlayerInstaller;

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