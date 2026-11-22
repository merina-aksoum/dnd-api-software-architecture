package Lobby.config;

import Lobby.LobbyInstaller;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public final class ApplicationContext {

    private ApplicationContext() {}

    public static ResourceConfig createResourceConfig() {
        ResourceConfig resourceConfig =
                new ResourceConfig().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        LobbyInstaller lobbyInstaller = new LobbyInstaller();
        lobbyInstaller.install(resourceConfig);

        return resourceConfig;
    }
}
