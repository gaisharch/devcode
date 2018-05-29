package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Style(stagedBuilder = true)
@Value.Immutable
@JsonSerialize(as = ImmutableAuthorizedResponse.class)
public interface AuthorizedResponse {

    String userId();

    Boolean success();

    String merchantTxId();

    String authCode();

    Optional<Number> errCode();

    Optional<String> errMsg();

}
