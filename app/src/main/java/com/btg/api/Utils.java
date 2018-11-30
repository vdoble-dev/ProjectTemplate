package com.btg.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;

import com.btg.api.values.APIError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Utils {

    public static APIError parseErrorResponse(Response<?> response, Retrofit retrofitInstance) {
        Converter<ResponseBody, APIError> converter =
                retrofitInstance.responseBodyConverter(APIError.class, new Annotation[0]);

        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }

    public static Bitmap base64ToBitmap(String base64) {
        byte[] imageDecodedString = Base64.decode(base64, Base64.DEFAULT);
        Bitmap imageDecodedByte = BitmapFactory.decodeByteArray(imageDecodedString, 0, imageDecodedString.length);
        return  imageDecodedByte;
    }

    public static void showToast(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show();
    }

    public static boolean findText(CharSequence text, CharSequence textToFind) {
        if (text == null || textToFind == null) return false;

        String text1 = text.toString().toLowerCase();
        String text2 = textToFind.toString().toLowerCase();

        if(TextUtils.indexOf(text1, text2) != -1) return true;

        return false;
    }

    public static class Constants {
    }

}
