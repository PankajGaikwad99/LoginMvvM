package com.shagii.loginmvvm.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
    private static final String USER_ID = "user_id";
    private static final String EMAIL_ID = "email_id";
    private static final String MOBILE_NO = "mobile_no";
    private static final String PROFILE_ID = "profile_id";
    private static final String LANGUAGE = "language";
    private static final String ORDER_ID = "order_id";

    private static final String Full_NAME = "full_name";
    private static final String LAST_NAME = "last_name";
    private static final String TOKEN = "token";
    private static final String CART_COUNT = "cart_count";


    private static final String IS_FIRST_OPEN = "is_first_open";
    public static final String IS_LOGIN = "is_login";
    private static final String TOKEN_VALIDITY = "token_validity";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String REFRESH_TOKEN_VALIDITY = "refresh_token_validity";
    public static final String PROFILE_IMAGE = "profile_image";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String PROFILE_PIC = "profile_pic";
    public static final String AREA_CODE = "area_code";
    public static final String IS_SERVICE_AVAILABLE = "is_service_available";
    public static final String  IS_SENIOR_CITIZEN= "is_seniorcitizen";
    public static final String CITY_NAME = "city_name";
    public static final String AREA_NAME = "area_name";
    public static final String AREA_PINCODE = "area_pincode";
    public static final String REFER_CODE = "refer_code";
    public static final String ADDRESS_TYPE = "address_type";
    public static final String WITHOUTLOGIN_CART_COUNT = "withoutlogin_cart_count";

    public static final String IS_DASHBOARD = "is_dashboard";
    public static final String KEY_GET_APP_SHARE_TEXT = "I recommend you to Open Kb Food App. ";


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }


    // user id
    public static int getUserId(Context context) {
        return getSharedPreferences(context).getInt(USER_ID, 0);
    }

    public static void setUserId(Context context, int newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(USER_ID, newValue);
        editor.commit();
    }

    // First name
    public static String getFullName(Context context) {
        return getSharedPreferences(context).getString(Full_NAME, null);
    }

    public static void setFullName(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(Full_NAME, newValue);
        editor.commit();
    }

    // Last name
    public static String getLastName(Context context) {
        return getSharedPreferences(context).getString(LAST_NAME, null);
    }

    public static void setLastName(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(LAST_NAME, newValue);
        editor.commit();
    }

    // mobile no
    public static String getMobileNo(Context context) {
        return getSharedPreferences(context).getString(MOBILE_NO, null);
    }

    public static void setMobileNo(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(MOBILE_NO, newValue);
        editor.commit();
    }

    // email id
    public static String getEmailId(Context context) {
        return getSharedPreferences(context).getString(EMAIL_ID, null);
    }

    public static void setEmailId(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(EMAIL_ID, newValue);
        editor.commit();
    }

    // token
    public static String getToken(Context context) {
        return getSharedPreferences(context).getString(TOKEN, null);
    }

    public static void setToken(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(TOKEN, newValue);
        editor.commit();
    }

    //cart count
    public static int getCartCount(Context context) {
        return getSharedPreferences(context).getInt(CART_COUNT, 0);
    }

    public static void setCartCount(Context context, int newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(CART_COUNT, newValue);
        editor.commit();
    }

    // is login flag
    public static boolean getIsLogin(Context context) {
        return getSharedPreferences(context).getBoolean(IS_LOGIN, false);
    }


    public static void setIsLogin(Context context, boolean newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(IS_LOGIN, newValue);
        editor.commit();
    }


    public static boolean getIsFirstOpen(Context context) {
        return getSharedPreferences(context).getBoolean(IS_FIRST_OPEN, false);
    }

    public static void setIsFirstOpen(Context context, boolean newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(IS_FIRST_OPEN, newValue);
        editor.commit();
    }

    // profile ID
    public static int getRoleeID(Context context) {
        return getSharedPreferences(context).getInt(PROFILE_ID, 0);
    }

    public static void setRoleID(Context context, int newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(PROFILE_ID, newValue);
        editor.commit();
    }


    // language ID
    public static String getLanguageId(Context context) {
        return getSharedPreferences(context).getString(LANGUAGE, null);
    }

    public static void setLanguageId(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(LANGUAGE, newValue);
        editor.commit();
    }

    // profile_pic
    public static String getProfileImage(Context context) {
        return getSharedPreferences(context).getString(PROFILE_PIC, null);
    }

    public static void setProfileImage(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PROFILE_PIC, newValue);
        editor.commit();
    }


    // Area Code
    public static int getAreaCode(Context context) {
        return getSharedPreferences(context).getInt(AREA_CODE, 0);
    }

    public static void setAreaCode(Context context, int newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(AREA_CODE, newValue);
        editor.commit();
    }

    // Is Service Available
    public static boolean getIsServiceAvailable(Context context) {
        return getSharedPreferences(context).getBoolean(IS_SERVICE_AVAILABLE, false);
    }

    public static void setIsServiceAvailable(Context context, boolean newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(IS_SERVICE_AVAILABLE, newValue);
        editor.commit();
    }

    // City name
    public static String getCityName(Context context) {
        return getSharedPreferences(context).getString(CITY_NAME, null);
    }

    public static void setCityName(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(CITY_NAME, newValue);
        editor.commit();
    }

    // Area name
    public static String getAreaName(Context context) {
        return getSharedPreferences(context).getString(AREA_NAME, null);
    }

    public static void setAreaName(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(AREA_NAME, newValue);
        editor.commit();
    }

    // Pincode
    public static String getAreaPincode(Context context) {
        return getSharedPreferences(context).getString(AREA_PINCODE, null);
    }

    public static void setAreaPincode(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(AREA_PINCODE, newValue);
        editor.commit();
    }

    // Refercode
    public static String getRefercode(Context context) {
        return getSharedPreferences(context).getString(REFER_CODE, null);
    }

    public static void setReferCode(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(REFER_CODE, newValue);
        editor.commit();
    }

    //Address type
    public static int getAddressType(Context context) {
        return getSharedPreferences(context).getInt(ADDRESS_TYPE, 0);
    }

    public static void setAddressType(Context context, int newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(ADDRESS_TYPE, newValue);
        editor.commit();
    }


    // token validity
    public static String getTokenValidity(Context context) {
        return getSharedPreferences(context).getString(TOKEN_VALIDITY, null);
    }

    public static void setTokenValidity(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(TOKEN_VALIDITY, newValue);
        editor.commit();
    }
    //Refresh token
    public static String getRefreshToken(Context context) {
        return getSharedPreferences(context).getString(REFRESH_TOKEN, null);
    }

    public static void setRefreshToken(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(REFRESH_TOKEN, newValue);
        editor.commit();
    }

    //Refresh token validity
    public static String getRefreshTokenValidity(Context context) {
        return getSharedPreferences(context).getString(REFRESH_TOKEN_VALIDITY, null);
    }

    public static void setRefreshTokenValidity(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(REFRESH_TOKEN_VALIDITY, newValue);
        editor.commit();
    }
    // Is SeniorCitizen Available
    public static boolean getIsSeniorCitizen(Context context) {
        return getSharedPreferences(context).getBoolean(IS_SENIOR_CITIZEN, false);
    }

    public static void setIsSeniorCitizen(Context context, boolean newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(IS_SENIOR_CITIZEN, newValue);
        editor.commit();
    }
}
