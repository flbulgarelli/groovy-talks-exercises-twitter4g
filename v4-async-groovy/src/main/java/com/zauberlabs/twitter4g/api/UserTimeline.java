package com.zauberlabs.twitter4g.api;

import groovy.lang.Closure;

import java.util.Collection;

import twitter4j.Status;

public interface UserTimeline {

  String getScreenName();

  void withStatusTextsWithHashtagDo(String hashtag, Closure<String> closure);

  void withStatusTextsDo(Closure<Status> predicate, Closure<String> closure);

}