package com.zauberlabs.twitter4g.api.internal;

class UserTimelineFactory {

  final configuration
  final userTimelineClass
  final twitterFactoryClass
  
  public UserTimelineFactory(configuration, userTimelineClass, twitterFactoryClass) {
    assert configuration != null
    assert userTimelineClass != null
    assert twitterFactoryClass != null
    
    this.configuration = configuration;
    this.userTimelineClass = userTimelineClass;
    this.twitterFactoryClass = twitterFactoryClass;
  }

  def timeline() {
    userTimelineClass.newInstance(twitterFactoryClass.newInstance(configuration).instance)
  }
}
