package com.zauberlabs.twitter4g.api;

import groovy.lang.Closure;

import java.util.Collection;

import twitter4j.Status;

interface UserTimeline {

  String getScreenName()

  def withStatusTextsWithHashtagDo(String hashtag, Closure<String> closure)

  def withStatusTextsDo(Closure<Status> predicate, Closure<String> closure)

}