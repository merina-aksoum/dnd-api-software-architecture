package main.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class ApplicationContext {
    private ApplicationContext() {

    }

    public static ResourceConfig createResourceConfig() {
        ResourceConfig resourceConfig = new ResourceConfig().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        main.character.HeroInstaller heroInstaller = new main.character.HeroInstaller();
        heroInstaller.install(resourceConfig);


        return resourceConfig;
    }
}
