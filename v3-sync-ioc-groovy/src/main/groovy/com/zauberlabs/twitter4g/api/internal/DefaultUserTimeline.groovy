package com.zauberlabs.twitter4g.api.internal

import java.util.Collection
import java.util.List

import twitter4j.Status
import twitter4j.Twitter

import com.zauberlabs.twitter4g.api.UserTimeline

class DefaultUserTimeline implements UserTimeline {

  final Twitter twitter

  DefaultUserTimeline(Twitter twitter) {
    assert twitter != null, "Twitter client must be non null"
    this.twitter = twitter
  }

  void withStatusTextsWithHashtagDo(String hashtag, Closure<String> clousure) {
    withStatusTextsDo { Status it -> it.hashtagEntities }
  }

  void withStatusTextsDo(Closure<Status> predicate, Closure<String> closure) {
    twitter.userTimeline.findAll(predicate).collect { Status it -> it.text }.each(closure)
  }

  String getScreenName() {
    twitter.screenName
  }
}
