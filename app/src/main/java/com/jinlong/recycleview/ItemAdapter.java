package com.jinlong.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * 作者：贺金龙*
 * 创建时间：2017/9/2 11:46*
 * 类描述：*
 * 修改人：*
 * 修改内容:*
 * 修改时间：*
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> implements ItemMoveListener, ItemDeleteListener {

    private Context mContext;
    private List<String> mList;

    public ItemAdapter(Context context, List<String> list) {
        mContext = context;
        this.mList = list;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_view, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.tv_content.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 这个接口就是实现移动变换的
     */
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean onItemDelete(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        return true;
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        TextView tv_content;

        public ItemHolder(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_item);
        }
    }
}
