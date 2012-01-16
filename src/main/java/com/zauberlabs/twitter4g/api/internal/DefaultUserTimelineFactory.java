package com.zauberlabs.twitter4g.api.internal;

import org.apache.commons.lang.Validate;

import com.zauberlabs.twitter4g.api.UserTimeline;
import com.zauberlabs.twitter4g.api.UserTimelineFactory;
import com.zauberlabs.twitter4g.api.groovy.internal.DefaultUserTimeline;

import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

public class DefaultUserTimelineFactory implements UserTimelineFactory {

  private final Configuration configuration;

  public DefaultUserTimelineFactory(Configuration configuration) {
    Validate.notNull(configuration, "configuration must ne non null");
    this.configuration = configuration;
  }

  public UserTimeline timeline() {
    return new DefaultUserTimeline(new TwitterFactory(configuration).getInstance());
  }

}
