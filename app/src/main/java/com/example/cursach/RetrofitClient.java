package com.example.cursach;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is a singleton that provides a single instance of Retrofit.
 * This is the recommended way to use Retrofit, as it's expensive to create
 * a new Retrofit instance for every request.
 */
public class RetrofitClient {

    // You need to replace this with the base URL of your API.
    // For example, if your API is hosted at https://api.example.com/,
    // this would be "https://api.example.com/".
    // I'm using a placeholder here.
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static Retrofit retrofit;

    /**
     * This method returns a single instance of Retrofit.
     * If the instance doesn't exist, it creates a new one.
     */
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // This tells Retrofit to use Gson to parse the JSON response.
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
