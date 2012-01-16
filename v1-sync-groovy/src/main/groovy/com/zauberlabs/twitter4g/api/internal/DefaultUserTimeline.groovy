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