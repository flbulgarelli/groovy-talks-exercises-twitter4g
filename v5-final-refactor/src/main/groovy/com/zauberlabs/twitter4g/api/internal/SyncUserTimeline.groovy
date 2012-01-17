package com.zauberlabs.twitter4g.api.internal

import groovy.transform.TupleConstructor;
import twitter4j.Status
import twitter4j.Twitter

class SyncUserTimeline extends AbstractUserTimeline {

  SyncUserTimeline(twitter) {
    super(twitter);
  }

  def withStatusTextsWithHashtagDo(hashtag, closure) {
    withStatusTextsDo({ hashtag in it.hashtagEntities  }, closure)  
  }

  def withStatusTextsDo(predicate, closure) {
    twitter.userTimeline.findAll(predicate).collect { it.text }.each(closure)
  }
}
