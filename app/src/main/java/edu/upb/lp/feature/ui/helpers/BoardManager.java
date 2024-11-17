
package edu.upb.lp.feature.ui.helpers;

import android.content.Context;
import android.widget.TableLayout;
import android.widget.TableRow;

import edu.upb.lp.core.util.UiUtils;
import edu.upb.lp.feature.ui.views.MyTextView;

public class BoardManager {
    private final Context context;
    private final TableLayout table;

    public BoardManager(Context context, TableLayout table) {
        this.context = context;
        this.table = table;
    }

    public void configureScreen(int numberOfRows, int numberOfColumns, int verticalSpacing, int horizontalSpacing, boolean vertical, double proportion) {
        table.removeAllViews();

        TableRow.LayoutParams normalCellParams = new TableRow.LayoutParams();
        normalCellParams.rightMargin = UiUtils.dpToPixel(context, horizontalSpacing);
        normalCellParams.height = TableRow.LayoutParams.MATCH_PARENT;
        normalCellParams.width = 0;
        normalCellParams.weight = 1;

        TableRow.LayoutParams rightmostCellParams = new TableRow.LayoutParams();
        rightmostCellParams.height = TableRow.LayoutParams.MATCH_PARENT;
        rightmostCellParams.width = 0;
        rightmostCellParams.weight = 1;

        TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams();
        rowParams.height = 0;
        rowParams.weight = 1;

        for (int j = 0; j < numberOfRows; j++) {
            TableRow row = new TableRow(context);
            row.setPadding(0, UiUtils.dpToPixel(context, verticalSpacing), 0, UiUtils.dpToPixel(context, verticalSpacing));
            row.setGravity(android.view.Gravity.CENTER);
            row.setLayoutParams(rowParams);
            for (int i = 0; i < numberOfColumns; i++) {
                MyTextView view = new MyTextView(context);
                view.setText("");
                view.setTextSize(20);
                view.setCoords(i, j);
                view.setGravity(android.view.Gravity.CENTER);
                view.setSoundEffectsEnabled(false);
                if (i < numberOfColumns - 1) {
                    view.setLayoutParams(normalCellParams);
                } else {
                    view.setLayoutParams(rightmostCellParams);
                }
                row.addView(view);
            }
            table.addView(row);
        }
    }
}
