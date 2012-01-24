package com.zauberlabs.twitter4g.api.internal

import java.util.Collection
import java.util.List

import twitter4j.Status
import twitter4j.Twitter

import com.zauberlabs.twitter4g.api.UserTimeline

class DefaultUserTimeline implements UserTimeline {

  final Twitter twitter
  final String screenName

  DefaultUserTimeline(Twitter twitter, String screenName) {
    assert twitter != null, "Twitter client must be non null"
    assert screenName != null && !screenName.empty, "screenName must ne non empty"
    this.twitter = twitter
    this.screenName = screenName
  }

  Collection<String> getStatusTextsWithHashtag(String hashtag) {
    getStatusTexts { Status it -> hashtag in it.hashtagEntities*.text }
  }

  Collection<String> getStatusTexts(Closure<Status> predicate) {
    twitter.getUserTimeline(screenName).findAll(predicate).collect { Status it -> it.text }
  }

  String getScreenName() {
    twitter.screenName
  }
}
