package com.lt.library.utils;

import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;

/**
 * NavigationView utils
 */

public class NavigationUtils {

    public static void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView
                    .getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }
}
