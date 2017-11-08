package services;

import java.util.List;

import models.Challenge;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by devrok on 08/11/17.
 */

public interface ChallengeService {

    public static final String ENDPOINT = "https://10.0.2.2:8000";

    @GET("/Challenge/")
    List<Challenge> challenge(@Path("{challenge_id}") int challenge_id);


}