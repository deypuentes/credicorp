package com.credicorp.museo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Generated
public class VisitorModel {

@NotBlank
@JsonProperty("total_visitors")
private String totalVisitors;

}
