package com.example.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerDialogActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner sp;
    private ImageView campus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dialog);
        initSpinner();

        //sp = findViewById(R.id.sp_dialog);
        campus=findViewById(R.id.campus_pic);
        findViewById(R.id.bt_campus_finish).setOnClickListener(this);
    }

    // 初始化下拉框
    private void initSpinner() {
        // 声明一个下拉列表的数组适配器
        ArrayAdapter<String> starAdapter = new ArrayAdapter<String>(this,
                R.layout.item_select, starArray);
        // 设置数组适配器的布局样式
        starAdapter.setDropDownViewResource(R.layout.item_dialog);
        //设置下拉框
        sp = findViewById(R.id.sp_dialog);
        // 设置下拉框的标题
        sp.setPrompt("请选择校区");
        // 设置下拉框的数组适配器
        sp.setAdapter(starAdapter);
        // 设置下拉框默认显示第一项
        sp.setSelection(0);
        // 给下拉框设置选择监听器，一旦用户选中某一项，就触发监听器的onItemSelected方法
        sp.setOnItemSelectedListener(new MySelectedListener());
    }

    // 定义下拉列表需要显示的文本数组
    private String[] starArray = {"中心校区", "洪家楼校区", "软件园校区", "趵突泉校区", "千佛山校区","兴隆山校区"};
    // 定义一个选择监听器，它实现了接口OnItemSelectedListener
    class MySelectedListener implements AdapterView.OnItemSelectedListener {
        // 选择事件的处理方法，其中arg2代表选择项的序号
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            //根据所选校区改变界面下方的校区图片
            switch (arg2){
                case 0 :
                    campus.setImageResource(R.drawable.campus_0);
                    break;
                case 1 :
                    campus.setImageResource(R.drawable.campus_1);
                    break;
                case 2 :
                    campus.setImageResource(R.drawable.campus_2);
                    break;
                case 3 :
                    campus.setImageResource(R.drawable.campus_3);
                    break;
                case 4 :
                    campus.setImageResource(R.drawable.campus_4);
                    break;
                case 5 :
                    campus.setImageResource(R.drawable.campus_5);
                    break;
            }
        }

        // 未选择时的处理方法，通常无需关注
        public void onNothingSelected(AdapterView<?> arg0) {}
    }

    public void onClick(View view) {
        //按下完成按钮返回注册界面
        if(view.getId()==R.id.bt_campus_finish){
            Intent intent = new Intent();  // 创建一个新意图
            Bundle bundle = new Bundle();  // 创建一个新包裹
            // 往包裹存入所选择校区的字符串
            bundle.putString("response_campus", sp.getSelectedItem().toString());
            intent.putExtras(bundle);  // 把快递包裹塞给意图
            setResult(Activity.RESULT_OK, intent);  // 携带意图返回前一个页面
            finish();  // 关闭当前页面
        }
    }
}
