package com.zauberlabs.twitter4g.api.groovy

import java.util.Collection;

public interface UserTimeline {

  String getScreenName();

  Collection<String> getStatusTextsWithHashtag(String hashtag);

}