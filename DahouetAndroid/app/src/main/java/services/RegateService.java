package services;

import java.util.List;

import models.Regate;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by devrok on 08/11/17.
 */

public interface RegateService {

    public static final String ENDPOINT = "https://10.0.2.2:8000";

    @GET("challenge{regate_id}/Regate/")
    Call<List<Regate>> findByChallenge(@Path("regate_id") int regate_id);


}
