package com.zauberlabs.twitter4g.api.internal

import static org.junit.Assert.*

import org.junit.Test

import com.zauberlabs.twitter4g.api.internal.SyncUserTimeline


class SyncUserTimelineTest {

  @Test void testName() {
    def twitter = [screenName: 'zaubersoftware',
          userTimeline: [
            [hashtagEntities: ['#tech', '#magic'], text: 'Nuevos desafios para 2012: apender groovy y hacer mucha magia'],
            [hashtagEntities: ['#zauber', '#magic'], text: 'Otro desafío: blah blah blah'],
            [hashtagEntities: ['#zauber', '#blah'], text: 'Otro desafío más: ....']
          ]]

    new SyncUserTimeline(twitter).withStatusTextsWithHashtagDo('#magic') { println it }
  }
}
