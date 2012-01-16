package com.zauberlabs.twitter4g.api;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

import com.zauberlabs.twitter4g.api.groovy.internal.DefaultUserTimelineFactory;

public class UserTimelineFactories {

  public static UserTimelineFactory newFactory(Configuration configuration) {
    return new DefaultUserTimelineFactory(configuration);
  }

  public static UserTimelineFactory newFactory() {
    return newFactory(ConfigurationContext.getInstance());
  }
}
