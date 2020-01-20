package com.sadataljony.app.android.demo.qrcode.utils;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GenerateQrcode {

    public static Bitmap generateQrcode(String strQrcodeContent) {// this metorh return Bitmap of the Qrcode
        QRCodeWriter writer = new QRCodeWriter();// implementation 'me.dm7.barcodescanner:zxing:1.9' is needed to add in build.gradle(Module: app) dependency
        BitMatrix bitMatrix = null;
        Bitmap bmpQrCode = null;
        try {
            bitMatrix = writer.encode(strQrcodeContent, BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            bmpQrCode = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmpQrCode.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bmpQrCode;
    }
}
