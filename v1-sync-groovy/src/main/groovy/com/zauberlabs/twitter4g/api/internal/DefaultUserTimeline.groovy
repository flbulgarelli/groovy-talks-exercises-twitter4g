package com.zauberlabs.twitter4g.api.internal

import twitter4j.HashtagEntity
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
    List<String> filteredTimeline = []
    for (Status status : twitter.getUserTimeline(screenName)) {
      for (HashtagEntity hashtagEntity : status.hashtagEntities) {
        if (hashtag == hashtagEntity.text) {
          filteredTimeline << status.text
        }
      }
    }
    filteredTimeline
  }

  String getScreenName() {
    twitter.screenName
  }
}
