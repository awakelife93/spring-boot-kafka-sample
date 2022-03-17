package spring.kafak.component;

import java.util.concurrent.ExecutionException;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Producer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public long sendMessage(String topic, String message) throws Exception {
    try {
      SendResult<String, String> sendResult = this.kafkaTemplate.send(topic, message).get();
      return sendResult.getRecordMetadata().offset();
    } catch (InterruptedException | ExecutionException exception) {
      // exception 하나 만들기
      throw new Exception();
    }
  }
}
