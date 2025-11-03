package com.example.cursach;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // A tag for logging, so we can easily filter messages in Logcat.
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the ApiService interface.
        // Retrofit will create an implementation of this interface for us.
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        // 2. Make the API call.
        // The `getUsers()` method returns a `Call` object, which represents
        // a single request/response pair.
        Call<List<User>> call = apiService.getUsers();

        // 3. Enqueue the call.
        // This runs the request on a background thread.
        // If you tried to run this on the main thread, the app would crash.
        call.enqueue(new Callback<List<User>>() {
            /**
             * This method is called when the server responds.
             * It doesn't matter if the response is successful or not.
             */
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                // 4. Check if the request was successful.
                // A successful request has a code between 200 and 299.
                if (response.isSuccessful()) {
                    // 5. Get the list of users from the response body.
                    List<User> userList = response.body();
                    if (userList != null) {
                        // 6. Log the data.
                        // We're just logging the data here, but in a real app,
                        // you would display it in a RecyclerView or similar.
                        for (User user : userList) {
                            Log.d(TAG, "User: " + user.getName() + " (" + user.getEmail() + ")");
                        }
                    }
                } else {
                    // If the request was not successful, we can get more information
                    // from the error body.
                    Log.e(TAG, "onResponse: " + response.errorBody());
                }
            }

            /**
             * This method is called when the request fails.
             * This could be due to a network error, a timeout, or a problem
             * with the server.
             */
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}