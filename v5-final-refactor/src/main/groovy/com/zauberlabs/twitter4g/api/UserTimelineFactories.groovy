package com.zauberlabs.twitter4g.api

import twitter4j.TwitterFactory
import twitter4j.TwitterStreamFactory
import twitter4j.conf.ConfigurationContext

import com.zauberlabs.twitter4g.api.internal.AsyncUserTimeline
import com.zauberlabs.twitter4g.api.internal.SyncUserTimeline
import com.zauberlabs.twitter4g.api.internal.UserTimelineFactory

class UserTimelineFactories {

  static UserTimelineFactory sync(configuration = ConfigurationContext.getInstance()) {
    new UserTimelineFactory(configuration, SyncUserTimeline, TwitterFactory)
  }

  static UserTimelineFactory async(configuration = ConfigurationContext.getInstance()) {
    new UserTimelineFactory(configuration, AsyncUserTimeline, TwitterStreamFactory)
  }
}
