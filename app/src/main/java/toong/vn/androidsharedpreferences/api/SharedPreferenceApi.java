package toong.vn.androidsharedpreferences.api;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceApi {
    private static final String PREFS_NAME = "AndroidTestSharedPreferences";
    public static final String PREFS_USER_NAME = "PREFS_USER_NAME";
    public static final String PREFS_PASS_WORD = "PREFS_PASS_WORD";
    private SharedPreferences mSharedPreferences;

    public SharedPreferenceApi(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> clazz) {
        if(!mSharedPreferences.contains(key)){
            return null;
        }
        if (clazz == String.class) {
            return (T) mSharedPreferences.getString(key, null);
        } else if (clazz == Boolean.class) {
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, false));
        } else if (clazz == Float.class) {
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, 0));
        } else if (clazz == Integer.class) {
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, 0));
        } else if (clazz == Long.class) {
            return (T) Long.valueOf(mSharedPreferences.getLong(key, 0));
        }
        return null;
    }

    public <T> void put(String key, T data) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if(data == null){
            editor.remove(key);
        }
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        }
        editor.apply();
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }
}