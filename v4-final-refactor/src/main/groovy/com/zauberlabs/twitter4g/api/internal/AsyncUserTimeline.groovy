package com.zauberlabs.twitter4g.api.internal

import groovy.lang.Closure;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterStream;
import twitter4j.UserStreamAdapter;

import com.zauberlabs.twitter4g.api.UserTimeline;

class AsyncUserTimeline extends  AbstractUserTimeline {

  AsyncUserTimeline(twitter, String screenName) {
    super(twitter, screenName);
  }

  def withStatusTextsDo(predicate, closure) {
    twitterStream.addListener(new UserStreamAdapter() { //TODO filter by user
          void onStatus(Status status) {
            if(predicate(status))
              closure(status.text);
            //closure(status); ??
          }
        })
  }

}
