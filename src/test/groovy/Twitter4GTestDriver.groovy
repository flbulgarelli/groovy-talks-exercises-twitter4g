import static org.junit.Assert.*

import org.junit.Test

import com.zauberlabs.twitter4g.api.UserTimelineFactories;
import com.zauberlabs.twitter4g.api.UserTimelineFactory;
import com.zauberlabs.twitter4g.api.internal.DefaultUserTimelineFactory;

class Twitter4GTestDriver  {

  @Test void v1() throws Exception {
    UserTimelineFactories
        .newFactory()
        .timeline()
        .each { print it.text }
  }
}

//private TwitterStream newStream() {
//  ConfigurationBuilder cb = new ConfigurationBuilder()
//          .setUseSSL(useSSL)
//          .setOAuthConsumerKey(consumerKey)
//          .setOAuthConsumerSecret(consumerSecret)
//          .setStreamBaseURL(STREAM_BASE_URL)
//          .setSiteStreamBaseURL(SITE_STREAM_BASE_URL)
//          .setHttpProxyHost(proxyHost)
//          .setHttpProxyPort(proxyPort)
//          .setHttpProxyUser(proxyUsername)
//          .setHttpProxyPassword(proxyPassword);
//
//  if (accessKey != null) {
//      cb.setOAuthAccessToken(accessKey).setOAuthAccessTokenSecret(accessSecret);
//  }
//
//  HttpClientHiddenConstructionArgument.setUseMule(false);
//  return new TwitterStreamFactory(cb.build()).getInstance();
//}
