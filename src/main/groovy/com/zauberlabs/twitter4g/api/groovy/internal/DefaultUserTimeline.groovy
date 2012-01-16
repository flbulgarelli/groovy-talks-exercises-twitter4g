package com.zauberlabs.twitter4g.api.groovy.internal

import java.util.ArrayList
import java.util.Arrays
import java.util.Collection
import java.util.List

import org.apache.commons.lang.UnhandledException
import org.apache.commons.lang.Validate

import com.zauberlabs.twitter4g.api.UserTimeline

import twitter4j.Status
import twitter4j.Twitter
import twitter4j.TwitterException

class DefaultUserTimeline implements UserTimeline {

  final Twitter twitter

  DefaultUserTimeline(Twitter twitter) {
    assert twitter != null, "Twitter client must be non null"
    this.twitter = twitter
  }

  Collection<String> getStatusTextsWithHashtag(String hashtag) {
    List<String> filteredTimeline = []
    for (Status status : twitter.userTimeline) {
      if (hashtag in status.hashtagEntities) {
        filteredTimeline << status.text
      }
    }
    filteredTimeline
  }

  String getScreenName() {
    twitter.screenName
  }
}
