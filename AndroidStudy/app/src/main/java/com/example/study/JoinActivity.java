//注册界面
package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_username_join;
    private RadioGroup rg_sex;
    private RadioButton rb_sex;
    private EditText et_age;
    private Button bt_campus;
    private EditText et_password1;
    private EditText et_password2;
    private EditText et_userID;
    private EditText et_userPhone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //为选择校区按钮和完成注册按钮建立点击监听器
        findViewById(R.id.bt_campus).setOnClickListener(this);
        findViewById(R.id.bt_join_finish).setOnClickListener(this);

        //对下文需要的视图内容赋给相应变量
        et_username_join = findViewById(R.id.et_username_join);
        rg_sex = findViewById(R.id.rg_sex);
        rb_sex = findViewById(rg_sex.getCheckedRadioButtonId());
        et_age = findViewById((R.id.et_age));
        bt_campus = findViewById(R.id.bt_campus);
        et_password1 = findViewById(R.id.et_password1);
        et_password2 = findViewById(R.id.et_password2);
        et_userPhone = findViewById(R.id.et_userPhone);
    }

    public void onClick(View view) {
        //点击选择校区按钮进入选择校区界面
        if(view.getId() == R.id.bt_campus){
            // 创建一个新意图
            Intent intent = new Intent();
            // 设置意图要跳转的活动类
            intent.setClass(this, SpinnerDialogActivity.class);
            // 期望接收下个页面的返回数据
            startActivityForResult(intent, 0);
        }

        //点击完成注册按钮
        if(view.getId() == R.id.bt_join_finish){
            //判断用户名是否为空
            if (et_username_join.length()==0)
                Toast.makeText(JoinActivity.this, "输入用户名为空！", Toast.LENGTH_SHORT).show();

            else{
                //判断密码是否小于8位
                if(et_password1.length()<8)
                    Toast.makeText(JoinActivity.this, "输入密码至少为8位！", Toast.LENGTH_SHORT).show();

                else{
                    //判断两次输入密码是否相同
                    if (!et_password1.getText().toString().equals(et_password2.getText().toString()))
                        Toast.makeText(JoinActivity.this, "两次密码输入不相同！", Toast.LENGTH_SHORT).show();

                    else{
                        //判断输入手机号码是否为空
                        if (et_userPhone.length()==0)
                            Toast.makeText(JoinActivity.this, "输入手机号码为空！", Toast.LENGTH_SHORT).show();

                        else{
                        /*
                               //将输入的信息传送到服务器

                               //传入用户名
                                user.setUserName(et_username_join.getText().toString());

                                //传入性别
                                user.setSex(rg.getText().toString());

                                //传入年龄
                                user.setAge(et_age.getText());
                                }

                                //传入校区
                                user.setCampus(bt_campus.getText().toString());

                                //传入密码
                                user.setPassword(password_1);

                                //传入学号
                                user.setID(et_userID.getText().toString())
                                userRegisterRequest();
                            */

                            //符合所有条件
                            Toast.makeText(JoinActivity.this, "注册成功" , Toast.LENGTH_SHORT).show();
                            finish();
                            /*Intent intent = new Intent(JoinActivity.this, MainActivity.class);
                            startActivity(intent);*/
                        }


                    }
                }
            }
        }
    }

    //从后一个页面携带参数返回当前页面时触发
    //接受选择校区界面返回的校区名称，并将选择校区按钮的文本设为所选校区名称
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {// 接收返回数据
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            // 从意图中取出名叫response_campus的字符串（校区名称）
            String response_campus = data.getStringExtra("response_campus");
            // 把返回的校区名称显示在校区按钮上
            bt_campus.setText(response_campus);
        }
    }

    //---------------------------------------上传服务器---------------------------------------------
    /*
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what != 0) {
                //获取Id
                int id = user.getUserID();

                Toast.makeText(JoinActivity.this, "注册成功" + "您的Id为" + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(JoinActivity.this, MainActivity.class);
                startActivity(intent);
            }
            super.handleMessage(msg);
        }
    };


    public User user = new User();

    public void userRegisterRequest() {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    user.getID();//学号
                    user.getUsername();//名字
                    user.getPassword();//密码
                    user.setSex();//性别
                    user.getAge();//年龄
                    user.getPic();//图片
                    user.getCampus;//校区
                    user.getPhone;//电话
                    user.getBalance;//余额

                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    System.out.println(json);
                    RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                            , json);
                    Request request = new Request.Builder()
                            .url("http://49.234.137.198:8080/api/User/Register")//加入相应的URL地址
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    userIDget(responseData);

                    Message msg = new Message();
                    msg.what = user.getUserID();
                    handler.sendMessage(msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void userIDget(String jsonData) {
        Gson gson = new Gson();
        User user1 = gson.fromJson(jsonData, User.class);//定义一个临时储存返回的json数据
        user.setUserID(user1.getUserID());
        System.out.println(user.getUserID());//把临时数据转回上面的user之中
    }
    */
}
