package com.zauberlabs.twitter4g.api.internal

import groovy.transform.TupleConstructor
import twitter4j.TwitterBase
import twitter4j.TwitterStream

class AbstractUserTimeline {

  final twitter
  
  AbstractUserTimeline(twitter) {
    assert twitter != null
    this.twitter = twitter
  }

  String getScreenName() {
    twitter.screenName
  }
}
