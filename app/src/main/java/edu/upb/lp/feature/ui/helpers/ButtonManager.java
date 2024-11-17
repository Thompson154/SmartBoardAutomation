package edu.upb.lp.feature.ui.helpers;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Map;
import android.util.SparseArray;

import edu.upb.lp.core.util.UiUtils;

public class ButtonManager {
    private final LinearLayout buttons;
    private final Map<String, Integer> viewIds;
    private final SparseArray<String> viewNames;
    private final Context context;

    public ButtonManager(Context context, LinearLayout buttons, Map<String, Integer> viewIds, SparseArray<String> viewNames) {
        this.context = context;
        this.buttons = buttons;
        this.viewIds = viewIds;
        this.viewNames = viewNames;
    }

    public void addButton(String name, int textSize, int buttonSize, View.OnClickListener listener) {
        Integer id = viewIds.get(name);
        Button button;
        if (id == null) {
            id = UiUtils.generateViewId();
            button = new Button(context);
            button.setId(id);
            viewIds.put(name, id);
            viewNames.put(id, name);
            button.setOnClickListener(listener);
            button.setGravity(Gravity.CENTER);
            button.setSoundEffectsEnabled(false);
            buttons.addView(button);
        } else {
            button = (Button) buttons.findViewById(id);
        }

        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                UiUtils.dpToPixel(context, buttonSize));
        button.setLayoutParams(buttonParams);
        button.setText(name);
        button.setTextSize(textSize);
    }

    public void removeButton(String name) {
        Integer id = viewIds.get(name);
        if (id != null) {
            View view = buttons.findViewById(id);
            buttons.removeView(view);
            viewIds.remove(name);
            viewNames.remove(id);
        }
    }

    public void removeAllButtons() {
        buttons.removeAllViews();
        viewIds.clear();
        viewNames.clear();
    }
}