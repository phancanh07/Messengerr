package com.example.messengerr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.messengerr.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    MyApi request;
    ItemAdapter adapter;
    List<Chatbot> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        request = Service.getClient().create(MyApi.class);
        adapter = new ItemAdapter();
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(binding.edt.getText().toString());
                binding.rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                binding.rv.setAdapter(adapter);

            }
        });
        adapter.setMesses(list);


    }

    private void sendMail(String mail) {
        Observable<Mess> observable = request.getMessenger(mail);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Mess>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d("CANHH1", d.toString());
                    }

                    @Override
                    public void onNext(@NonNull Mess mess) {
                        list.add(mess.getChatbot());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("CANHH3", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("CANHH4", "HHH");
                    }
                });
    }
}