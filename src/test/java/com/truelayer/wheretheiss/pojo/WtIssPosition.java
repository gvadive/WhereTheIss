
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
public class WtIssPosition {

 @JsonProperty("name")
 String name;
 @JsonProperty("id")
 BigDecimal id;
 @JsonProperty("latitude")
 BigDecimal latitude;
 @JsonProperty("longitude")
 BigDecimal longitude;
 @JsonProperty("altitude")
 BigDecimal altitude;
 @JsonProperty("velocity")
 BigDecimal velocity;
 @JsonProperty("visibility")
 String visibility;
 @JsonProperty("footprint")
 BigDecimal footprint;
 @JsonProperty("timestamp")
 BigDecimal timestamp;
 @JsonProperty("daynum")
 BigDecimal daynum;
 @JsonProperty("solar_lat")
 BigDecimal solar_lat;
 @JsonProperty("solar_lon")
 BigDecimal solar_lon;
 @JsonProperty("units")
 String units;



}
