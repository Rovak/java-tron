package org.rovak.events;

import lombok.Getter;
import org.tron.common.utils.ByteArray;
import org.tron.core.capsule.AccountCapsule;
import org.tron.protos.Protocol;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class AccountVoted extends Event {

  @Getter
  private String eventType = "account_voted";

  @Getter
  private String address;

  @Getter
  private HashMap<String, Long> votes;

  public AccountVoted(AccountCapsule account) {
    this.address = ByteArray.toHexString(account.getAddress().toByteArray());
    this.votes = new HashMap<>();

    account.getVotesList().forEach(vote -> {
      votes.put(ByteArray.toHexString(vote.getVoteAddress().toByteArray()), vote.getVoteCount());
    });
  }
}
