package com.ibrahim.managers;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.ibrahim.widgets.ShimmerLayout;

import java.util.HashMap;
import java.util.Map;

public class ShimmerViewManager extends ViewGroupManager<ShimmerLayout> {
    private static final String REACT_CLASS = "ReactNativeAndroidShimmer";

    private static final int COMMAND_START_SHIMMER_ANIMATION = 1;

    private static final int SHIMMER_MASK_SHAPE_LINEAR = 1;
    private static final int SHIMMER_MASK_SHAPE_RADIAL = 2;

    private static final int SHIMMER_MASK_ANGLE_CW_0 = 1;
    private static final int SHIMMER_MASK_ANGLE_CW_90 = 2;
    private static final int SHIMMER_MASK_ANGLE_CW_180 = 3;
    private static final int SHIMMER_MASK_ANGLE_CW_270 = 4;

    private static final int SHIMMER_REPEAT_MODE_INFINITE = 1;
    private static final int SHIMMER_REPEAT_MODE_RESTART = 2;
    private static final int SHIMMER_REPEAT_MODE_REVERSE = 3;

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  protected ShimmerLayout createViewInstance(ThemedReactContext reactContext) {
    ShimmerLayout container = new ShimmerLayout(reactContext);

    return container;
  }

  @Override
  public Map<String, Object> getExportedViewConstants() {
    final Map<String, Object> constants = new HashMap<>();

    constants.put("SHIMMER_MASK_SHAPE_LINEAR", SHIMMER_MASK_SHAPE_LINEAR);
    constants.put("SHIMMER_MASK_SHAPE_RADIAL", SHIMMER_MASK_SHAPE_RADIAL);

    constants.put("SHIMMER_MASK_ANGLE_CW_0", SHIMMER_MASK_ANGLE_CW_0);
    constants.put("SHIMMER_MASK_ANGLE_CW_90", SHIMMER_MASK_ANGLE_CW_90);
    constants.put("SHIMMER_MASK_ANGLE_CW_180", SHIMMER_MASK_ANGLE_CW_180);
    constants.put("SHIMMER_MASK_ANGLE_CW_270", SHIMMER_MASK_ANGLE_CW_270);

    constants.put("SHIMMER_REPEAT_MODE_INFINITE", SHIMMER_REPEAT_MODE_INFINITE);
    constants.put("SHIMMER_REPEAT_MODE_RESTART", SHIMMER_REPEAT_MODE_RESTART);
    constants.put("SHIMMER_REPEAT_MODE_REVERSE", SHIMMER_REPEAT_MODE_REVERSE);

    return constants;
  }

  @ReactProp(name = "baseAlpha")
  public void setBaseAlpha(ShimmerLayout shimmerLayout, @Nullable float baseAlpha) {
    shimmerLayout.setBaseAlpha(baseAlpha);
  }
  @ReactProp(name = "duration")
  public void setDuration(ShimmerLayout shimmerLayout, @Nullable int duration) {
    shimmerLayout.setDuration(duration);
  }
  @ReactProp(name = "dropoff")
  public void setDropoff(ShimmerLayout shimmerLayout, @Nullable float dropoff) {
    shimmerLayout.setDropoff(dropoff);
  }
  @ReactProp(name = "intensity")
  public void setIntensity(ShimmerLayout shimmerLayout, @Nullable float intensity) {
    shimmerLayout.setIntensity(intensity);
  }
  @ReactProp(name = "maskShape")
  public void setMaskShape(ShimmerLayout shimmerLayout, @Nullable int maskShape) {
    switch (maskShape) {
      case SHIMMER_MASK_SHAPE_LINEAR: {
        shimmerLayout.setMaskShape(ShimmerFrameLayout.MaskShape.LINEAR);
        return;
      }
      case SHIMMER_MASK_SHAPE_RADIAL: {
        shimmerLayout.setMaskShape(ShimmerFrameLayout.MaskShape.RADIAL);
        return;
      }
      default: {
        shimmerLayout.setMaskShape(ShimmerFrameLayout.MaskShape.RADIAL);
      }
    }
  }

  @ReactProp(name = "maskAngle")
  public void setAngle(ShimmerLayout shimmerLayout, @Nullable int maskAngle) {
    switch (maskAngle) {
      case SHIMMER_MASK_ANGLE_CW_0: {
        shimmerLayout.setAngle(ShimmerFrameLayout.MaskAngle.CW_0);
        return;
      }
      case SHIMMER_MASK_ANGLE_CW_90: {
        shimmerLayout.setAngle(ShimmerFrameLayout.MaskAngle.CW_90);
        return;
      }
      case SHIMMER_MASK_ANGLE_CW_180: {
        shimmerLayout.setAngle(ShimmerFrameLayout.MaskAngle.CW_180);
        return;
      }
      case SHIMMER_MASK_ANGLE_CW_270: {
        shimmerLayout.setAngle(ShimmerFrameLayout.MaskAngle.CW_270);
        return;
      }
      default: {
        shimmerLayout.setAngle(ShimmerFrameLayout.MaskAngle.CW_0);
      };
    }
  }

  @ReactProp(name = "tilt")
  public void setTilt(ShimmerLayout shimmerLayout, @Nullable float tilt) {
    shimmerLayout.setTilt(tilt);
  }

  @ReactProp(name = "repeatMode")
  public void setRepeatMode(ShimmerLayout shimmerLayout, @Nullable int repeatMode) {
    switch (repeatMode) {
      case SHIMMER_REPEAT_MODE_INFINITE: {
        shimmerLayout.setRepeatMode(ObjectAnimator.INFINITE);
        return;
      }
      case SHIMMER_REPEAT_MODE_RESTART: {
        shimmerLayout.setRepeatMode(ObjectAnimator.RESTART);
        return;
      }
      case SHIMMER_REPEAT_MODE_REVERSE: {
        shimmerLayout.setRepeatMode(ObjectAnimator.REVERSE);
        return;
      }
      default: {
        shimmerLayout.setRepeatMode(ObjectAnimator.INFINITE);
      }
    }
  }

  @Override
  public boolean needsCustomLayoutForChildren() {
    return true;
  }

  @Override
  public Map<String,Integer> getCommandsMap() {
    return MapBuilder.of(
            "startShimmerAnimation",
            COMMAND_START_SHIMMER_ANIMATION);
  }

  @Override
  public void receiveCommand(ShimmerLayout shimmerLayout, int commandType, @Nullable ReadableArray args) {
    Assertions.assertNotNull(shimmerLayout);
    Assertions.assertNotNull(args);
    switch (commandType) {
      case COMMAND_START_SHIMMER_ANIMATION: {
        shimmerLayout.startShimmerAnimation();
        return;
      }
      default:
        throw new IllegalArgumentException(String.format(
                "Unsupported command %d received by %s.",
                commandType,
                getClass().getSimpleName()));
    }
  }

  @Override
  public void addView(ShimmerLayout parent, View child, int index) {
      parent.addShimmerView(child, index);
  }
}