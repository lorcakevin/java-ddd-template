package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.adapter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MetadataDetail {
  @JsonProperty("timestamp")
  private Date timestamp;

  @JsonProperty("record-type")
  private String recordType;

  @JsonProperty("operation")
  private String operation;

  @JsonProperty("partition-key-type")
  private String partitionKeyType;

  @JsonProperty("schema-name")
  private String schemaName;

  @JsonProperty("table-name")
  private String tableName;

  @JsonProperty("transaction-id")
  private String transactionId;
}
