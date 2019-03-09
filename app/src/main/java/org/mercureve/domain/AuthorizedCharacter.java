package org.mercureve.domain;

public class AuthorizedCharacter {

    private Long CharacterID;
    private String CharacterName;
    private String ExpiresOn;
    private String Scopes;
    private String TokenType;
    private String CharacterOwnerHash;

    public Long getCharacterId() {
        return CharacterID;
    }

    public void setCharacterId(Long characterId) {
        this.CharacterID = characterId;
    }

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String characterName) {
        this.CharacterName = characterName;
    }

    public String getExpiresOn() {
        return ExpiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.ExpiresOn = expiresOn;
    }

    public String getScopes() {
        return Scopes;
    }

    public void setScopes(String scopes) {
        this.Scopes = scopes;
    }

    public String getTokenType() {
        return TokenType;
    }

    public void setTokenType(String tokenType) {
        this.TokenType = tokenType;
    }

    public String getCharacterOwnerHash() {
        return CharacterOwnerHash;
    }

    public void setCharacterOwnerHash(String characterOwnerHash) {
        this.CharacterOwnerHash = characterOwnerHash;
    }

    @Override
    public String toString() {
        return "AuthorizedCharacter{" +
                "characterId=" + CharacterID +
                ", characterName='" + CharacterName + '\'' +
                ", expiresOn='" + ExpiresOn + '\'' +
                ", scopes='" + Scopes + '\'' +
                ", tokenType='" + TokenType + '\'' +
                ", characterOwnerHash='" + CharacterOwnerHash + '\'' +
                '}';
    }
}
