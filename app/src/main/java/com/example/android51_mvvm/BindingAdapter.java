package com.example.android51_mvvm;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter({"app:changeLoginView"})
    public static void changeLoginView(View view, boolean isLogin) {
        if (isLogin) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @androidx.databinding.BindingAdapter({"app:error"})
    public static void setError(EditText edt, String message){
        if (message != null){
            edt.setError(message);
        }
    }

    @androidx.databinding.BindingAdapter({"url", "placeHolder"})
    public static void loadImage(ImageView img, String url, Drawable placeHolder) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(placeHolder);

        Glide.with(img.getContext()).applyDefaultRequestOptions(requestOptions).load(url).into(img);
    }
}
