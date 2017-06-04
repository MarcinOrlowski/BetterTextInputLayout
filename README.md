BetterTextInputLayout
=====================
`BetterTextInputLayout` is Android support library's `TextInputLayout` subclass
providing following extensions:

 * exposes methods to show and hide passwords from code
 * `passwordToggleEnabled` is enabled by default

Methods
=======
 * `showPassword()`
 * `hidePassword()`


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


Bugs
====
 * calling `showPassword()` and `hidePassword()` does not affect state of the toggle button.

Author
======
 * Marcin Orlowski <mail(#)marcinorlowski.com>

