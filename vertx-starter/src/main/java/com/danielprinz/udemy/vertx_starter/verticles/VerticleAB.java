package com.danielprinz.udemy.vertx_starter.verticles;

import io.reactivex.rxjava3.core.Completable;
import io.vertx.rxjava3.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleAB extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleAB.class);

  @Override
  public Completable rxStart() {
    LOG.debug("Start {}", getClass().getName());
    return Completable.complete();
  }

  @Override
  public Completable rxStop() {
    LOG.debug("Stop {}", getClass().getName());
    return Completable.complete();
  }
}
