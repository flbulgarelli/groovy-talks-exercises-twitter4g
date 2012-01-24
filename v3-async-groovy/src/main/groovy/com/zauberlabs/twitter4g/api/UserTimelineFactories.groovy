package com.zauberlabs.twitter4g.api

import twitter4j.conf.Configuration
import twitter4j.conf.ConfigurationContext

import com.zauberlabs.twitter4g.api.internal.AsyncUserTimelineFactory
import com.zauberlabs.twitter4g.api.internal.SyncUserTimelineFactory


class UserTimelineFactories {
  
  // Queda de tarea y para pensar para la segunda clase: eliminar la lógica repetida
  
  static UserTimelineFactory sync(Configuration configuration = ConfigurationContext.getInstance()) {
    new SyncUserTimelineFactory(configuration)
  }

  static UserTimelineFactory async(Configuration configuration = ConfigurationContext.getInstance()) {
    new AsyncUserTimelineFactory(configuration)
  }
}
