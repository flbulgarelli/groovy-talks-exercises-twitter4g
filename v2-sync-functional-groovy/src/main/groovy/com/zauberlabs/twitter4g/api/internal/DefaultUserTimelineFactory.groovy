package com.zauberlabs.twitter4g.api.internal

import org.apache.commons.lang.Validate

import com.zauberlabs.twitter4g.api.UserTimeline
import com.zauberlabs.twitter4g.api.UserTimelineFactory;
import com.zauberlabs.twitter4g.api.internal.DefaultUserTimeline

import twitter4j.TwitterFactory
import twitter4j.conf.Configuration

public class DefaultUserTimelineFactory implements UserTimelineFactory {

  final Configuration configuration

  DefaultUserTimelineFactory(Configuration configuration) {
    assert configuration != null, "configuration must be non null"
    this.configuration = configuration
  }

   UserTimeline timeline(String screenName) {
    new DefaultUserTimeline(twitterFactory(), screenName)
  }
  
  TwitterFactory twitterFactory() { 
    new TwitterFactory(configuration).instance
  }


}
