package pt.tvtime.app.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String FILENAME = "Prefs";
    private static final String KEY_SESSION = "loggedInUser";

    public static void saveSession(Context context, long userId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(KEY_SESSION, userId);
        editor.apply();
    }

    public static void deleteSession(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_SESSION);
        editor.apply();
    }

    public static long getActiveSession(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(KEY_SESSION, -1);
    }
}
