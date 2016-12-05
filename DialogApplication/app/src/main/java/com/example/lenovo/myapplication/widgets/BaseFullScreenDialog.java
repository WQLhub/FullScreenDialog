package com.example.lenovo.myapplication.widgets;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lenovo.myapplication.R;

/**
 * Created by qjb on 2016/12/5.
 */

public abstract class BaseFullScreenDialog extends Dialog {

    protected Context mContext;
    protected Window mWindow;

    private Animator scaleAnimatorX;
    private Animator scaleAnimatorY;
    protected AnimatorSet scaleAnimatorSet;

    public BaseFullScreenDialog(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public BaseFullScreenDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        init();
    }

    private void init(){
        initWinow();
        initView();
    }

    protected void initWinow(){
        mWindow = getWindow();
        mWindow.getDecorView().setPadding(0,0,0,0);
        mWindow.setWindowAnimations(R.style.dilogOut); //设置窗口弹出动画
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindow.setAttributes(lp);
    }

    protected void initAnim(View view){
        scaleAnimatorSet = new AnimatorSet();
        scaleAnimatorX = ObjectAnimator.ofFloat(view,"scaleX",0.0f,1.3f,0.8f,1.1f,0.9f,1.0f);
        scaleAnimatorY = ObjectAnimator.ofFloat(view,"scaleY",0.0f,1.3f,0.8f,1.1f,0.9f,1.0f);
        scaleAnimatorSet.playTogether(scaleAnimatorX,scaleAnimatorY);
        scaleAnimatorSet.setDuration(1200);
    }

    protected abstract void initView();

}
