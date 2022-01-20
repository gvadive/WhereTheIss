
package com.truelayer.wheretheiss.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class WtIssTLE {

 @JsonIgnoreProperties(value = "id", allowGetters = true)
 @JsonProperty("id")
 String id;

 @JsonIgnore
 BigDecimal requested_timestamp;

 @JsonIgnore
 BigDecimal tle_timestamp;

 @JsonIgnoreProperties(value = "name", allowGetters = true)
 @JsonProperty("name")
 String name;

 @JsonIgnoreProperties(value = "header", allowGetters = true)
 @JsonProperty("header")
 String header;

 @JsonProperty("line1")
 String line1;
 @JsonProperty("line2")
 String line2;


}
