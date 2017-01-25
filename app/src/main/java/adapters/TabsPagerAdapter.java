package adapters;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Riyan on 9/21/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                //return new GoingFragment();
            case 1:
                // Games fragment activity
                //return new FollowingFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}