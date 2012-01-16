package com.zauberlabs.twitter4g.api.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.UnhandledException;
import org.apache.commons.lang.Validate;

import com.zauberlabs.twitter4g.api.UserTimeline;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class DefaultUserTimeline implements UserTimeline {

  private final Twitter twitter;

  public DefaultUserTimeline(Twitter twitter) {
    Validate.notNull(twitter, "Twitter client must be non null");
    this.twitter = twitter;
  }

  public Collection<String> getStatusTextsWithHashtag(String hashtag) {
    List<Status> userTimeline;
    try {
      userTimeline = twitter.getUserTimeline();
    } catch (TwitterException e) {
      throw new UnhandledException(e);
    }
    List<String> filteredTimeline = new ArrayList<String>();
    for (Status status : userTimeline) {
      if (Arrays.asList(status.getHashtagEntities()).contains(hashtag)) {
        filteredTimeline.add(status.getText());
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
