package com.example.myrecyclerview01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecyclerview01.databinding.RecyclerviewItemBinding;

import org.jetbrains.annotations.NotNull;

public class RecyclerViewAdapter extends ListAdapter<MainData, RecyclerViewAdapter.ViewHolder> {
    protected RecyclerViewAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolder viewHolder = null;
        ViewDataBinding binding = null;
        binding = RecyclerviewItemBinding.inflate(layoutInflater, parent, false);
        viewHolder = new ViewHolder(binding.getRoot());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        // 受け取ったViewのItemのPositionを確認し、Viewの更新を行うことが出来る
        // 今回は特に処理なし
        MainData mainData = getItem(position);
        holder.viewDataBinding.setVariable(BR.mainData, mainData);
        holder.viewDataBinding.executePendingBindings();
    }

    /**
     * 新旧比較
     */
    public static final DiffUtil.ItemCallback<MainData> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MainData>() {
                @Override
                public boolean areItemsTheSame(@NonNull @NotNull MainData oldItem, @NonNull @NotNull MainData newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull @NotNull MainData oldItem, @NonNull @NotNull MainData newItem) {
                    return newItem.mText == oldItem.mText;
                }
            };

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding viewDataBinding;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            viewDataBinding = DataBindingUtil.bind(itemView);
        }
    }
}
