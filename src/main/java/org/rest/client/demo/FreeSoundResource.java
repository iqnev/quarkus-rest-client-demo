package org.rest.client.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rest.client.demo.clients.FreeSoundRestClient;
import org.rest.client.demo.dtos.UserResponse;

@Path("/free-sound")
public class FreeSoundResource {

  final FreeSoundRestClient freeSoundRestClient;

  public FreeSoundResource(@RestClient final  FreeSoundRestClient freeSoundRestClient) {
    this.freeSoundRestClient = freeSoundRestClient;
  }

  @GET
  @Path("/users/{username}")
  public UserResponse getUsers(@PathParam("username") String username) {
    return freeSoundRestClient.getUsers(username);
  }
}
