package com.twitter.producer

import kafka.producer.{ProducerConfig, Producer}

trait StringKafkaProducer {
  val producer = new Producer[String, String](new ProducerConfig(TwitterProducerConfig.producerProps))
}
