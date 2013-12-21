package com.daniel.view.expandmenulistview;

import android.widget.BaseAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: evermobilesoft
 * Date: 13-12-18
 * Time: 下午6:59
 */
public abstract class SlideExpandListAdapter extends BaseAdapter{
    private SlideExpandableListAdapter slideExpandableListAdapter;

    public SlideExpandableListAdapter createExpandAdapter(){
        if (slideExpandableListAdapter == null){
            slideExpandableListAdapter = new SlideExpandableListAdapter(this);
        }
        return slideExpandableListAdapter;
    }
    public SlideExpandableListAdapter createExpandAdapter(int btn_id,int expandable_view_id){
        if (slideExpandableListAdapter == null){
            slideExpandableListAdapter = new SlideExpandableListAdapter(this, btn_id, expandable_view_id);
        }
        return slideExpandableListAdapter;
    }
}
