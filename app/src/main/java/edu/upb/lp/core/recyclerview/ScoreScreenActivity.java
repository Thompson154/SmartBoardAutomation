package edu.upb.lp.core.recyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import edu.upb.lp.core.adapter.AndroidLibrary;
import edu.upb.lp.core.adapter.ScoreItemAdapter;
import edu.upb.lp.core.model.Score;
import edu.upb.lp.genericgame.R;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScoreScreenActivity extends AppCompatActivity{
    private List<Score> listScores = new ArrayList<>();
    private static final String PREFS_NAME = "ScorePrefs";
    private static final String SCORES_KEY = "ScoresList";
    private ScoreItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score_screen);
        loadScoresFromPreferences();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.score_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        startScores();
    }

    private void loadScoresFromPreferences() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String json = preferences.getString(SCORES_KEY, null);

        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Score>>() {}.getType();
            listScores = gson.fromJson(json, type);
        }
    }

    private void startScores(){
        RecyclerView recyclerView = findViewById(R.id.score_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ScoreItemAdapter(listScores));
    }

}
