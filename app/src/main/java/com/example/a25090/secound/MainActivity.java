package com.example.a25090.secound;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton
        .OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private CheckBox cbSwim, cbMusic, cbBook;
    private RadioGroup rgSex;
    private Button btnConfirm;
    private RadioButton male, famale;
    String b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbSwim = (CheckBox) findViewById(R.id.cb_swim);
        cbMusic = (CheckBox) findViewById(R.id.cb_music);
        cbBook = (CheckBox) findViewById(R.id.cb_book);

        rgSex = (RadioGroup) findViewById(R.id.rg_sex);

        male = (RadioButton) findViewById(R.id.rb_male);
        famale = (RadioButton) findViewById(R.id.rb_famale);

        btnConfirm = (Button) findViewById(R.id.btn_confirm);

        cbSwim.setOnCheckedChangeListener(this);
        cbBook.setOnCheckedChangeListener(this);
        cbMusic.setOnCheckedChangeListener(this);

        rgSex.setOnCheckedChangeListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String a = compoundButton.getText().toString();
        Toast.makeText(this, a, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        b = male.getText().toString();
        c = famale.getText().toString();
        switch (i) {
            case R.id.rb_male:
                Toast.makeText(this, b, Toast.LENGTH_LONG).show();
                break;
            case R.id.rb_famale:
                Toast.makeText(this, c, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        String Hobby = "";
        if (cbBook.isChecked())
            Hobby += cbBook.getText().toString();
        if (cbMusic.isChecked())
            Hobby += cbMusic.getText().toString();
        if (cbSwim.isChecked())
            Hobby += cbSwim.getText().toString();

        String strSex = c.toString();

        Toast.makeText(this, "爱好：" +Hobby + "\n" + "性别:" + strSex + "\n", Toast.LENGTH_LONG)
                .show();
    }
}

