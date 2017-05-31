# react-native-android-shimmer

Simple shimmering effect for android in React Native. Based on <a href="https://github.com/facebook/shimmer-android">Shimmer</a>.

<img src="https://raw.githubusercontent.com/facebook/shimmer-android/master/shimmer.gif" alt="Shimmer" style="max-width:100%;">

# Installation

<code>$ yarn add react-native-android-shimmer</code>

### Option: Manually

* Edit `android/settings.gradle` to look like this (without the +):

  ```diff
  rootProject.name = 'MyApp'

  include ':app'

  + include ':react-native-android-shimmer'
  + project(':react-native-android-shimmer').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-shimmer/android')
  ```

* Edit `android/app/build.gradle` (note: **app** folder) to look like this: 

  ```diff
  apply plugin: 'com.android.application'

  android {
    ...
  }

  dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile "com.android.support:appcompat-v7:23.0.1"
    compile "com.facebook.react:react-native:+"  // From node_modules
  + compile project(':react-native-android-shimmer')
  }
  ```

* Edit your `MainApplication.java` (deep in `android/app/src/main/java/...`) to look like this (note **two** places to edit):

  ```diff
  package com.myapp;

  + import com.ibrahim.ReactAndroidShimmerPackage;

  ....

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
        new MainReactPackage()
  +   , new ReactAndroidShimmerPackage()
      );
    }

  }
  ```

# Usage

NOTE: <code>Shimmer</code> may only have one child and currently doesn't work with <code>View</code>.

```javascript
import AndroidShimmer from 'react-native-android-shimmer';

<AndroidShimmer
  baseAlpha={0.5}
  duration={2000}>
  <Text>Loading...</Text>
</AndroidShimmer>
```

# Properties

<table>
<thead>
<tr>
<th>Prop</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td><strong><code>baseAlpha</code></strong></td>
<td>Alpha used to render the base view i.e. the unhighlighted view over which the highlight is drawn.</td>
</tr>
<tr>
<td><strong><code>duration</code></strong></td>
<td>Time it takes for the highlight to move from one end of the layout to the other.</td>
</tr>
<tr>
<td><strong><code>dropoff</code></strong></td>
<td>Controls the size of the fading edge of the highlight.</td>
</tr>
<tr>
<tr>
<td><strong><code>intensity</code></strong></td>
<td>Controls the brightness of the highlight at the center.</td>
</tr>
<tr>
<tr>
<td><strong><code>maskShape</code></strong></td>
<td>Shape of the highlight mask, either with a linear or a circular gradient.</td>
</tr>
<tr>
<tr>
<td><strong><code>maskAngle</code></strong></td>
<td>Angle at which the highlight mask is animated, from left-to-right, top-to-bottom etc.</td>
</tr>
<tr>
<tr>
<td><strong><code>tilt</code></strong></td>
<td>Angle at which the highlight is tilted, measured in degrees.</td>
</tr>
<tr>
<tr>
<td><strong><code>repeatMode</code></strong></td>
<td>What the animation should do after reaching the end, either restart from the beginning or reverse back towards it.</td>
</tr>
<tr></tbody></table>

# License

<a href="http://opensource.org/licenses/mit-license.html">MIT License</a>. Shimmer is under BSD license. © Ibrahim Ahmed 2017-now
