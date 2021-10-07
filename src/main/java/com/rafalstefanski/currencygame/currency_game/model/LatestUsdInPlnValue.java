
package com.rafalstefanski.currencygame.currency_game.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "pln"
})
@Generated("jsonschema2pojo")
public class LatestUsdInPlnValue {

    @JsonProperty("date")
    private String date;
    @JsonProperty("pln")
    private Double pln;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("pln")
    public Double getPln() {
        return pln;
    }

    @JsonProperty("pln")
    public void setPln(Double pln) {
        this.pln = pln;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
