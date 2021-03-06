package model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Style(stagedBuilder = true)
@Value.Immutable
@JsonSerialize(as = ImmutableCancelResponse.class)
public interface CancelResponse {

    String userId();

    Boolean success();

    Optional<Number> errCode();

    Optional<String> errMsg();
}
