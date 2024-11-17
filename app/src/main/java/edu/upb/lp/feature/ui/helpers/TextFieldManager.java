package edu.upb.lp.feature.ui.helpers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Map;
import android.util.SparseArray;

import edu.upb.lp.core.util.UiUtils;

public class TextFieldManager {
    private final LinearLayout messages;
    private final Map<String, Integer> viewIds;
    private final SparseArray<String> viewNames;
    private final Context context;

    public TextFieldManager(Context context, LinearLayout messages, Map<String, Integer> viewIds, SparseArray<String> viewNames) {
        this.context = context;
        this.messages = messages;
        this.viewIds = viewIds;
        this.viewNames = viewNames;
    }

    public void addTextField(String name, String message, int textSize, int textFieldSize) {
        TextView view;
        Integer id = viewIds.get(name);
        if (id == null) {
            view = new TextView(context);
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    UiUtils.dpToPixel(context, textFieldSize));
            view.setLayoutParams(textParams);
            id = UiUtils.generateViewId();
            view.setId(id);
            viewIds.put(name, id);
            viewNames.put(id, name);
            view.setText(message);
            view.setTextSize(textSize);
            messages.addView(view);
        } else {
            updateTextField(name, message);
        }
    }

    public void updateTextField(String name, String message) {
        int id = viewIds.get(name);
        TextView view = (TextView) messages.findViewById(id);
        if (view != null) {
            view.setText(message);
        }
    }

    public void removeTextField(String name) {
        Integer id = viewIds.get(name);
        if (id != null) {
            View view = messages.findViewById(id);
            messages.removeView(view);
            viewIds.remove(name);
            viewNames.remove(id);
        }
    }

    public void removeAllTextFields() {
        messages.removeAllViews();
        viewIds.clear();
        viewNames.clear();
    }
}