package com.example.myrecyclerview01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RecyclerViewItemList {
    // 今回は静的に格納するDataを持っておく
    public static final Map<Integer, MainData> ITEM_LIST = Collections.unmodifiableMap(new HashMap<Integer, MainData>() {{
        put(0, new MainData(R.string.text_one));
        put(1, new MainData(R.string.text_two));
        put(2, new MainData(R.string.text_three));
        put(3, new MainData(R.string.text_four));
        put(4, new MainData(R.string.text_five));
    }});

    public static final Map<Integer, MainData> ITEM_LIST_SECOND = Collections.unmodifiableMap(new HashMap<Integer, MainData>() {{
        put(0, new MainData(R.string.one));
        put(1, new MainData(R.string.two));
        put(2, new MainData(R.string.three));
        put(3, new MainData(R.string.four));
        put(4, new MainData(R.string.five));
    }});
}
