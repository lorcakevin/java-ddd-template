package bx.cnsr.corentsu.oscor.orders.infrastructure.adapter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableDetail {
  @JsonProperty("CTCB_DATETIME")
  private String dateTime;

  @JsonProperty("EEVV_NMR_ID")
  private long id;

  @JsonProperty("CTCB_SEQ")
  private long seq;

  @JsonProperty("CTCB_PLACE")
  private String place;

  @JsonProperty("CTCB_STATION")
  private String station;

  @JsonProperty("CTCB_SEQUENCE")
  private long sequence;

  @JsonProperty("CTCB_STATUS")
  private String status;

  @JsonProperty("CTCB_WEIGHT")
  private double weight;

  @JsonProperty("CTCB_LENGTH")
  private double length;

  @JsonProperty("CTCB_WIDTH")
  private double width;

  @JsonProperty("CTCB_HEIGHT")
  private double height;

  @JsonProperty("CTCB_VOLUME")
  private double volume;

  @JsonProperty("CTCB_DIMWEIGHT")
  private double dimWeight;

  @JsonProperty("CTCB_CHRGWEIGHT")
  private double chrgWeight;

  @JsonProperty("CTCB_BARCODE")
  private long barcode;

  @JsonProperty("CTCB_ORIGEN")
  private long origen;

  @JsonProperty("CTCB_PIEZAS")
  private long piezas;
}
