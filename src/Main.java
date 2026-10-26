import java.net.URI;

import config.ApplicationContext;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;


public class Main {
    private static final String DEFAULT_PORT = "8080";

    public static void main(String[] args) {
        URI baseUri = URI.create("http://0.0.0.0:" + port() + "/");
        GrizzlyHttpServerFactory.createHttpServer(baseUri, ApplicationContext.createResourceConfig());
        System.out.printf("dnd-api started at %s%n", baseUri);
    }

    private static String port() {
        String port = System.getenv("PORT");
        return port == null || port.isBlank() ? DEFAULT_PORT : port;
    }
}
