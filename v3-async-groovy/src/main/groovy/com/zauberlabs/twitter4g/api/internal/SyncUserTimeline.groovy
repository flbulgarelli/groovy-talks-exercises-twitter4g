package com.zauberlabs.twitter4g.api.internal

import groovy.lang.Closure;
import twitter4j.Status;
import twitter4j.Twitter;

import com.zauberlabs.twitter4g.api.UserTimeline;

class SyncUserTimeline implements UserTimeline {

  final Twitter twitter
  final String screenName

  SyncUserTimeline(Twitter twitter, String screenName) {
    assert twitter != null, "Twitter client must be non null"
    assert screenName != null && !screenName.empty, "screenName must ne non empty"
    this.twitter = twitter
    this.screenName = screenName
  }

  def withStatusTextsWithHashtagDo(String hashtag, Closure<String> closure) {
    withStatusTextsDo( { Status it -> hashtag in it.hashtagEntities*.text }, closure)
  }

  def withStatusTextsDo(Closure<Status> predicate, Closure<String> closure) {
    twitter.userTimeline.findAll(predicate).collect { Status it -> it.text }.each(closure)
  }

  String getScreenName() {
    twitter.screenName
  }
}
