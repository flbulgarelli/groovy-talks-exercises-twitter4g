package com.zauberlabs.twitter4g;

import java.util.Collection;

import twitter4j.conf.ConfigurationBuilder;

import com.zauberlabs.twitter4g.api.UserTimelineFactories;

public class Workspace {

  public static void main(String[] args) {
    Collection<String> texts = UserTimelineFactories //
        .newFactory(new ConfigurationBuilder() //
            .setOAuthConsumerKey(System.getenv("consumerKey")) //
            .setOAuthConsumerSecret(System.getenv("consumerSecret")) //
            .setOAuthAccessToken("50074149-oj1cTPiL9eZDJTmEt9r1ppw4iWNZffRcvM0NWbIWQ") //
            .setOAuthAccessTokenSecret("u47IVnL3sdt3CAVoNKafLDUFfQiK0tOx1zOUinrJ0") //
            .build()) //
        .timeline("zaubertest") //
        .getStatusTextsWithHashtag("programming");

    for (String text : texts) {
      System.out.println(text);
    }
  }

}
