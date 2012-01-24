package com.zauberlabs.twitter4g.api.internal

import groovy.lang.Closure
import twitter4j.Status
import twitter4j.Twitter

import com.zauberlabs.twitter4g.api.UserTimeline

abstract class AbstractUserTimeline implements UserTimeline {

  final twitter
  final String screenName

  AbstractUserTimeline(twitter, String screenName) {
    assert twitter != null, "Twitter client must be non null"
    assert !screenName?.empty, "screenName must ne non empty"
    this.twitter = twitter
    this.screenName = screenName
  }
  
  def withStatusTextsWithHashtagDo(String hashtag, closure) {
    withStatusTextsDo( { hashtag in it.hashtagEntities*.text }, closure)
  }

}
