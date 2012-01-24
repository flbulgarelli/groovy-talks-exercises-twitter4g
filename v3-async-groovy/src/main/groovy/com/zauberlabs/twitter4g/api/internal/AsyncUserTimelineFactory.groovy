package com.zauberlabs.twitter4g.api.internal

import twitter4j.TwitterStreamFactory
import twitter4j.conf.Configuration

import com.zauberlabs.twitter4g.api.UserTimeline

public class AsyncUserTimelineFactory  extends AbstractUserTimelineFactory {

  AsyncUserTimelineFactory(Configuration configuration) {
    super(configuration);
  }

  UserTimeline newTimeline(Configuration configuration, String screenName) {
    new AsyncUserTimeline(twitterFactory(), screenName)
  }
  
  def twitterFactory() { 
    new TwitterStreamFactory(configuration).instance
  }
}
