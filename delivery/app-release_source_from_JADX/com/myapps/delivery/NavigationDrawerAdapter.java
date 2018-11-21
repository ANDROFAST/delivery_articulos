package com.myapps.delivery;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class NavigationDrawerAdapter extends Adapter<ViewHolder> {
    private List<NavigationItem> mData;
    private NavigationDrawerCallbacks mNavigationDrawerCallbacks;
    private int mSelectedPosition;
    private int mTouchedPosition = -1;

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(C0477R.id.item_name);
        }
    }

    public NavigationDrawerAdapter(List<NavigationItem> data) {
        this.mData = data;
    }

    public NavigationDrawerCallbacks getNavigationDrawerCallbacks() {
        return this.mNavigationDrawerCallbacks;
    }

    public void setNavigationDrawerCallbacks(NavigationDrawerCallbacks navigationDrawerCallbacks) {
        this.mNavigationDrawerCallbacks = navigationDrawerCallbacks;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0477R.layout.drawer_row, viewGroup, false));
        viewHolder.itemView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        NavigationDrawerAdapter.this.touchPosition(viewHolder.getPosition());
                        return false;
                    case 1:
                        NavigationDrawerAdapter.this.touchPosition(-1);
                        return false;
                    case 2:
                        return false;
                    case 3:
                        NavigationDrawerAdapter.this.touchPosition(-1);
                        return false;
                    default:
                        return true;
                }
            }
        });
        viewHolder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (NavigationDrawerAdapter.this.mNavigationDrawerCallbacks != null) {
                    NavigationDrawerAdapter.this.mNavigationDrawerCallbacks.onNavigationDrawerItemSelected(viewHolder.getPosition());
                }
            }
        });
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(((NavigationItem) this.mData.get(i)).getText());
        viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(((NavigationItem) this.mData.get(i)).getDrawable(), null, null, null);
        if (this.mSelectedPosition == i || this.mTouchedPosition == i) {
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(C0477R.color.selected_gray));
        } else {
            viewHolder.itemView.setBackgroundColor(0);
        }
    }

    private void touchPosition(int position) {
        int lastPosition = this.mTouchedPosition;
        this.mTouchedPosition = position;
        if (lastPosition >= 0) {
            notifyItemChanged(lastPosition);
        }
        if (position >= 0) {
            notifyItemChanged(position);
        }
    }

    public void selectPosition(int position) {
        int lastPosition = this.mSelectedPosition;
        this.mSelectedPosition = position;
        notifyItemChanged(lastPosition);
        notifyItemChanged(position);
    }

    public int getItemCount() {
        return this.mData != null ? this.mData.size() : 0;
    }
}
