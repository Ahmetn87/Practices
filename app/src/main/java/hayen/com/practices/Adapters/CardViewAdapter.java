package hayen.com.practices.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import hayen.com.practices.R;

/**
 * Created by AhmetNM on 10/12/16.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private static final String TAG = CardViewAdapter.class.getName();
    private List<String> desc;
    private Context context;
    private LayoutInflater inflater;

    public CardViewAdapter(Context context, List<String> desc)
    {
        this.context = context;
        this.desc = desc;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Random rnd = new Random();
        holder.cardText.setText(desc.get(rnd.nextInt(5)));
        Log.w(TAG, "VH Binded... " );
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    static class CardViewHolder extends RecyclerView.ViewHolder
    {
        private static final String TAG = CardViewHolder.class.getName();

        @BindView(R.id.card_text)
        TextView cardText;



        public CardViewHolder(View itemView) {
            super(itemView);
            Log.w(TAG, "CardViewHolder created" );
            ButterKnife.bind(this, itemView);
        }
    }


}
