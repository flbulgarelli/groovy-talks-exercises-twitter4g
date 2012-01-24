package com.zauberlabs.twitter4g.api.internal;

import twitter4j.conf.Configuration;

import com.zauberlabs.twitter4g.api.UserTimeline;
import com.zauberlabs.twitter4g.api.UserTimelineFactory;

abstract class AbstractUserTimelineFactory implements UserTimelineFactory {

  final Configuration configuration

  AbstractUserTimelineFactory(Configuration configuration) {
    assert configuration != null, "configuration must be non null"
    this.configuration = configuration
  }

  UserTimeline timeline(String screenName) {
    newTimeline(configuration, screenName);
  }

  abstract UserTimeline newTimeline(Configuration configuration, String screenName) ;
}
