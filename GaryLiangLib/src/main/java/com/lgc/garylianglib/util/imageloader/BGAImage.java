/**
 * Copyright 2016 bingoogolapple
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lgc.garylianglib.util.imageloader;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.lgc.garylianglib.util.L;

/**
 * <pre>
 *     author : feijin_lgc
 *     e-mail : 595184932@qq.com
 *     time   : 2017/12/1 上午10:12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BGAImage {
    private static final String TAG = BGAImage.class.getSimpleName();
    private static BGAImageLoader sImageLoader;

    private BGAImage() {
    }

    private static final BGAImageLoader getImageLoader() {
        if (sImageLoader == null) {
            synchronized (BGAImage.class) {
                if (sImageLoader == null) {
                        sImageLoader = new BGAGlideImageLoader();
                }
            }
        }
        return sImageLoader;
    }

    private static final boolean isClassExists(String classFullName) {
        try {
            Class.forName(classFullName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void display(ImageView imageView, @DrawableRes int loadingResId, @DrawableRes int failResId, String path, int width, int height, final BGAImageLoader.DisplayDelegate delegate) {
        try {
            getImageLoader().display(imageView, path, loadingResId, failResId, width, height, delegate);
        } catch (Exception e) {
            L.d(TAG, "显示图片失败：" + e.getMessage());
        }
    }

    public static void display(ImageView imageView, @DrawableRes int placeholderResId, String path, int width, int height, final BGAImageLoader.DisplayDelegate delegate) {
        display(imageView, placeholderResId, placeholderResId, path, width, height, delegate);
    }

    public static void display(ImageView imageView, @DrawableRes int placeholderResId, String path, int width, int height) {
        display(imageView, placeholderResId, path, width, height, null);
    }

    public static void display(ImageView imageView, @DrawableRes int placeholderResId, String path, int size) {
        display(imageView, placeholderResId, path, size, size);
    }


    public static void display(ImageView imageView, @DrawableRes int loadingResId, @DrawableRes int failResId, String path, final BGAImageLoader.DisplayDelegate delegate) {
        try {
            getImageLoader().display(imageView, path, loadingResId, failResId, delegate);
        } catch (Exception e) {
            L.d(TAG, "显示图片失败：" + e.getMessage());
        }
    }


    public static void displayCircle(ImageView imageView, @DrawableRes int loadingResId, @DrawableRes int failResId, String path, final BGAImageLoader.DisplayDelegate delegate) {
        try {
            getImageLoader().displayCircle(imageView, path, loadingResId, failResId, delegate);
        } catch (Exception e) {
            L.d(TAG, "显示图片失败：" + e.getMessage());
        }
    }
    public static void displayCircle(ImageView imageView, @DrawableRes int loadingResId, @DrawableRes int failResId, String path) {
        try {
            getImageLoader().displayCircle(imageView, path, loadingResId, failResId, null);
        } catch (Exception e) {
            L.d(TAG, "显示图片失败：" + e.getMessage());
        }
    }
    public static void download(String path, final BGAImageLoader.DownloadDelegate delegate) {
        try {
            getImageLoader().download(path, delegate);
        } catch (Exception e) {
            L.d(TAG, "下载图片失败：" + e.getMessage());
        }
    }

    /**
     * 暂停加载
     *
     * @param activity
     */
    public static void pause(Activity activity) {
        getImageLoader().pause(activity);
    }

    /**
     * @param activity
     */
    public static void resume(Activity activity) {
        getImageLoader().resume(activity);
    }
}
