package com.daniel.view.expandmenulistview;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import com.lidroid.xutils.R;

/**
 * Created with IntelliJ IDEA.
 * User: evermobilesoft
 * Date: 13-12-18
 * Time: 下午3:49
 */
public abstract class IndexExpandableAdapter extends AbstractSlideExpandableListAdapter implements SectionIndexer{
    private int toggle_button_id;
    private int expandable_view_id;

    public IndexExpandableAdapter(ListAdapter wrapped, int toggle_button_id, int expandable_view_id) {
        super(wrapped);
        this.toggle_button_id = toggle_button_id;
        this.expandable_view_id = expandable_view_id;
    }

    public IndexExpandableAdapter(ListAdapter wrapped) {
        this(wrapped, R.id.expandable_toggle_button, R.id.expandable);
    }

    @Override
    public View getExpandToggleButton(View parent) {
        return parent.findViewById(toggle_button_id);
    }

    @Override
    public View getExpandableView(View parent) {
        return parent.findViewById(expandable_view_id);
    }

}
