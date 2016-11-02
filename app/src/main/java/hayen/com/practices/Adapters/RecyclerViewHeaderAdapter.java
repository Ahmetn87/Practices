package hayen.com.practices.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hayen.com.practices.R;
import hayen.com.practices.data.HeaderExampleEntity;

/**
 * Created by AhmetNM on 10/31/16.
 */

public class RecyclerViewHeaderAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_CELL = 0;
    private static final int STANDART_CELL = 1;
    private LayoutInflater inflater;
    private List<HeaderExampleEntity> dataList;
    private boolean isClickedForTags = false;

    public void setClickedForTags(boolean clickedForTags) {
        isClickedForTags = clickedForTags;
    }

    public RecyclerViewHeaderAdapter(Context context, List<HeaderExampleEntity> dataList)
    {
        inflater = LayoutInflater.from(context);
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == HEADER_CELL)
        {
            view = inflater.inflate(R.layout.item_recycle_header,parent,false);
            return new HeaderCellViewHolder(view);
        } else
        {
            view = inflater.inflate(R.layout.list_item_recycleview,parent,false);
            return new CellViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderCellViewHolder)
        {
            ((HeaderCellViewHolder) holder).headerText.setText("ETIKETLER");
        }else if (holder instanceof CellViewHolder)
        {
            // TODO here .......................
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && isClickedForTags) return HEADER_CELL;
        else return STANDART_CELL;
    }

    class CellViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.list_item_title_recyclelist)
        TextView itemText;
        @BindView(R.id.list_item_subtitle_recyclelist)
        TextView subtitleText;

        public CellViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class HeaderCellViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txt_recycleview_header_example)
        TextView headerText;

        public HeaderCellViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
