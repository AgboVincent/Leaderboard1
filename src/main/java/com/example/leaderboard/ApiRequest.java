package com.example.leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiRequest {
    @Headers({
            "Content-Type:application/json"

    })

   // @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")


    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<List<Post>> savePost

    (
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String LastName,
            @Field("entry.1824927963") String EmailAddress,
            @Field("entry.284483984")String ProjectLink

    );
    Call<Post> creatpost (@Body Post post);


}
