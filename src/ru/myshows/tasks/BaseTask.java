package ru.myshows.tasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import ru.myshows.activity.R;
import ru.myshows.util.Utils;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 16.03.12
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseTask<T> extends AsyncTask<Object, Void, T> {

    public Context context;
    public Exception exception;
    public boolean isOnline = true;
    public boolean isForceUpdate = false;

    protected BaseTask() {
    }

    public BaseTask(Context context) {
        this.context = context;
    }

    protected BaseTask(Context context, boolean forceUpdate) {
        this.context = context;
        this.isForceUpdate = forceUpdate;
    }

    @Override
    protected void onPreExecute() {
        if (!Utils.isInternetAvailable(context))
            isOnline = false;
        if (!isOnline){
            cancel(true);
            onError(new Exception("No Internet available"));
        }
    }

    @Override
    protected T doInBackground(Object... objects) {
        try {
            return doWork(objects);
        } catch (Exception e) {
            e.printStackTrace();
            exception = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(T result) {
        if (exception == null) {
            onResult(result);
        } else {
            onError(exception);
        }
    }

    @Override
    protected void onCancelled(T t) {
        super.onCancelled(t);
    }

    public abstract T doWork(Object... objects) throws Exception;

    public abstract void onResult(T result);

    public abstract void onError(Exception e);


}
