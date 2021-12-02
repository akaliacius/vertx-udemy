package com.danielprinz.udemy.vertx_starter.verticles;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleA extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleA.class);

  @Override
  public Completable rxStart() {
    LOG.debug("Start {}", getClass().getName());
    var v1 = vertx.rxDeployVerticle(new VerticleAA())
      .doOnSuccess(id -> LOG.debug("Deployed {}", VerticleAA.class.getName()))
      .doOnSuccess(id -> vertx.rxUndeploy(id).subscribe());

    var v2 = vertx.rxDeployVerticle(new VerticleAB())
      .doOnSuccess(id -> LOG.debug("Deployed {}", VerticleAB.class.getName()));
    return Single.merge(v1, v2).ignoreElements();
  }
}
