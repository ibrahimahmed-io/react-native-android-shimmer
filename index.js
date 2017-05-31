"use strict";

import React, {
    Component,
    PropTypes
} from 'react';

import {
    requireNativeComponent,
    View
} from 'react-native';

var ReactNative, {
    UIManager
} = require('react-native');

const ReactAndroidShimmerManager = UIManager.ReactNativeAndroidShimmer;
const Constants = ReactAndroidShimmerManager.Constants;

export default class AndroidShimmer extends Component {
    props: {
        baseAlpha ? : number,
        duration ? : number,
        dropoff ? : number,
        intensity ? : number,
        maskShape ? : number,
        maskAngle ? : number,
        tilt ? : number,
        repeatMode ? : number
    };

    static propTypes = {
        ...View.propTypes,
        baseAlpha: PropTypes.number,
        duration: PropTypes.number,
        dropoff: PropTypes.number,
        intensity: PropTypes.number,
        maskShape: PropTypes.number,
        maskAngle: PropTypes.number,
        tilt: PropTypes.number,
        repeatMode: PropTypes.number
    };

    startShimmerAnimation = () => {
        UIManager.dispatchViewManagerCommand(
            ReactNative.findNodeHandle(this),
            UIManager.ReactNativeAndroidShimmer.Commands.startShimmerAnimation
        );
    };

    render() {
        return (
            <RCTShimmerLayout
		        {...this.props}
		        style={this.props.style}>
		        {this.props.children}
		    </RCTShimmerLayout>
        );
    }
}

let RCTShimmerLayout = requireNativeComponent('ReactNativeAndroidShimmer', AndroidShimmer, {
    nativeOnly: {}
});

AndroidShimmer.SHIMMER_MASK_SHAPE_LINEAR = Constants.SHIMMER_MASK_SHAPE_LINEAR;
AndroidShimmer.SHIMMER_MASK_SHAPE_RADIAL = Constants.SHIMMER_MASK_SHAPE_RADIAL;

AndroidShimmer.SHIMMER_MASK_ANGLE_CW_0 = Constants.SHIMMER_MASK_ANGLE_CW_0;
AndroidShimmer.SHIMMER_MASK_ANGLE_CW_90 = Constants.SHIMMER_MASK_ANGLE_CW_90;
AndroidShimmer.SHIMMER_MASK_ANGLE_CW_180 = Constants.SHIMMER_MASK_ANGLE_CW_180;
AndroidShimmer.SHIMMER_MASK_ANGLE_CW_270 = Constants.SHIMMER_MASK_ANGLE_CW_270;

AndroidShimmer.SHIMMER_REPEAT_MODE_INFINITE = Constants.SHIMMER_REPEAT_MODE_INFINITE;
AndroidShimmer.SHIMMER_REPEAT_MODE_RESTART = Constants.SHIMMER_REPEAT_MODE_RESTART;
AndroidShimmer.SHIMMER_REPEAT_MODE_REVERSE = Constants.SHIMMER_REPEAT_MODE_REVERSE;

module.exports = AndroidShimmer;
