package com.example.messengerr;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MyApi {
    @Headers({
            "x-rapidapi-key:b7e8a17869msh6e5c22f43627820p13e688jsna8896ebf1115",
            "x-rapidapi-host:ai-chatbot.p.rapidapi.com"
    })
    @GET("chat/free?uid=RonaldoCr7")
    Observable<Mess> getMessenger(@Query("message") String mess);
}
