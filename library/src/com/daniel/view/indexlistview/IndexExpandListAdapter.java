package com.daniel.view.indexlistview;

import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.daniel.view.expandmenulistview.IndexExpandableAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: evermobilesoft
 * Date: 13-12-18
 * Time: 上午11:17
 */
public abstract class IndexExpandListAdapter extends BaseAdapter implements SectionIndexer{
    private IndexExpandableAdapter slideExpandableListAdapter;
    private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public IndexExpandableAdapter createExpandAdapter(){
         if (slideExpandableListAdapter == null){
            slideExpandableListAdapter = new IndexExpandableAdapter(this) {
                @Override
                public Object[] getSections() {
                    return IndexExpandListAdapter.this.getSections();
                }

                @Override
                public int getPositionForSection(int section) {
                    return IndexExpandListAdapter.this.getPositionForSection(section);
                }

                @Override
                public int getSectionForPosition(int position) {
                    return IndexExpandListAdapter.this.getSectionForPosition(position);
                }
            };
         }
        return slideExpandableListAdapter;
    }
    public IndexExpandableAdapter createExpandAdapter(int btn_id,int expandable_view_id){
         if (slideExpandableListAdapter == null){
            slideExpandableListAdapter = new IndexExpandableAdapter(this, btn_id, expandable_view_id) {
                @Override
                public Object[] getSections() {
                    return new Object[0];
                }

                @Override
                public int getPositionForSection(int section) {
                    return 0;
                }

                @Override
                public int getSectionForPosition(int position) {
                    return 0;
                }
            };
         }
        return slideExpandableListAdapter;
    }

    @Override
    public int getPositionForSection(int section) {
        // If there is no item for current section, previous section will be selected
        for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    // For numeric section
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(getFirstChar(j).toString().charAt(0)), String.valueOf(k)))
                            return j;
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(getFirstChar(j).toString().charAt(0)), String.valueOf(mSections.charAt(i))))
                        return j;
                }
            }
        }
        return 0;
    }

    public abstract String getFirstChar(int position);


    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    @Override
    public Object[] getSections() {
        String[] sections = new String[mSections.length()];
        for (int i = 0; i < mSections.length(); i++)
            sections[i] = String.valueOf(mSections.charAt(i));
        return sections;
    }
}
