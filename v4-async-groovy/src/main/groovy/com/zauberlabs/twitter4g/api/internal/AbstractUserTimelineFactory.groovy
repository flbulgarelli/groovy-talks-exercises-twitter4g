package com.zauberlabs.twitter4g.api.internal;

import twitter4j.conf.Configuration;

import com.sun.org.apache.xalan.internal.lib.ObjectFactory.ConfigurationError;
import com.zauberlabs.twitter4g.api.UserTimeline;

abstract class AbstractUserTimelineFactory {

  final Configuration configuration

  AbstractUserTimelineFactory(Configuration configuration) {
    assert configuration != null, "configuration must be non null"
    this.configuration = configuration
  }

  UserTimeline timeline() {
    newTimeline(configuration);
  }

  abstract UserTimeline newTimeline(Configuration configuration) ;
}
