package hayen.com.practices.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hayen.com.practices.Entity.Information;
import hayen.com.practices.R;

/**
 * Created by AhmetNM on 10/10/16.
 */
public class RecycleViewAdapt extends RecyclerView.Adapter<RecycleViewAdapt.MyViewHolder> {

    private static final String TAG = RecycleViewAdapt.class.getName();
    private LayoutInflater inflater;
    List<Information> data;
    Context context;
    private static ClickListener clickListener;

    public RecycleViewAdapt(Context context, List<Information> data) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText(data.get(position).getTitleText());
        holder.subtitle.setText(data.get(position).getSubtitleText());
        Log.w(TAG, "VH Binded... " );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void delete(int position)
    {
        if (position>=0)
        {
            data.remove(position);
            notifyItemRemoved(position);
        }

    }

    public void setData(List<Information> data) {
        this.data = data;

    }

    public void addData(Information information)
    {

        data.add(0,information);
        notifyItemInserted(0);


    }

    public void addDataBulk(List<Information> information)
    {
        data.addAll(information);
        notifyItemRangeInserted(0, information.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private final String TAG = MyViewHolder.class.getName();

        @BindView(R.id.list_item_title_recyclelist)
        TextView title;
        @BindView(R.id.list_item_subtitle_recyclelist)
        TextView subtitle;
        @BindView(R.id.row_layout)
        LinearLayout rowLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            Log.w(TAG, "MyViewHolder created... " );
        }

        @OnClick(R.id.row_layout)
        public void submit(View view)
        {

            Toast.makeText(context,String.valueOf(getAdapterPosition()),Toast.LENGTH_LONG).show();
            delete(getAdapterPosition());
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view, getAdapterPosition());
        }


        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(view, getAdapterPosition());
            return false;
        }
    }


    public static void setClickListener(ClickListener clickListener) {
        RecycleViewAdapt.clickListener = clickListener;
    }

    public interface ClickListener
    {
        void onItemClick(View v, int position);
        void onItemLongClick(View v, int position);
    }

}
