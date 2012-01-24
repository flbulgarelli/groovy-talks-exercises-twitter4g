package com.zauberlabs.twitter4g.api.internal;

import org.apache.commons.lang.Validate;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

import com.zauberlabs.twitter4g.api.UserTimeline;
import com.zauberlabs.twitter4g.api.UserTimelineFactory;

public class DefaultUserTimelineFactory implements UserTimelineFactory {

  private final Configuration configuration;

  public DefaultUserTimelineFactory(Configuration configuration) {
    Validate.notNull(configuration, "configuration must ne non null");
    this.configuration = configuration;
  }

  public UserTimeline timeline(String username) {
    return new DefaultUserTimeline(twitterFactory(), username);
  }

  protected Twitter twitterFactory() {
    return new TwitterFactory(configuration).getInstance();
  }

}
