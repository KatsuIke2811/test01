package com.example.myrecyclerview01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.myrecyclerview01.RecyclerViewItemList.ITEM_LIST;
import static com.example.myrecyclerview01.RecyclerViewItemList.ITEM_LIST_SECOND;

public class MainViewModel extends ViewModel {
    public int mFlag = 0;

    // MainDataを監視するLiveData
    private MutableLiveData<List<MainData>> mMainDataMutableLiveData = new MutableLiveData<>();
    public LiveData<List<MainData>> mMainDataLiveData = mMainDataMutableLiveData;

    public LiveData<List<MainData>> getMainDataLiveData() {
        List<MainData> list = new ArrayList<>();
        // 初回表示時のList
        for (int i = 0; i < ITEM_LIST.size(); i++) {
            list.add(ITEM_LIST.get(i));
        }
        mFlag = 1;
        mMainDataMutableLiveData.setValue(list);
        return mMainDataLiveData;
    }

    /**
     * クリックごとに
     * RecyclerViewの表示を切り替える
     */
    public void onChangeButtonClick() {
        List<MainData> list = new ArrayList<>();
        if (mFlag == 0) {
            // これだと順番ばらばらになる
            // list.addAll(ITEM_LIST.values());
            // Mapで順番を指定して取得したいときは以下のような方法で処理
            for (int i = 0; i < ITEM_LIST.size(); i++) {
                list.add(ITEM_LIST.get(i));
            }
            mFlag = 1;
        } else {
            // list.addAll(ITEM_LIST_SECOND.values());
            for (int i = 0; i < ITEM_LIST_SECOND.size(); i++) {
                list.add(ITEM_LIST_SECOND.get(i));
            }
            mFlag = 0;
        }
        mMainDataMutableLiveData.postValue(list);
    }
}
