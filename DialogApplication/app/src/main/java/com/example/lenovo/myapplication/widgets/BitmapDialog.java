package com.example.lenovo.myapplication.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.utils.BitmapUtil;

/**
 * Created by qjb on 2016/12/5.
 */

public class BitmapDialog extends BaseFullScreenDialog {

    private RelativeLayout mContentView;
    private ImageView ivLoad;

    public BitmapDialog(Context context) {
        super(context);
    }

    public BitmapDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void initView() {
        mContentView = new RelativeLayout(mContext);
        mContentView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mContentView.setGravity(Gravity.CENTER);

        ivLoad = new ImageView(mContext);
        ivLoad.setScaleType(ImageView.ScaleType.CENTER);
        ivLoad.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

//        initAnim(mContentView);

        mContentView.addView(ivLoad);
        mWindow.setContentView(mContentView);
        setContentView(mContentView);
    }

    @Override
    public void show() {
        super.show();
        Bitmap bitmap = BitmapUtil.decodeBitmapFromResource(mContext.getResources(), R.drawable.dialog,200,160);
//        scaleAnimatorSet.start();
        ivLoad.setImageBitmap(bitmap);
    }
}
