package com.zauberlabs.twitter4g.api.internal

import twitter4j.Status
import twitter4j.TwitterStream
import twitter4j.UserStreamAdapter

import com.zauberlabs.twitter4g.api.UserTimeline

class AsyncUserTimeline implements UserTimeline {

  final TwitterStream twitterStream

  AsyncUserTimeline(TwitterStream twitterStream) {
    assert twitterStream != null, "Twitter client must be non null"
    this.twitterStream = twitterStream
  }

  def withStatusTextsWithHashtagDo(String hashtag, Closure<String> clousure) {
    withStatusTextsDo { Status it -> it.hashtagEntities }
  }

  def withStatusTextsDo(Closure<Status> predicate, Closure<String> closure) {
    twitterStream.addListener(new UserStreamAdapter() {
          void onStatus(Status status) {
            if(predicate(status))
              closure(status.text);
            //closure(status); ??
          }
        })
  }

  String getScreenName() {
    twitterStream.screenName
  }
}
