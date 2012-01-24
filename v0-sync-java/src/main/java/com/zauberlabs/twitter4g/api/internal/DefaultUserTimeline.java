package com.zauberlabs.twitter4g.api.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.zauberlabs.twitter4g.api.UserTimeline;

public class DefaultUserTimeline implements UserTimeline {

  private final Twitter twitter;
  private final String screenName;

  public DefaultUserTimeline(Twitter twitter, String screenName) {
    Validate.notNull(twitter, "Twitter client must be non null");
    Validate.notEmpty(screenName);
    this.twitter = twitter;
    this.screenName = screenName;
  }

  public Collection<String> getStatusTextsWithHashtag(String hashtag) {
    List<Status> userTimeline;
    try {
      userTimeline = twitter.getUserTimeline(screenName);
    } catch (TwitterException e) {
      throw new UnhandledException(e);
    }
    List<String> filteredTimeline = new ArrayList<String>();
    for (Status status : userTimeline) {
      for (HashtagEntity hashtagEntity : status.getHashtagEntities()) {
        if (hashtagEntity.getText().equals(hashtag)) {
          filteredTimeline.add(status.getText());
        }
      }
    }
    return filteredTimeline;
  }

  public String getScreenName() {
    try {
      return twitter.getScreenName();
    } catch (Exception e) {
      throw new UnhandledException(e);
    }
  }

}
