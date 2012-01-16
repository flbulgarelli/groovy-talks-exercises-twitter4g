package com.zauberlabs.twitter4g.api;

import groovy.lang.Closure;

import java.util.Collection;

import twitter4j.Status;

public interface UserTimeline {

  String getScreenName();

  Collection<String> getStatusTextsWithHashtag(String hashtag);

  Collection<String> getStatusTexts(Closure<Status> predicate);

}