package com.zauberlabs.twitter4g.api.internal

import twitter4j.TwitterFactory
import twitter4j.conf.Configuration

import com.zauberlabs.twitter4g.api.UserTimeline
import com.zauberlabs.twitter4g.api.UserTimelineFactory

public class AsyncUserTimelineFactory extends AbstractUserTimelineFactory {

  AsyncUserTimelineFactory(Configuration configuration) {
    super(configuration);
  }

  UserTimeline newTimeline(Configuration configuration) {
    new AsyncUserTimeline(new TwitterFactory(configuration).instance)
  }
}
