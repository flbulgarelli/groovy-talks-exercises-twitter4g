package com.zauberlabs.twitter4g.api.internal

import org.apache.commons.lang.Validate

import com.zauberlabs.twitter4g.api.UserTimeline
import com.zauberlabs.twitter4g.api.UserTimelineFactories;
import com.zauberlabs.twitter4g.api.UserTimelineFactory;
import com.zauberlabs.twitter4g.api.internal.SyncUserTimeline

import twitter4j.TwitterFactory
import twitter4j.conf.Configuration

public class SyncUserTimelineFactory extends AbstractUserTimelineFactory {

  SyncUserTimelineFactory(Configuration configuration) {
    super(configuration);
  }

  UserTimeline newTimeline(Configuration configuration) {
    new SyncUserTimeline(new TwitterFactory(configuration).instance)
  }
}
