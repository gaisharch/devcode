package model;


import org.immutables.value.Value;

@Value.Style(stagedBuilder = true)
@Value.Immutable
public interface CancelResponse {

    String userId();

    Boolean success();

    Number errCode();

    String errMsg();
}
