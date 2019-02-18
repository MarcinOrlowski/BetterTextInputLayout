BetterTextInputLayout
=====================
 `BetterTextInputLayout` is Android's Jetpack library's `TextInputLayout` subclass
 providing following extensions:

 * adds methods to manipulate password visibility from code,
 * comes with `passwordToggleEnabled` enabled by default.

Methods
=======
 * `showPassword()`
 * `hidePassword()`
 * `togglePassword()`

 Names should be pretty self-explanatory :) See demo app for usage example though.

Installation
============

 Edit your master `gradle.build` file and **add** `maven { url 'https://jitpack.io' }` to your current
 `repositories` block content (if you use other jitpack hosted libraries, then this step can be skipped):

    allprojects {
      repositories {
        maven { url 'https://jitpack.io' }
        }
    }

 Next, edit your **module**'s `build.gradle` and the following dependency:

    compile 'com.github.MarcinOrlowski:bettertextinputlayout:<VERSION>'

 For recent value of `<VERSION>` consult [library releases](https://github.com/MarcinOrlowski/bettertextinputlayout/releases)
 or jitpack badge: [![Release](https://jitpack.io/v/MarcinOrlowski/bettertextinputlayout.svg)](https://jitpack.io/#MarcinOrlowski/bettertextinputlayout)


Author
======
 * Marcin Orlowski <mail(#)marcinOrlowski.com>

