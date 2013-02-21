package com.aidangordon.api.auth;

import com.aidangordon.api.bean.User;
import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;

/**
 * Created with IntelliJ IDEA.
 * User: agordon
 * Date: 2013-02-20
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExampleAuthenticator implements Authenticator<String, User> {
    private String secret = "vanillaice";

    @Override
    public Optional<User> authenticate(String token) throws AuthenticationException {
        Optional result;
        if (token.equals(secret)) {
            result = Optional.of(new User("Aidan", "Gordon"));
        } else {
            result = Optional.absent();
        }
        return result;
    }
}
