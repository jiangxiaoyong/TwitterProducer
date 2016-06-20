Docker instructions
============================
Zookeeper Docker
----------------------------
- docker run -it name  zookeeper --expose 2181 -p 2181:2181 -d jiangxiaoyong/zookeeper
- docker start zookeeper
- docker exec zookeeper /zookeeper-3.4.8/bin/zkServer.sh start

Kafka Docker
----------------------------
- docker run -it --name kafka --link zookeeper:zookeeper --expose 9092 -p 9092:9092 --env ADVERTISED_HOST='192.168.99.100' --env ADVERTISED_PORT=9092 -d jiangxiaoyong/kafka
- docker start kafka
- docker exec -it -d kafka /kafka_2.11-0.10.0.0/bin/kafka-server-start.sh /kafka_2.11-0.10.0.0/config/server.properties --override zookeeper.connect=${ZOOKEEPER_PORT_2181_TCP_ADDR}:${ZOOKEEPER_PORT_2181_TCP_PORT}

Producer Docker
-----------------------------
- docker run -it --name producer --expose 9999 -p 9999:9999 -v ~/IdeaProjects/TwitterProducer/:/app -d jiangxiaoyong/producer