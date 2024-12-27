package org.rest.client.demo.dtos;

import java.util.List;

public record AssetData(List<Crypto> data) {
  public record Crypto(String id,
                       String rank,
                       String symbol,
                       String name,
                       String supply,
                       String maxSupply,
                       String marketCapUsd,
                       String volumeUsd24Hr,
                       String priceUsd,
                       String changePercent24Hr,
                       String vwap24Hr,
                       String explorer) {

  }
}