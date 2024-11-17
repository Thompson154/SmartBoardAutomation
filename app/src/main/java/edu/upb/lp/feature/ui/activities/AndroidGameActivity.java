
package edu.upb.lp.feature.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import edu.upb.lp.core.util.UiUtils;
import edu.upb.lp.feature.ui.helpers.BoardManager;
import edu.upb.lp.feature.ui.helpers.ButtonManager;
import edu.upb.lp.feature.ui.helpers.TextFieldManager;
import edu.upb.lp.genericgame.R;

public class AndroidGameActivity extends Activity {
    private BoardManager boardManager;
    private ButtonManager buttonManager;
    private TextFieldManager textFieldManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout table = (TableLayout) findViewById(R.id.maingrid);
        LinearLayout buttons = (LinearLayout) findViewById(R.id.buttons);
        LinearLayout messages = (LinearLayout) findViewById(R.id.messages);

        boardManager = new BoardManager(this, table);
        buttonManager = new ButtonManager(this, buttons, new java.util.HashMap<>(), new android.util.SparseArray<>());
        textFieldManager = new TextFieldManager(this, messages, new java.util.HashMap<>(), new android.util.SparseArray<>());

        boardManager.configureScreen(5, 5, 10, 10, true, 0.7);
        Toast.makeText(this, "Game Initialized!", Toast.LENGTH_SHORT).show();
    }
}
