package com.danielprinz.udemy.vertx_starter.verticles;

import io.reactivex.rxjava3.core.Completable;
import io.vertx.rxjava3.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleN extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleN.class);

  @Override
  public Completable rxStart() {
    LOG.debug("Start {} with config {}", getClass().getName(), config().toString());
    return Completable.complete();
  }
}
