package org.rovak.events;

import lombok.Getter;
import lombok.Setter;

public class UnfreezeBalance extends Event {

  @Getter
  private String eventType = "unfreeze";

  @Getter
  private String address;

  public UnfreezeBalance(String address) {
    this.address = address;
  }
}
