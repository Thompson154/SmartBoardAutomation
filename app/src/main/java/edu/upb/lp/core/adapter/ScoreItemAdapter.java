package edu.upb.lp.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.upb.lp.genericgame.R;
import edu.upb.lp.core.model.Score;

public class ScoreItemAdapter extends RecyclerView.Adapter<ScoreItemAdapter.ScoreItemAdapterViewHolder> {

    private final List<Score> scoreList;

    public ScoreItemAdapter(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public ScoreItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_score, parent, false);
        return new ScoreItemAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreItemAdapterViewHolder holder, int position) {
        Score score = scoreList.get(position);
        holder.namePlayer.setText(score.getName());
        holder.scorePlayer.setText(String.valueOf(score.getScore()));
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public static class ScoreItemAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView namePlayer;
        TextView scorePlayer;

        public ScoreItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            namePlayer = itemView.findViewById(R.id.name_player);
            scorePlayer = itemView.findViewById(R.id.score_player);
        }
    }
}
