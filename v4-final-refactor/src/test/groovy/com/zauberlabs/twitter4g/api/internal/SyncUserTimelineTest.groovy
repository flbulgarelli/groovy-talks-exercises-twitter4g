package com.zauberlabs.twitter4g.api.internal

import static org.junit.Assert.*

import java.util.List

import org.junit.Test

import twitter4j.HashtagEntity
import twitter4j.ResponseList
import twitter4j.Status
import twitter4j.Twitter


class SyncUserTimelineTest {

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
    
    def results = [] 
    assert new SyncUserTimeline(twitterMock, 'zaubertest').withStatusTextsWithHashtagDo('#magic') {  results << it } == [
      'Nuevos desafios para 2012: apender groovy y hacer mucha magia',
      'Otro desafío: blah blah blah'
    ]
  }

  def twitter(screenName, userTimeline) {
    [ screenName: screenName ,  getUserTimeline: { userTimeline  } ] 
  }

  def status(text, hashtags ) {
    [ hashtagEntities: hashtags , text:  text  ]
  }

  def hashtag(text) {
    [ text: text  ] 
  }
}


