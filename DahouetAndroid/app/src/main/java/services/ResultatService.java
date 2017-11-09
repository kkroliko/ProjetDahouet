package services;

import java.util.List;

import models.Resultat;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by devrok on 08/11/17.
 */

public interface ResultatService {

    public static final String ENDPOINT = "https://10.0.2.2:8000";

    @GET("/challenge/Regate{regate_id}/Resultat/")
    Call<List<Resultat>> findByResultat(@Path("regate_id") int regate_id);
}
