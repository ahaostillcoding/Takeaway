package com.example.application;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import java.net.URL;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etPassword;
    private EditText etNumber;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this,"按钮测试", Toast.LENGTH_SHORT).show();
        initView();
        Map<String, String> userInfo = FileSavaQQ.getUserInfo(this);
        if (userInfo != null) {
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
        }
    }
    private void initView() {
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String number = etNumber.getText().toString().trim();
        String password = etPassword.getText().toString();

        //检验账号密码
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this,"请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
//        if (number != "admin") {
//            Toast.makeText(this, "账号或者密码错误", Toast.LENGTH_SHORT).show();
//        }
        //
        //登录成功
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
        //保存用户信息
        boolean isSavaSuccess = FileSavaQQ.saveUserInfo(this, number, password);
        if (isSavaSuccess) {
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
        }
    }
}