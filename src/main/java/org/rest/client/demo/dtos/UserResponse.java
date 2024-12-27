package org.rest.client.demo.dtos;

import java.time.LocalDateTime;

public record UserResponse(String url,
                           String username,
                           String about,
                           String home_page,
                           Avatar avatar,
                           LocalDateTime date_joined,
                           int num_sounds,
                           String sounds,
                           int num_packs,
                           String packs,
                           int num_posts,
                           int num_comments) {

  public record Avatar(
      String small,
      String medium,
      String large
  ) {}
}
