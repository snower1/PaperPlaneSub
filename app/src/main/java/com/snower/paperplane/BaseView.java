package com.snower.paperplane;

import android.view.View;

/**
 * Created by rainfool on 2017/3/7.
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    void initViews(View view);
}
