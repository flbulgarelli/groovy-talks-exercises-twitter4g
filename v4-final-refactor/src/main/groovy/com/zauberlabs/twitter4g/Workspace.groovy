package com.zauberlabs.twitter4g

import java.util.Collection

import twitter4j.conf.ConfigurationBuilder

import com.zauberlabs.twitter4g.api.UserTimelineFactories


class Workspace {

  static void main(String[] args) {
    def texts = UserTimelineFactories //
        .sync(new ConfigurationBuilder() //
          .setOAuthConsumerKey(System.getenv("consumerKey")) //
          .setOAuthConsumerSecret(System.getenv("consumerSecret")) //
          .setOAuthAccessToken("50074149-oj1cTPiL9eZDJTmEt9r1ppw4iWNZffRcvM0NWbIWQ") //
          .setOAuthAccessTokenSecret("u47IVnL3sdt3CAVoNKafLDUFfQiK0tOx1zOUinrJ0") //
        .build()) //
        .timeline('zaubertest') //
        .withStatusTextsWithHashtagDo("programming") { 
          println it 
        }
  }

}
