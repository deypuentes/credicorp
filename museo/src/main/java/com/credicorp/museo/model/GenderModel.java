package com.credicorp.museo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Generated
public class GenderModel {

    @JsonProperty("gender")
    @NotNull
    private GenederEnum gender;



    public enum GenederEnum {

        WOMEN("W"),
        MAN("M"),
        CHILDREN("C");
        
        private String value;

        GenederEnum(String value){ this.value= value;}
        
        @JsonValue
        public String getValue(){return value;}
        
        public String toString(){return String.valueOf(value);}
        
        @JsonCreator
        public static GenederEnum fromValue(String value)
        {
            for ( GenederEnum a: GenederEnum.values()){
                if (a.value.equals(value)){
                    return a;
                }
            }
            throw new IllegalArgumentException("Unexpected value: "+value);
        }        
    }
}
