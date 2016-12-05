package com.example.lenovo.myapplication.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by qjb on 2016/12/5.
 */

public class BitmapUtil {

    public static Bitmap decodeBitmapFromResource(Resources resources,int resId,int reqWidth,int reqHeight){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources,resId,options);

        options.inSampleSize = calculateSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(resources,resId,options);
    }

    private static int calculateSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        //原图片宽高
        int height = options.outHeight;
        int width = options.outWidth;

        int inSampleSize = 1;

        if (height>reqHeight||width>reqWidth){
            final int halfHeight = height/2;
            final int halfWidth = width/2;

            while (halfHeight/inSampleSize>=reqHeight&&halfWidth/inSampleSize>=reqWidth){
                inSampleSize*=2;
            }
        }
        return inSampleSize;
    }

}
