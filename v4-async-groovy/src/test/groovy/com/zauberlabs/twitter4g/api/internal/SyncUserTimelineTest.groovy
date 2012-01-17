package com.zauberlabs.twitter4g.api.internal

import static org.junit.Assert.*

import org.junit.Test

import twitter4j.Status;
import twitter4j.Twitter;

import com.zauberlabs.twitter4g.api.internal.SyncUserTimeline


class SyncUserTimelineTest {

  @Test void testName() {
    def twitter = [screenName: 'zaubersoftware',
          userTimeline: [
            [getHashtagEntities: ['#tech', '#magic'], text: 'Nuevos desafios para 2012: apender groovy y hacer mucha magia'] as Status,
            [hashtagEntities: ['#zauber', '#magic'], text: 'Otro desafío: blah blah blah'] as Status,
            [hashtagEntities: ['#zauber', '#blah'], text: 'Otro desafío más: ....'] as Status
          ]]

    new SyncUserTimeline(twitter as Twitter).withStatusTextsWithHashtagDo('#magic') { println it }
  }
}
