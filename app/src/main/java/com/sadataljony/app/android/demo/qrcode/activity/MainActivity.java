package com.sadataljony.app.android.demo.qrcode.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sadataljony.app.android.demo.qrcode.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnPreviewQrcode, mBtnScanQrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();// initialize ui elements
    }

    private void initUi() {
        mBtnPreviewQrcode = findViewById(R.id.buttonPreviewQrcode);
        mBtnScanQrcode = findViewById(R.id.buttonScanQrcode);
        mBtnPreviewQrcode.setOnClickListener(this);// set onClick event on Preview Qrcode Button
        mBtnScanQrcode.setOnClickListener(this);// set onClick event on Scan Qrcode Button
    }

    @Override
    public void onClick(View v) {

        if (v == mBtnPreviewQrcode) {
            startActivity(new Intent(MainActivity.this, PreviewQrcodeActivity.class));// goto PreviewQrcodeActivity
        }

        if (v == mBtnScanQrcode) {
            startActivity(new Intent(MainActivity.this, ScanQrcodeActivity.class));// goto ScanQrcodeActivity
        }
    }
}
