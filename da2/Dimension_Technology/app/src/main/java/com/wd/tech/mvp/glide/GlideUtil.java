package com.wd.tech.mvp.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.tech.R;
import com.wd.tech.mvp.app.MyApp;


/**
 * 功能：GlideUtil类
 * 作者：闫圣豪
 * 当前日期：2019/12/30
 * 当前时间：15:39
 */
public class GlideUtil {

    public static void Loadimage(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(40)))
                .into(imageView);
    }

}
