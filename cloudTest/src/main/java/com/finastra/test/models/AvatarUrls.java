package com.finastra.test.models;

public class AvatarUrls {
    private String the48X48;
    private String the24X24;
    private String the16X16;
    private String the32X32;

    public AvatarUrls(String the48X48, String the24X24, String the16X16, String the32X32) {
        this.the48X48 = the48X48;
        this.the24X24 = the24X24;
        this.the16X16 = the16X16;
        this.the32X32 = the32X32;
    }

    public String getThe48X48() { return the48X48; }

    public void setThe48X48(String value) { this.the48X48 = value; }


    public String getThe24X24() { return the24X24; }

    public void setThe24X24(String value) { this.the24X24 = value; }


    public String getThe16X16() { return the16X16; }

    public void setThe16X16(String value) { this.the16X16 = value; }


    public String getThe32X32() { return the32X32; }
    public void setThe32X32(String value) { this.the32X32 = value; }
}