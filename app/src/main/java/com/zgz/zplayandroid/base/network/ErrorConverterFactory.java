package com.zgz.zplayandroid.base.network;

import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author StormstoutChen
 * @project Emergency_HaiNan
 * @date 2020/6/30
 * @time 15:27
 * @description
 **/
public class ErrorConverterFactory extends Converter.Factory {



    public static ErrorConverterFactory create(){
        return new ErrorConverterFactory();
    }

    private ErrorConverterFactory() {
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        String path = retrofit.baseUrl().url().toString();

        return super.responseBodyConverter(type, annotations, retrofit);
    }
}
