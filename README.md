# Stream-Data-Ingestion-and-Processing-Workshop
 
 Download [StreamDataGeneration](StreamDataGeneration.zip) and import the directory **StreamDataGeneration** as a new project in Eclipse to get an overview of the code.

# Shortcut
- [Installation Commands](Resources/New_Requirements_Installation)
- [Kafka-Brokers](Resources/Kafka-Broker-Commands-New)
- [Kafka-Topics](Resources/Kafka-Topic-Commands-New)

# Apache Kafka
- Distributed data store optimized for ingesting and processing stream data in real time
- Functions
  - Publish and Subscribe (Pub-Sub) to streams of records
  - Stores the data in order in which it was generated
- Primarily used to build real-time streaming data-pipelines (Processes and moves data from one system to another)
- Combines two messaging models
  - Queuing : Model where each piece of data is read exactly once and if there are multiple consumer's, then only one would read that entry (Single subscriber)
  - Pub-Sub : Model where each piece of data is read by every subscriber exacly once (Multiple subscriber's - Data is partitioned)
- Benefits
  - Scalable : Data is distributed among multiple servers
  - Fast
  - Durable : Partitions are distributed and replicated among many servers, and data is all written to disk
 - API's
   -  Producer API : Publish stream of records to a topic
   -  Consumer API : Subscribe to topics and process their streams of records
   -  Streams API : Enables applications to behave as stream processors, which take in an input stream from a topic and transform into output stream which goes to different topics
   -  Connector API : Automate addition of another application or data system to current Kafka Topics
- Components
  - Kafka Broker : Server running in Kafka cluster (Cluster is made up of no. of brokers) (Broker acts as an intermediary between Producer and Consumer)
  - Zookeeper : Used to manage and co-ordinate Kafka Cluster (Logs of no. of brokers, topics, etc...)
  - Producer
  - Consumer
- Terms
  - Replication Factor: No. of copies of partitions maintained at different places (Multiple Brokers)

# Apache Spark
- Distributed Processing system used for big-data workloads
- Uses in-memory caching and optimized query execution for fast analytical queries against data of any size
- Benefits
  - Fast : In-Memory Caching
  - Multiple Workloads : Real-time analytics, interactive queries, graph processing, etc...
  - Developer Friendly : Python, Java, Scala
