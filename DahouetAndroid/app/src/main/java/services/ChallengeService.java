package services;

import java.util.List;

import models.Challenge;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by devrok on 08/11/17.
 */

public interface ChallengeService {

    @GET("/challenge/")
    Call<List<Challenge>> findAll();


}