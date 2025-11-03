package com.example.cursach;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This interface defines the API endpoints.
 * Retrofit will create an implementation of this interface.
 */
public interface ApiService {

    /**
     * This annotation tells Retrofit that this method is a GET request.
     * The string "users" is the endpoint, so the full URL will be
     * something like "https://api.example.com/users".
     */
    @GET("users")
    Call<List<User>> getUsers();
}
