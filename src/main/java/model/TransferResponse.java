package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Style(stagedBuilder = true)
@Value.Immutable
@JsonSerialize(as = ImmutableTransferResponse.class)
public interface TransferResponse {

    String userId();

    Boolean success();

    String txId();

    String merchantTxId();

    Optional<Number> errCode();

    Optional<String> errMsg();
}
