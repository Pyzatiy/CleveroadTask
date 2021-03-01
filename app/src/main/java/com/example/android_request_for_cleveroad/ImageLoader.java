package com.example.android_request_for_cleveroad;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {
    public static void imgLoad(Context context, String url, ImageView imageView){
        Picasso.with(context)
                .load(url)
                .into(imageView);
    }

}
