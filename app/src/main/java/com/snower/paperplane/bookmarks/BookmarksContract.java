/*
 * Copyright 2017 lizhaotailang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.snower.paperplane.bookmarks;

import com.snower.paperplane.BasePresenter;
import com.snower.paperplane.BaseView;
import com.snower.paperplane.bean.BeanType;
import com.snower.paperplane.bean.DoubanMomentNews;
import com.snower.paperplane.bean.GuokrHandpickNews;
import com.snower.paperplane.bean.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by lizhaotailang on 2016/12/20.
 */

public interface BookmarksContract {

    interface View extends BaseView<Presenter> {

        void showResults(ArrayList<ZhihuDailyNews.Question> zhihuList,
                         ArrayList<GuokrHandpickNews.result> guokrList,
                         ArrayList<DoubanMomentNews.posts> doubanList,
                         ArrayList<Integer> types);

        void notifyDataChanged();

        void showLoading();

        void stopLoading();

    }

    interface Presenter extends BasePresenter {

        void loadResults(boolean refresh);

        void startReading(BeanType type, int position);

        void checkForFreshData();

        void feelLucky();

    }

}
