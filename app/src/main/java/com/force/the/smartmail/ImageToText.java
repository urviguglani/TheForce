package com.force.the.smartmail;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * Created by urviguglani on 25/7/15.
 */

public class ImageToText {

    private PackageManager imageView;
    Drawable d;
    byte[] ba;

    int a = ba.length;

    Bitmap bitmap = ((BitmapDrawable) d).getBitmap();

    while ("BYTE LENGTH"+(ba.length/1024))    {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        Log.e("BEFORE REDUCING",
                bitmap.getHeight() + " " + bitmap.getWidth() + " "
                        + bitmap.getRowBytes() * bitmap.getHeight());

        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bao);

        ba = bao.toByteArray();
        if ((ba.length / 1024) >= 650) {
            bitmap = Bitmap.createScaledBitmap(bitmap,
                    (int) (bitmap.getWidth() * 0.95),
                    (int) (bitmap.getHeight() * 0.95), true);

        }

        Log.e();

    }

    String ba1 = Base64.encodeToString(ba, Base64.DEFAULT);

    public ImageToText() {
        d = imageView.getDrawable();
    }
}
