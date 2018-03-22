package com.gapcoder.api.FG;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by suxiaohui on 2018/3/22.
 */

public class BaseFG extends Fragment{
    protected boolean isVisible;
    protected boolean isCreated;
    protected boolean isLoaded;
    @Override public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("tag",String.valueOf(isVisibleToUser));
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();

        } else {
            isVisible = false;
        }
    }
    protected  void lazyLoad() {

    }
}
