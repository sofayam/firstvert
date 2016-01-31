package io.first;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import java.util.Map;

public class MyFirstVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> fut) {
    int port = 8080;
    String portString = System.getenv("PORT");
    if (portString != null) {
      port = Integer.parseInt(portString) ;
    }
    vertx
        .createHttpServer()
        .requestHandler(r -> {
          r.response().end("<h1>Hello from my first " +
              "Vert.x 3 application</h1>");
        })
        .listen(port, result -> {
          if (result.succeeded()) {
            fut.complete();
          } else {
            fut.fail(result.cause());
          }
        });
  }
}
