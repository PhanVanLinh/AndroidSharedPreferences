package toong.vn.androidsharedpreferences.api;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

public class SharedPreferenceApi {
    private static final String PREFS_NAME = "AndroidTestSharedPreferences";
    public static final String PREFS_USER_NAME = "PREFS_USER_NAME";
    public static final String PREFS_PASS_WORD = "PREFS_PASS_WORD";
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPreferenceApi(Context context, Gson gson) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.gson = gson;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> clazz) {
        if (!sharedPreferences.contains(key)) {
            return null;
        }
        if (clazz == String.class) {
            return (T) sharedPreferences.getString(key, null);
        } else if (clazz == Boolean.class) {
            return (T) Boolean.valueOf(sharedPreferences.getBoolean(key, false));
        } else if (clazz == Float.class) {
            return (T) Float.valueOf(sharedPreferences.getFloat(key, 0));
        } else if (clazz == Integer.class) {
            return (T) Integer.valueOf(sharedPreferences.getInt(key, 0));
        } else if (clazz == Long.class) {
            return (T) Long.valueOf(sharedPreferences.getLong(key, 0));
        }
        return gson.fromJson(sharedPreferences.getString(key, ""), clazz);
    }

    public <T> void put(String key, T data) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (data == null) {
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
        } else {
            editor.putString(key, gson.toJson(data));
        }
        editor.apply();
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}