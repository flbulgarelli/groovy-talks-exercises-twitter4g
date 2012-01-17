package com.zauberlabs.twitter4g.api.internal

import groovy.transform.TupleConstructor
import twitter4j.Status
import twitter4j.UserStreamAdapter
import twitter4j.UserStreamListener;


class AsyncUserTimeline extends AbstractUserTimeline {
  
  AsyncUserTimeline(twitter) {
    super(twitter);
  }

  void withStatusTextsWithHashtagDo(hashtag, clousure) {
    withStatusTextsDo { it.hashtagEntities }
  }

  void withStatusTextsDo(predicate, closure) {
    twitter.addListener([onStatus: {
        if(predicate(it))
          closure(it.text)
      }] as UserStreamListener)
  }
}
