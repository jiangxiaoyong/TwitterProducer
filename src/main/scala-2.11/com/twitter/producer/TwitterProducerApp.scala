package com.twitter.producer

object TwitterProducerApp {
  def main(args: Array[String]): Unit = {
    val twitterProducer = new TwitterProducer with StringKafkaProducer
    twitterProducer.start()
  }
}
