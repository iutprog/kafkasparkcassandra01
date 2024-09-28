# List containers
 > docker ps
# Connect to cassandra using its container ID:
 > docker exec -it 030b7f6e4f30 cqlsh


# Create the key space:
 > CREATE KEYSPACE demo_keyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};
USE demo_keyspace;
CREATE TABLE messages (
  id UUID PRIMARY KEY,
  message TEXT
);
# Build the image:
 > docker build -t kafka-spark-cassandra . 
# run the application
 > docker run --network kafkasparkcassandra01_kafka-network -p 8082:8082 kafka-spark-cassandra
# Find the kafka container id: ("start-kafka.sh")
 > docker ps
# Use it to access the kafka shell
 > docker exec -it <kafka-container-id> bash
 > docker exec -it 3026dbec7cce bash  
# Access the consumer:
 > kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic demo-topic --from-beginning
# Find a running service for port 8080:
 > netstat -aon | findstr :8080
# Kill the process with PID:
 > taskkill /PID <PID> /F
