package com.sadataljony.app.android.demo.qrcode.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sadataljony.app.android.demo.qrcode.utils.GenerateQrcode;
import com.sadataljony.app.android.demo.qrcode.R;

public class PreviewQrcodeActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImageViewPreviewQrcode;
    private EditText mEditTextQrcodeContent;
    private Button mBtnPreviewQrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_qrcode);
        initUi();// initialize all ui elements
    }

    private void initUi() {
        mImageViewPreviewQrcode = findViewById(R.id.imageViewPreviewQrcode);
        mEditTextQrcodeContent = findViewById(R.id.editTextQrcodeContent);
        mBtnPreviewQrcode = findViewById(R.id.buttonPreviewQrcode);
        mBtnPreviewQrcode.setOnClickListener(this);// set onClick event to button
    }

    @Override
    public void onClick(View v) {

        if (v == mBtnPreviewQrcode) {
            if (mEditTextQrcodeContent.getText().toString().trim().equalsIgnoreCase("")) {// EditText can not be empty
                mEditTextQrcodeContent.setError("This field can not be blank");
            } else {
                String strQrcodeContent = mEditTextQrcodeContent.getText().toString().trim();// get string value from EditText
                Bitmap bitmapBQrcode = GenerateQrcode.generateQrcode(strQrcodeContent);// get bitmap from GenerateQrcode class by passing Qrcode content
                mImageViewPreviewQrcode.setImageBitmap(bitmapBQrcode);// set Qrcode in ImageView
                mEditTextQrcodeContent.setText("");// reset EditText
            }
        }
    }
}
