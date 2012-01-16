import groovy.lang.Closure;

import java.util.Collection;

import twitter4j.Status;

interface GTimeline {

  Collection<String> findAllWithHashtag(String hashtag);

  Collection<String> findAll(Closure<Status> predicate);

  void each(Closure<Status> closure);

  void eachText(Closure<String> closure);

}