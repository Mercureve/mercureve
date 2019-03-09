package org.mercureve.service.impl;

import org.mercureve.ApplicationConstants;
import org.mercureve.domain.AuthorizedCharacter;
import org.mercureve.domain.Location;
import org.mercureve.exception.AuthTokenExpiredException;
import org.mercureve.rest.CharacterLocationCRESTInterface;
import org.mercureve.service.CharacterLocationService;
import org.mercureve.util.SessionContext;

import java.io.IOException;

import retrofit2.Response;

public class CharacterLocationServiceImpl implements CharacterLocationService {

    private CharacterLocationCRESTInterface characterLocationCRESTInterface;

    public CharacterLocationServiceImpl(CharacterLocationCRESTInterface characterLocationCRESTInterface) {
        this.characterLocationCRESTInterface = characterLocationCRESTInterface;
    }

    @Override
    public Location getLocation(String characterId) {
        try {
            String auhToken = SessionContext.getEveOauthToken().getTokenType() + ApplicationConstants.SPACE + SessionContext.getEveOauthToken().getAccessToken();
            Response<Location> execute = null;
            execute = characterLocationCRESTInterface.getLocation(auhToken, characterId).execute();
            return execute.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AuthTokenExpiredException e) {
            e.printStackTrace();
        }
        return null;
    }
}
