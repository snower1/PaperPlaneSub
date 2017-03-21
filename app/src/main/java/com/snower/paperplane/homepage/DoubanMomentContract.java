package com.snower.paperplane.homepage;

import com.snower.paperplane.BasePresenter;
import com.snower.paperplane.BaseView;

/**
 * Created by rainfool on 2017/3/13.
 */
public interface DoubanMomentContract {

    interface view extends BaseView<Presenter>{
        void startLoading();

        void showLoadingError();

        void stopLoading();

        void showResult();
    }

    interface Presenter extends BasePresenter{

    }
}
