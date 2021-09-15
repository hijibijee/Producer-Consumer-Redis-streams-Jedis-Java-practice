# Producer-Consumer-Redis-streams-Jedis-Java-practice

## Overview
This is a project where I implemented a producer and a consumer using **Jedis** library for redis in java. 
* **Producer.java:** It produces messages in "Hello msg_no" format using **xadd** method available in Jedis library to run xadd command from redis stream.
* **Consumer_1.java:** It consumes 10 messages produced by producer.java from when it (consumer) started using **xread** method available in Jedis library to run xread command from redis stream.
#
## How to run:
* start a redis server. (Head over [here](https://redis.io/topics/quickstart) if you are new to redis)
* run producer.java
* run consumer_1.java
