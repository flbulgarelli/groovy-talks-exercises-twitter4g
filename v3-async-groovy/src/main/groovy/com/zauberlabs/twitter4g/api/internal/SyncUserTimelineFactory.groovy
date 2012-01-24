package com.zauberlabs.twitter4g.api.internal

import twitter4j.TwitterFactory
import twitter4j.conf.Configuration

import com.zauberlabs.twitter4g.api.UserTimeline

public class SyncUserTimelineFactory extends AbstractUserTimelineFactory {

  SyncUserTimelineFactory(Configuration configuration) {
    super(configuration);
  }

  UserTimeline newTimeline(Configuration configuration, String screenName) {
    new SyncUserTimeline(twitterFactory(), screenName)
  }
  
  def twitterFactory() {
    new TwitterFactory(configuration).instance
  }
}
