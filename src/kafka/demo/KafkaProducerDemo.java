package kafka.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.*;

public class KafkaProducerDemo {
	private final Producer<String,String> kafkaProducer;

    public final static String TOPIC= "JAVA_TOPIC";

    public KafkaProducerDemo(){
        kafkaProducer = createKafkaProducer();
    }

    private Producer<String,String> createKafkaProducer(){
        Properties pros = new Properties();
        pros.put("bootstrap.servers","127.0.0.1:9092");
        pros.put("acks","all");// 生产者需要server接收到数据之后，要发出一个确认接收的信号
					        // 0 producer不需要等待任何确认的消息
					        // 1 意味着至少要等待leader已经成功将数据写入本地log，并不意味着所有follower已经写入
					        // all 意味着leader需要等待所有备份都成功写入到日志中
        pros.put("retries",0);// 重试次数
        pros.put("batch.size",1000); // producer试图批量处理消息记录。目的是减少请求次数，改善客户端和服务端之间的性能。
        // 这个配置是控制批量处理消息的字节数。如果设置为0，则禁用批处理。如果设置过大，会占用内存空间.
        pros.put("linger.ms",1);
        pros.put("buffer.memory",33554432);// 缓存大小
        pros.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        pros.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> kafkaProducer = new KafkaProducer<String, String>(pros);
       
        return kafkaProducer;
    }

    void producer(){
        for(int i=0;i<10;i++){

            final String key = "key" + i;
            String data = "hello kafka message:" + key;
            kafkaProducer.send(new ProducerRecord<String, String>(TOPIC, key, data), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println("发送了key" + key + "成功");
                }
            });
        }
        
        
    }

    public static void main(String [] args){
        KafkaProducerDemo kafka = new KafkaProducerDemo();
        kafka.producer();
    }
}
