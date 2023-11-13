package bx.cnsr.corentsu.oscor.orders.infrastructure.adapter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DataRecord {
  @JsonProperty("data")
  private TableDetail data;

  @JsonProperty("metadata")
  private MetadataDetail metadata;
}
