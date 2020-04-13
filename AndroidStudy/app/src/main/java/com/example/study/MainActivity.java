//登陆界面
package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editID;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_log).setOnClickListener(this);
        findViewById(R.id.bt_join).setOnClickListener(this);
        findViewById(R.id.bt_test).setOnClickListener(this);

        editID = findViewById(R.id.et_ID);
        editPassword = findViewById(R.id.et_password);
    }

    public void onClick(View view) {
        //按下登陆按钮
        if(view.getId() == R.id.bt_log){
            //判断输入ID或密码是否为空
            if (editID.length() == 0 || editPassword.length() == 0)
                Toast.makeText(MainActivity.this, "ID或密码为空！", Toast.LENGTH_SHORT).show();
            else {

                    /*
                    //判断账号是否存在
                    if (账号不存在)
                        Toast.makeText(MainActivity.this, "账号不存在！", Toast.LENGTH_SHORT).show();

                    else{
                        //判断密码是否错误
                        if (密码错误)
                            Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                        else (登陆)
                    }
                    */

                Intent intent = new Intent(MainActivity.this, temp_shop_list.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        //按下注册按钮
        if(view.getId() == R.id.bt_join){
            Intent intent = new Intent(MainActivity.this, JoinActivity.class);
            startActivity(intent);
        }

        //按下测试按钮
        if(view.getId() == R.id.bt_test){
            Intent intent = new Intent(MainActivity.this, WebActivity.class);
            startActivity(intent);
        }
    }
}


