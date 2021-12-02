package com.danielprinz.udemy.vertx_starter.verticles;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava3.core.AbstractVerticle;
import io.vertx.rxjava3.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class MainVerticle extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.rxDeployVerticle(new MainVerticle())
      .subscribe();
  }

  @Override
  public Completable rxStart() {
    LOG.debug("Start {}", getClass().getName());
    var v1 = vertx.rxDeployVerticle(new VerticleA());
    var v2 = vertx.rxDeployVerticle(new VerticleB());
    var v3 = vertx.rxDeployVerticle(VerticleN.class.getName(),
      new DeploymentOptions()
        .setInstances(4)
        .setConfig(new JsonObject()
          .put("id", UUID.randomUUID().toString())
          .put("name", VerticleN.class.getSimpleName())
        )
    );
    return Single.merge(v1, v2, v3)
      .ignoreElements();
  }
}
