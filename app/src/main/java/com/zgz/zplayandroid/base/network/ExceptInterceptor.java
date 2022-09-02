package com.zgz.zplayandroid.base.network;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author StormstoutChen
 * @project Emergency_HaiNan
 * @date 2020/6/30
 * @time 16:37
 * @description
 **/
public class ExceptInterceptor implements Interceptor {


    public interface OnLoginRefreshCallback {
        Response OnRefresh(Chain chain);
    }


    private OnLoginRefreshCallback mCallback;

    public void setCallback(OnLoginRefreshCallback callback) {
        mCallback = callback;
    }

    @Override
    @NotNull
    public Response intercept(Chain chain) throws IOException {

        return exceptInterceptor(chain);
    }


    private Response exceptInterceptor(Chain chain) throws IOException {
        if (mCallback == null) return chain.proceed(chain.request());
        return mCallback.OnRefresh(chain);
    }
}
