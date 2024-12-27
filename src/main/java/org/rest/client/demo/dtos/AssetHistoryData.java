package org.rest.client.demo.dtos;

import java.util.List;

public record AssetHistoryData(List<DataPoint> data) {
  public record DataPoint(
      String priceUsd,
      long time,
      String circulatingSupply,
      String date
  ) {}
}
