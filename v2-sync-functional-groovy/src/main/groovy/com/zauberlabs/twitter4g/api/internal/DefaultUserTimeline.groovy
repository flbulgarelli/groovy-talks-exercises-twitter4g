package com.zauberlabs.twitter4g.api.internal

import java.util.Collection
import java.util.List

import twitter4j.Status
import twitter4j.Twitter

import com.zauberlabs.twitter4g.api.UserTimeline

class DefaultUserTimeline implements UserTimeline {

  final Twitter twitter
  final String userName

  DefaultUserTimeline(Twitter twitter, String username) {
    assert twitter != null, "Twitter client must be non null"
    assert username != null && !username.empty, "Username must ne non empty"
    this.twitter = twitter
    this.userName = username
  }

  Collection<String> getStatusTextsWithHashtag(String hashtag) {
    getStatusTexts { Status it -> hashtag in it.hashtagEntities*.text }
  }

  Collection<String> getStatusTexts(Closure<Status> predicate) {
    twitter.getUserTimeline(userName).findAll(predicate).collect { Status it -> it.text }
  }

  String getScreenName() {
    twitter.screenName
  }
}
