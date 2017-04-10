package com.snower.paperplane.bookmarks;

import android.view.View;

import com.snower.paperplane.bean.DoubanMomentNews;
import com.snower.paperplane.bean.GuokrHandpickNews;
import com.snower.paperplane.bean.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/22.
 */
public class BookmarksFragment extends android.support.v4.app.Fragment implements BookmarksContract.View {

    private static volatile BookmarksFragment bookmarksFragment;

    @Override
    public void notifyDataChanged() {

    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> zhihuList, ArrayList<GuokrHandpickNews.result> guokrList, ArrayList<DoubanMomentNews.posts> doubanList, ArrayList<Integer> types) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void setPresenter(BookmarksContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }

    public static BookmarksFragment getInstance(){
        if (null == bookmarksFragment) {
            synchronized (BookmarksFragment.class) {
                if (null == bookmarksFragment) {
                    bookmarksFragment = new BookmarksFragment();
                }
            }
        }
        return bookmarksFragment;
    }
}
