package com.twitter.producer

import twitter4j._

class TwitterProducer {
  this: StringKafkaProducer =>

  def start() = {
    val twitterStream = new TwitterStreamFactory(TwitterProducerConfig.twitterStreamingConf).getInstance()
    val listener = new TwitterStreamListener(twitterStream) with StringKafkaProducer
    twitterStream.addListener(listener)

    val tweetFilterQuery = new FilterQuery()
    tweetFilterQuery.locations(Array(-180, -90),Array(180, 90)) //based on location
    val lang = tweetFilterQuery.language("en") //based on language
//    tweetFilterQuery.track("ps4")

    twitterStream.filter(lang)
    //twitterStream.sample()
  }
}
