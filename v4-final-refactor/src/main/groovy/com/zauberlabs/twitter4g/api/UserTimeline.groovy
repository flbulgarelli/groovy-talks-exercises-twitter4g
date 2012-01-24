package com.zauberlabs.twitter4g.api;

import groovy.lang.Closure;
import twitter4j.Status;

interface UserTimeline {

  String getScreenName()

  def withStatusTextsWithHashtagDo(String hashtag, closure)

  def withStatusTextsDo(predicate, closure)

}