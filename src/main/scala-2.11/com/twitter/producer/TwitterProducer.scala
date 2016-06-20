package com.twitter.producer

import twitter4j._

class TwitterProducer {
  this: StringKafkaProducer =>

  def start() = {
    val twitterStream = new TwitterStreamFactory(TwitterProducerConfig.twitterStreamingConf).getInstance()
    val listener = new TwitterStreamListener(twitterStream) with StringKafkaProducer
    twitterStream.addListener(listener)

    val filterUsOnly = new FilterQuery().locations(Array(-122.75,36.8),Array(-121.75,37.8))
    twitterStream.filter(filterUsOnly)
    //twitterStream.sample()
  }
}
