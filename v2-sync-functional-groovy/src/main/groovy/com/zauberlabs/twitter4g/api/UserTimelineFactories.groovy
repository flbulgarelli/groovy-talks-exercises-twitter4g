package com.zauberlabs.twitter4g.api

import twitter4j.conf.Configuration
import twitter4j.conf.ConfigurationContext

import com.zauberlabs.twitter4g.api.internal.DefaultUserTimelineFactory

class UserTimelineFactories {
  static UserTimelineFactory newFactory(Configuration configuration = ConfigurationContext.getInstance()) {
    new DefaultUserTimelineFactory(configuration)
  }
}
