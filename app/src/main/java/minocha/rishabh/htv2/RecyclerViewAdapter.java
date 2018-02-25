package minocha.rishabh.htv2;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rishabh on 24/02/18.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders>{



    public RecyclerViewAdapter(Context context, List<ReviewApplication> task) {
        this.task = task;
        this.context = context;
    }

    private List<ReviewApplication> task;
    protected Context context;
    @Override
    public RecyclerViewAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_row, parent, false);
        viewHolder = new RecyclerViewHolders(layoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.RecyclerViewHolders holder, int position) {
        holder.details.setText(task.get(position).getDescription());
        holder.time.setText(task.get(position).getTime());
        holder.location.setText(task.get(position).getLocation());
        holder.rating.setText(task.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return this.task.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder {
        TextView location, time, details, rating;

        public RecyclerViewHolders(final View itemView) {
            super(itemView);
            location = (TextView) itemView.findViewById(R.id.tvLocation);
            time = (TextView) itemView.findViewById(R.id.tvTime);
            details = (TextView) itemView.findViewById(R.id.tvDetails);
            rating = (TextView) itemView.findViewById(R.id.tvRating);
        }
    }
}
