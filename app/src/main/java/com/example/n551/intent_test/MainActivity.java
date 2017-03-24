package com.example.n551.intent_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;
    int sum=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);
        Button b1 = (Button) findViewById(R.id.sure);
        Button b2 = (Button) findViewById(R.id.cancel);
        b1.setOnClickListener(new View.OnClickListener() {
            String ans;
            public void onClick(View v) {
                                      if (r1.isChecked()) {
                                          ans = "on";
                                      }
                                  if (r2.isChecked()) {
                                          ans = "at";
                                      }
                                      if (r3.isChecked()) {
                                          ans = "of";
                                      }
                                      if (r4.isChecked()) {
                                          ans = "in";
                                      }
                                      Intent intent = new Intent();
                                      intent.setClass(MainActivity.this, OtherActivity.class);
                                     Bundle bundle = new Bundle();
                                      bundle.putString("a", ans);
                                       intent.putExtras(bundle);
                                      startActivityForResult(intent, 0);
                                      setTitle("");
                                  }
                              }
        );
                b2.setOnClickListener(new b2_Cancl());
    }
    class b2_Cancl implements View.OnClickListener {
        public void onClick(View v) {
            radioGroup.clearCheck();
            setTitle("选一个答案吧少年");
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==resultCode) {
            setTitle("回来咯" + sum++ +"次");
        }
    }
}
