package com.snower.paperplane.homepage;

import com.snower.paperplane.BasePresenter;
import com.snower.paperplane.BaseView;
import com.snower.paperplane.bean.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/7.
 */
public interface ZhihuDailyContract{

    interface View extends BaseView<Prensenter>{
        //显示加载或其他类型的错误
        void showError();
        //显示正在加载
        void showLoading();
        //停止显示正在加载
        void stopLoading();
        //成功获取到数据后，在界面中显示
        void showResults(ArrayList<ZhihuDailyNews.Question> list );
        //显示用于加载指定日期的date picker dialog
        void showPickDialog();
    }

    interface Prensenter extends BasePresenter{
        //请求数据
        void loadPosts(long date , boolean clearing);
        //刷新数据
        void refresh();
        //加载更多文章
        void loadMore();
        //显示详情
        void startReading(int position);
        //随便看看
        void feelLucky();

    }
}
