package org.rest.client.demo.clients;

import static io.quarkus.arc.ComponentsProvider.LOG;

import io.quarkus.rest.client.reactive.Url;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.logging.Logger;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rest.client.demo.dtos.AssetData;
import org.rest.client.demo.dtos.AssetHistoryData;

@RegisterRestClient(configKey = "crypto-currency")
public interface CryptoCurrencyRestClient {

  @GET
  @Path("/assets")
  @Retry(maxRetries = 2)
  AssetData getAssets();

  @GET
  @Path("/assets/{id}/history")
  @Retry(maxRetries = 5, retryOn = IOException.class, abortOn = SyncFailedException.class)
  AssetHistoryData getAssetHistory(@PathParam("id") String id,
      @QueryParam("interval") String interval);
}
