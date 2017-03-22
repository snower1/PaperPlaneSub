package com.snower.paperplane.homepage;

import com.snower.paperplane.BasePresenter;
import com.snower.paperplane.BaseView;
import com.snower.paperplane.bean.GuokrHandpickNews;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/22.
 */
public class GuokrContract {

    interface View extends BaseView<DoubanMomentContract.Presenter>{
        void showError();

        void showResults(ArrayList<GuokrHandpickNews.result> list);

        void showLoading();

        void stopLoading();
    }

    interface Presenter extends BasePresenter{
        void loadPosts();

        void refresh();

        void startReading(int position);

        void feelLucky();
    }
}
