package com.zauberlabs.twitter4g.api.internal

import groovy.lang.Closure;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.UserStreamAdapter;

import com.zauberlabs.twitter4g.api.UserTimeline;

class AsyncUserTimeline implements UserTimeline {

  final TwitterStream twitterStream
  final String screenName

  AsyncUserTimeline(TwitterStream twitterStream, String screenName) {
    assert twitterStream != null, "Twitter client must be non null"
    assert screenName != null && !screenName.empty, "screenName must ne non empty"
    this.twitterStream = twitterStream
    this.screenName = screenName
  }

  def withStatusTextsWithHashtagDo(String hashtag, Closure<String> clousure) {
    withStatusTextsDo( { Status it -> hashtag in it.hashtagEntities*.text  }, clousure )
  }

  def withStatusTextsDo(Closure<Status> predicate, Closure<String> closure) {
    twitterStream.addListener(new UserStreamAdapter() { //TODO filter by user
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
