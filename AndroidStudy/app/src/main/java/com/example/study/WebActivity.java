package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    TextView user_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        findViewById(R.id.bt_user_info).setOnClickListener(this);
        user_info=findViewById(R.id.user_info_list);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt_user_info){
            userQuery();
        }
    }

    //查询用户列表
    private void userQuery(){
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://192.168.0.104:8888/user.json")//加入相应的URL地址
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    userInfoGet(responseData);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void userInfoGet(String jsonData){
        Gson gson = new Gson();
        List<User> userList = gson.fromJson(jsonData, new TypeToken<List<User>>(){}.getType());
        for (User user:userList){
            Log.d("WebActivity","id为"+user.getUser_id());
            Log.d("WebActivity","用户名为"+user.getUser_name());
        }
    }
}
