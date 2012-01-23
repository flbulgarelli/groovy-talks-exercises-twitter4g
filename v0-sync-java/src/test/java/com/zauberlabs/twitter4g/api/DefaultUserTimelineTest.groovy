package com.zauberlabs.twitter4g.api;


import java.util.List;

import org.junit.Test;

import twitter4j.HashtagEntity;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;

import com.zauberlabs.twitter4g.api.internal.DefaultUserTimeline;

public class DefaultUserTimelineTest {

  @Test public void testName() {
    def twitterMock = twitter('zaubersoftware',
        [
          status('Nuevos desafios para 2012: apender groovy y hacer mucha magia', [
            hashtag('#tech'),
            hashtag('#magic')]
          ),
          status('Otro desafío: blah blah blah', [
            hashtag('#zauber'),
            hashtag('#magic')]
          ),
          status('Otro desafío más: ....', [
            hashtag('#zauber'),
            hashtag('#blah')]
          )
        ])
    assert new DefaultUserTimeline(twitterMock).getStatusTextsWithHashtag('#magic') == [
      'Nuevos desafios para 2012: apender groovy y hacer mucha magia',
      'Otro desafío: blah blah blah'
    ]
  }

  Twitter twitter(String screenName, List<Status> userTimeline) {
    [ getScreenName: { screenName },  getUserTimeline: { userTimeline as ResponseList<Status> } ] as Twitter
  }

  Status status(String text, List<HashtagEntity> hashtags ) {
    [getHashtagEntities: { hashtags as HashtagEntity[] }, getText: { text } ] as Status
  }

  HashtagEntity hashtag(String text) {
    [getText: { text }  ] as HashtagEntity
  }
}
