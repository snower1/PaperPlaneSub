package com.snower.paperplane.homepage;

import com.snower.paperplane.BasePresenter;
import com.snower.paperplane.BaseView;
import com.snower.paperplane.bean.DoubanMomentNews;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/13.
 */
public interface DoubanMomentContract {

    interface view extends BaseView<Presenter>{
        void startLoading();

        void showLoadingError();

        void stopLoading();

        void showResult(ArrayList<DoubanMomentNews.posts> list);
    }

    interface Presenter extends BasePresenter{
        //请求数据
        void loadPosts(long date , boolean clearing);
        //刷新数据
        void refresh();
        //加载更多文章
        void loadMore(long date);
        //显示详情
        void startReading(int position);
        //随便看看
        void feelLucky();
    }
}
