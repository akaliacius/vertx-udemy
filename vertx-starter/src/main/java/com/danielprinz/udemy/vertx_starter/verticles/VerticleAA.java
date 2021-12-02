package com.danielprinz.udemy.vertx_starter.verticles;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleAA extends AbstractVerticle {

  private static final Logger LOG = LoggerFactory.getLogger(VerticleAA.class);

  @Override
  public Completable rxStart() {
    return Single.fromCallable(this::getClass)
      .map(Class::getName)
      .doOnSuccess(className -> LOG.debug("Start {}", className))
        .ignoreElement();
  }

  @Override
  public Completable rxStop() {
    LOG.debug("Stop {}", getClass().getName());
    return Completable.complete();
  }
}
