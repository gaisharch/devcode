package model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;


@Value.Style(stagedBuilder = true)
@Value.Immutable
@JsonSerialize(as = ImmutableVerifyUserResponse.class)
public interface VerifyUserResponse {

    String userId();

    boolean success();

    String firstName();

    String lastName();

    String street();

    String city();

    String zip();

    String country();

    String email();

    String dob();

    String mobile();

    Number balance();

    String balanceCy();

    Optional<String> locale();

    Optional<String> userCat();

    Optional<String> kycStatus();

    Optional<TypeOfSex> sex();

    Optional<Number> errCode();

    Optional<String> errMsg();

}


