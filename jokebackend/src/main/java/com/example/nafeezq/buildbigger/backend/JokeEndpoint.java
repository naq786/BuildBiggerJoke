package com.example.nafeezq.buildbigger.backend;

import com.example.MyJokeClass;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;



/**
 * WARNING: This generated code is intended as a sample or starting point for using a
 * Google Cloud Endpoints RESTful API with an Objectify entity. It provides no data access
 * restrictions and no data validation.
 * <p>
 * DO NOT deploy this code unchanged as part of a real application to real users.
 */
@Api(
        name = "newJokeApi",
        version = "v1",
        resource = "joke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.buildbigger.nafeezq.example.com",
                ownerName = "backend.buildbigger.nafeezq.example.com",
                packagePath = ""
        )
)

public class JokeEndpoint {

    @ApiMethod(name="getJoke")

    public Joke getJoke(){
        Joke jokeReturn = new Joke();
        MyJokeClass jokeObject = new MyJokeClass();
        jokeReturn.setJokeString(jokeObject.pullJoke());
        return jokeReturn;
    }

}