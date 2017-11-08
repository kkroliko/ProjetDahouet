package services;

import java.util.List;

import models.Resultat;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by devrok on 08/11/17.
 */

public interface ResultatService {

    @GET("Challenge/Regate/Resultat")
    List<Resultat> regate(@Path("{regate_id}") int challenge_id);
}
