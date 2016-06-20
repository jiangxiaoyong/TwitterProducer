package com.twitter.producer

import kafka.producer.KeyedMessage
import twitter4j._

class TwitterStreamListener(twitterStream: TwitterStream) extends StatusListener  {
  this: StringKafkaProducer =>

  val LOG = Logger.getLogger(classOf[TwitterStreamListener])

  def onStallWarning(stallWarning: StallWarning): Unit = {}

  def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice): Unit = {}

  def onScrubGeo(l: Long, l1: Long): Unit = {}

  def onStatus(status: Status): Unit = {
    val msg = new KeyedMessage[String, String](TwitterProducerConfig.KAFKA_TOPIC, TwitterObjectFactory.getRawJSON(status.getText))

    println("getUser = " + status.getUser)
    println("getName = " + status.getUser.getName)
    println("getText = " + status.getText)
    println("----------------------------")
    producer.send(msg)
  }

  def onTrackLimitationNotice(i: Int): Unit = {}

  def onException(e: Exception): Unit = {
    LOG.info("Shutting down Twitter sample stream...")
    twitterStream.shutdown()
  }
}
