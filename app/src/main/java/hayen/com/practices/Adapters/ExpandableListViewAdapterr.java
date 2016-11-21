package hayen.com.practices.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import hayen.com.practices.R;

/**
 * Created by AhmetNM on 11/20/16.
 */

public class ExpandableListViewAdapterr extends BaseExpandableListAdapter {

    private static final String TAG = ExpandableListViewAdapterr.class.getName();
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String >> listDataChild;

    private LayoutInflater inflater;

    public ExpandableListViewAdapterr(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild)
    {
        this.context=  context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
       return listDataChild.get(getGroup(i)).size();
    }

    @Override
    public String getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public String getChild(int i, int i1) {
        return listDataChild.get(getGroup(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        if (convertView == null && groupPosition == 0)
        {
            convertView = inflater.inflate(R.layout.expandable_child_row, viewGroup,false);

            TextView text = (TextView)convertView.findViewById(R.id.txt_expandable_child_row);
            text.setText(getGroup(groupPosition));
            text.setTextSize(20f);




        }else if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.expandable_child_row, viewGroup,false);
            TextView text = (TextView)convertView.findViewById(R.id.txt_expandable_child_row);
            text.setText(getGroup(groupPosition));
        }

        return convertView;
    }




    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {
        String temp = getChild(groupPosition,childPosition);
        Log.w(TAG, "groupPosition: " +String .valueOf(groupPosition)+ "childPosition "+ String.valueOf(childPosition));
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.expandable_child_row,viewGroup,false);
        }
        TextView text = (TextView)convertView.findViewById(R.id.txt_expandable_child_row);
        text.setText(temp);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


}
