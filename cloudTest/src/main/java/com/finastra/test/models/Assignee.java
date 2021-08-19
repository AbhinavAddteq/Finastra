package com.finastra.test.models;

public class Assignee {
    private String accountID;
    private String emailAddress;
    private AvatarUrls avatarUrls;
    private String displayName;

    public Assignee(String accountID, String emailAddress, AvatarUrls avatarUrls, String displayName) {
        this.accountID = accountID;
        this.emailAddress = emailAddress;
        this.avatarUrls = avatarUrls;
        this.displayName = displayName;
    }

    public String getAccountID() { return accountID; }
    public void setAccountID(String value) { this.accountID = value; }

    public String getEmailAddress() { return emailAddress; }

    public void setEmailAddress(String value) { this.emailAddress = value; }


    public AvatarUrls getAvatarUrls() { return avatarUrls; }

    public void setAvatarUrls(AvatarUrls value) { this.avatarUrls = value; }

    public String getDisplayName() { return displayName; }

    public void setDisplayName(String value) { this.displayName = value; }
}
