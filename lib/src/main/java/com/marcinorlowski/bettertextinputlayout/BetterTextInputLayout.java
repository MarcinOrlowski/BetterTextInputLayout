package com.marcinorlowski.bettertextinputlayout;

import android.content.Context;
import android.support.v7.widget.TintTypedArray;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 *  BetterTextInputLayout is subclass to TextInputLayout that exposes showPassword()/hidePassword()
 *  methods allowing to show/hide password from code.
 */

public class BetterTextInputLayout extends android.support.design.widget.TextInputLayout {

	public BetterTextInputLayout(Context context) {
		super(context, null);
	}

	public BetterTextInputLayout(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
	}

	public BetterTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		// Can't call through to super(Context, AttributeSet, int) since it doesn't exist on API 10
		super(context, attrs);

		final TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs,
				R.styleable.TextInputLayout, defStyleAttr, R.style.Widget_Design_TextInputLayout);

		setPasswordVisibilityToggleEnabled(a.getBoolean(R.styleable.TextInputLayout_passwordToggleEnabled, false));

		a.recycle();
	}


	/**
	 * Unveils password in underlying EditText (if it was hidden)
	 */
	public void showPassword() {
		EditText et = getEditText();

		if (et != null) {
			if (et.getTransformationMethod() instanceof PasswordTransformationMethod) {
				et.setTransformationMethod(null);
			}
		}
	}

	public void hidePassword() {
		EditText et = getEditText();
		if (et != null) {
			et.setTransformationMethod(new PasswordTransformationMethod());
		}
	}

}
