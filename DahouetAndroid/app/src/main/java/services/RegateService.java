package services;

import java.util.List;

import models.Regate;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by devrok on 08/11/17.
 */

public interface RegateService {

    public static final String ENDPOINT = "https://10.0.2.2:8000";

    @GET("Challenge/Regate{regate_id}/")
    List<Regate> regate(@Path("{regate_id}") int regate_id);


}
