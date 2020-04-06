package com.warkiz.widget;

import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;

class AppPopupWindowCompat {

    static void showAsDropDown(
            PopupWindow window, final View anchor, int xoff, int yoff) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            window.showAsDropDown(anchor, xoff, yoff);
            return;
        }

        View view = new View(anchor.getContext()) {
            @Override
            public IBinder getWindowToken() {
                return getApplicationWindowToken();
            }

            @Override
            public void getLocationOnScreen(int[] outLocation) {
                anchor.getLocationOnScreen(outLocation);
            }
        };
        window.showAsDropDown(view, xoff, yoff);
    }


}
