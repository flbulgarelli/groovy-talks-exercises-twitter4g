package com.zauberlabs.twitter4g.api.internal

import groovy.lang.Closure
import twitter4j.Status
import twitter4j.Twitter

class SyncUserTimeline extends AbstractUserTimeline {

  SyncUserTimeline(twitter, String screenName) {
    super(twitter, screenName);
  }

  def withStatusTextsDo(predicate, closure) {
    twitter.getUserTimeline(screenName).findAll(predicate).collect { it.text }.each(closure)
  }
}
