package com.finastra.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvatarUrls {
    @JsonProperty("48x48")
    private String the48X48;

    @JsonProperty("24X24")
    private String the24X24;

    @JsonProperty("16X16")
    private String the16X16;

    @JsonProperty("32X32")
    private String the32X32;

    public AvatarUrls(String the48X48, String the24X24, String the16X16, String the32X32) {
        this.the48X48 = the48X48;
        this.the24X24 = the24X24;
        this.the16X16 = the16X16;
        this.the32X32 = the32X32;
    }

    @JsonProperty("48x48")
    public String getThe48X48() { return the48X48; }

    @JsonProperty("48x48")
    public void setThe48X48(String value) { this.the48X48 = value; }

    @JsonProperty("24X24")
    public String getThe24X24() { return the24X24; }

    @JsonProperty("24X24")
    public void setThe24X24(String value) { this.the24X24 = value; }

    @JsonProperty("16X16")
    public String getThe16X16() { return the16X16; }

    @JsonProperty("16X16")
    public void setThe16X16(String value) { this.the16X16 = value; }

    @JsonProperty("32X32")
    public String getThe32X32() { return the32X32; }

    @JsonProperty("32X32")
    public void setThe32X32(String value) { this.the32X32 = value; }

    @Override
    public String toString() {
        return "AvatarUrls{" +
                "the48X48='" + the48X48 + '\'' +
                ", the24X24='" + the24X24 + '\'' +
                ", the16X16='" + the16X16 + '\'' +
                ", the32X32='" + the32X32 + '\'' +
                '}';
    }
}