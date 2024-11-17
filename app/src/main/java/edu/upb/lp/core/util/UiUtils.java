package edu.upb.lp.core.util;

import android.content.Context;
import android.util.DisplayMetrics;
import java.util.concurrent.atomic.AtomicInteger;

public class UiUtils {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int dpToPixel(Context context, int dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (dp * metrics.density);
    }

    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1;
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}