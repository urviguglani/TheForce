package com.force.the.smartmail;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by urviguglani on 25/7/15.
 */

public class ImageToText {

   public static void imageToText(ImageView imageView) {
       Drawable d = imageView.getDrawable();

       Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
       byte[] ba;
       do {
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

           Log.e("BYTE LENGTH", "" + ba.length / 1024);

       } while ((ba.length / 1024) >= 650);

       String ba1 = Base64.encodeToString(ba, Base64.DEFAULT);


    }


}
