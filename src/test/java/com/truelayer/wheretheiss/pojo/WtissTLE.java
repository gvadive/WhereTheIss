
package com.truelayer.wheretheiss.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WtissTLE {

 @JsonProperty("id")
 String id;
 @JsonProperty("requested_timestamp")
 BigDecimal requested_timestamp;
 @JsonProperty("tle_timestamp")
 BigDecimal tle_timestamp;
 @JsonProperty("name")
 String name;
 @JsonProperty("header")
 String header;
 @JsonProperty("line1")
 String line1;
 @JsonProperty("line2")
 String line2;


}
