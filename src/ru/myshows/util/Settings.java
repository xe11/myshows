package ru.myshows.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import ru.myshows.activity.MyShows;
import ru.myshows.activity.R;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 09.06.2011
 * Time: 15:03:23
 * To change this template use File | Settings | File Templates.
 */
public class Settings {

    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_LOGGED_IN = "loggedIn";
    public static final String PREF_SHOW_NEWS = "show_news_key";
    public static final String PREF_SHOW_NEXT = "show_next_key";
    public static final String PREF_SHOW_PROFILE = "show_profile_key";
    public static final String PREF_SHOW_SORT = "shows_sort_key";
    public static final String PREF_SEASONS_SORT = "seasons_sort_key";


    public static SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(MyShows.context);
    }

    public static String getString(String name) {
        return getPreferences().getString(name, "");
    }

    public static void setString(String key, String value) {
        getPreferences().edit().putString(key, value).commit();
    }

    public static Boolean getBoolean(String name) {
        return getPreferences().getBoolean(name, false);
    }

    public static void setBoolean(String key, boolean value) {
        getPreferences().edit().putBoolean(key, value).commit();
    }

    public static int getInt(String name) {
        return Integer.parseInt(getPreferences().getString(name, "-1"));
    }


}
