package com.snower.paperplane.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.snower.paperplane.R;
import com.snower.paperplane.bean.ZhihuDailyNews;
import com.snower.paperplane.interfaze.OnRecyclerViewOnClickListener;
import com.snower.paperplane.utils.Tools;

import java.util.ArrayList;

/**
 * Created by hx on 2017-4-12.
 */

public class ZhihuDailyNewsAdaper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private final LayoutInflater inflater;
    private ArrayList<ZhihuDailyNews.Question> list = new ArrayList<ZhihuDailyNews.Question>();
    private OnRecyclerViewOnClickListener mListener;

    //文字+图片
    private static final int TYPE_NORMAL = 0;
    //加载更多
    private static final int TYPE_FOOTER = 1;

    public ZhihuDailyNewsAdaper(Context context, ArrayList<ZhihuDailyNews.Question> list) {
        Tools.printMsg("ZhihuDailyNewsAdaper()");
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Tools.printMsg("onCreateViewHolder()");
        switch (viewType){
            case TYPE_NORMAL:
                return new NormalViewHolder(inflater.inflate(R.layout.home_list_item_layout, parent, false), mListener);
            case TYPE_FOOTER:
                return new FooterViewHolder(inflater.inflate(R.layout.list_footer , parent , false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Tools.printMsg("onBindViewHolder()");
        if (holder instanceof NormalViewHolder){
            ZhihuDailyNews.Question item = list.get(position);
            if (item.getImages().get(0) == null){
                ((NormalViewHolder)holder).itemImg.setImageResource(R.drawable.placeholder);
            }else {
                Glide.with(context)
                        .load(item.getImages().get(0))
                        .asBitmap()
                        .placeholder(R.drawable.placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .error(R.drawable.placeholder)
                        .centerCrop()
                        .into(((NormalViewHolder)holder).itemImg);
            }
            ((NormalViewHolder)holder).tvLatestNewsTitle.setText(item.getTitle());
        }

    }

    @Override
    public int getItemViewType(int position) {
        Tools.printMsg("getItemViewType()");
        if (position == list.size()){
            return ZhihuDailyNewsAdaper.TYPE_FOOTER;
        }
        return ZhihuDailyNewsAdaper.TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        Tools.printMsg("");
        return list.size() + 1;
    }

    public void setItemClickListener(OnRecyclerViewOnClickListener listener) {
        Tools.printMsg("");
        this.mListener = listener;
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView itemImg;
        private TextView tvLatestNewsTitle;
        private OnRecyclerViewOnClickListener listener;

        public NormalViewHolder(View itemView, OnRecyclerViewOnClickListener listener) {
            super(itemView);
            this.listener = listener;
            this.itemImg = (ImageView) itemView.findViewById(R.id.imageViewCover);
            this.tvLatestNewsTitle = (TextView) itemView.findViewById(R.id.textViewTitle) ;
            itemImg.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.OnItemClick(view ,getLayoutPosition());
            }
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder{
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
