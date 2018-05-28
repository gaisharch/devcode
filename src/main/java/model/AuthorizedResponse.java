package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Style(stagedBuilder = true)
@Value.Immutable
@JsonSerialize(as = ImmutableAuthorizedResponse.class)
public interface AuthorizedResponse {

    String userId();

    Boolean success();

    String txId();

    String merchantTxId();

    String authCode();

    Number errCode();

    String errMsg();

}
