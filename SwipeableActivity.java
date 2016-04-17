package com.salve.salve;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
/**
 * Created by user on 4/17/2016.
 */
public class SwipeableActivity extends AppCompatActivity implements SwipeableLayout.SwipeBackListener {

    private SwipeableLayout SwipeableLayout;
    private ImageView ivShadow;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(getContainer());
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        SwipeableLayout.addView(view);
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(this);
        SwipeableLayout = new SwipeableLayout(this);
        SwipeableLayout.setOnSwipeBackListener(this);
        ivShadow = new ImageView(this);
        ivShadow.setBackgroundColor(getResources().getColor(R.color.black_p50));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(SwipeableLayout);
        return container;
    }

    public void setDragEdge(SwipeableLayout.DragEdge dragEdge) {
        SwipeableLayout.setDragEdge(dragEdge);
    }

    public SwipeableLayout getSwipeableLayout() {
        return SwipeableLayout;
    }

    @Override
    public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
        ivShadow.setAlpha(1 - fractionScreen);
    }

}
