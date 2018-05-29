package model;


import org.immutables.value.Value;

import java.util.Optional;

@Value.Style(stagedBuilder = true)
@Value.Immutable
public interface CancelResponse {

    String userId();

    Boolean success();

    Optional<Number> errCode();

    Optional<String> errMsg();
}
