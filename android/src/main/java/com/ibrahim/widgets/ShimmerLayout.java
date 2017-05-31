package com.ibrahim.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.ibrahim.reactandroidshimmer.R;

public class ShimmerLayout extends LinearLayout {
    private ShimmerFrameLayout shimmerViewContainer;

    public ShimmerLayout(Context context) {
        super(context);

        inflate(getContext(), R.layout.shimmer, this);

        shimmerViewContainer = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
    }

    public void setBaseAlpha(float baseAlpha) {
        shimmerViewContainer.setBaseAlpha(baseAlpha);
    }

    public void setDuration(int duration) {
        shimmerViewContainer.setDuration(duration);
    }

    public void setDropoff(float dropoff) {
        shimmerViewContainer.setDropoff(dropoff);
    }

    public void setIntensity(float intensity) {
        shimmerViewContainer.setIntensity(intensity);
    }

    public void setMaskShape(ShimmerFrameLayout.MaskShape maskShape) {
        shimmerViewContainer.setMaskShape(maskShape);
    }

    public void setAngle(ShimmerFrameLayout.MaskAngle maskAngle) {
        shimmerViewContainer.setAngle(maskAngle);
    }

    public void setTilt(float tilt) {
        shimmerViewContainer.setTilt(tilt);
    }

    public void setRepeatMode(int repeatMode) {
        shimmerViewContainer.setRepeatMode(repeatMode);
    }

    public void startShimmerAnimation() {
        shimmerViewContainer.startShimmerAnimation();
    }

    public void addShimmerView (View child, int index) {
        shimmerViewContainer.addView(child, index);

        startShimmerAnimation();
    }
}
