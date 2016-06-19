package com.twitter.producer

import twitter4j.TwitterStreamFactory

class TwitterProducer {
  this: StringKafkaProducer =>

  def start() = {
    val twitterStream = new TwitterStreamFactory(TwitterProducerConfig.twitterStreamingConf).getInstance()
    val listener = new TwitterStreamListener(twitterStream) with StringKafkaProducer
    twitterStream.addListener(listener)
    twitterStream.sample()
  }
}
