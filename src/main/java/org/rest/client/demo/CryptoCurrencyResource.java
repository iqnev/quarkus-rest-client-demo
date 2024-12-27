package org.rest.client.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rest.client.demo.dtos.AssetData;
import org.rest.client.demo.clients.CryptoCurrencyRestClient;
import org.rest.client.demo.dtos.AssetHistoryData;

@Path("/crypto")
public class CryptoCurrencyResource {

  final CryptoCurrencyRestClient cryptoCurrencyRestClient;

  public CryptoCurrencyResource(@RestClient CryptoCurrencyRestClient cryptoCurrencyRestClient) {
    this.cryptoCurrencyRestClient = cryptoCurrencyRestClient;
  }

  @GET
  public AssetData getCurrency() {
    return cryptoCurrencyRestClient.getAssets();
  }

  @GET
  @Path("{id}/history")
  public AssetHistoryData getAssetHistory(@PathParam("id") String id, @QueryParam("interval") String interval) {
    return cryptoCurrencyRestClient.getAssetHistory(id, interval);
  }
}
