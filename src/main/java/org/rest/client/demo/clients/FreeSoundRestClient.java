package org.rest.client.demo.clients;

import io.quarkus.rest.client.reactive.ClientRedirectHandler;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rest.client.demo.dtos.UserResponse;

@RegisterRestClient(configKey = "free-sound")
@ClientHeaderParam(name = "Authorization", value = "{getAuthorizationHeader}")
public interface FreeSoundRestClient {

  default String getAuthorizationHeader() {

    final Config config = ConfigProvider.getConfig();

    final String apiKey = config.getConfigValue("free.sound.api.key").getValue();

    return "Token " + apiKey;
  }

  @GET
  @Path("/users/{username}")
  UserResponse getUsers(@PathParam("username") String username);
}
