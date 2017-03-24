package com.example.n551.intent_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by N551 on 2017/3/23.
 */


public class OtherActivity extends Activity
{

    private Bundle bunde;
    private Intent intent=new Intent();
        protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otheravtive);
        Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {
                // TODO Auto-generated method stub
			/* 返回result 回上一个activity */
                OtherActivity.this.setResult(0, intent);
			/* 结束这个activity */
                OtherActivity.this.finish();
            }
        });

        /* 取得Intent 中的Bundle 对象 */
        bunde = this.getIntent().getExtras();
		/* 取得Bundle 对象中的数据 */
        String ans = bunde.getString("a");
		/* 判断所选答案*/
        TextView tv1 = (TextView) findViewById(R.id.textView);
        String sexText = "";
        if (ans.equals("in")) {
            sexText = "正确";
        } else {
            sexText = "错误";
        }
        tv1.setText(sexText);
    }

}
