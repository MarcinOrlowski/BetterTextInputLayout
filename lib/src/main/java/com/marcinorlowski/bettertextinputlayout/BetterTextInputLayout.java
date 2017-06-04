package com.marcinorlowski.bettertextinputlayout;

/**
 * BetterTextInputLayout Widget
 *
 * BetterTextInputLayout is subclass of TextInputLayout that adds public methods to manipulate
 * password visibility of underlying EditText directly from code
 *
 * Marcin Orlowski <mail{#}marcinorlowski.com>
 */

import android.content.Context;
import android.support.design.widget.CheckableImageButton;
import android.support.v7.widget.TintTypedArray;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
				setToggleState(true);
			}
		}
	}

	/**
	 * Masks EditText content (if it was visible)
	 */
	public void hidePassword() {
		EditText et = getEditText();
		if (et != null) {
			et.setTransformationMethod(new PasswordTransformationMethod());
			setToggleState(false);
		}
	}

	/**
	 * Toggles visibility of EditText content
	 */
	public void togglePassword() {
		try {
			Method m = this.getClass().getSuperclass().getDeclaredMethod("passwordVisibilityToggleRequested");
			m.setAccessible(true);
			m.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updated the state of password visibility toggle
	 *
	 * @param passwordVisible
	 */
	protected void setToggleState(boolean passwordVisible) {
		try {
			Field f = this.getClass().getSuperclass().getDeclaredField("mPasswordToggleView");
			f.setAccessible(true);
			CheckableImageButton b = (CheckableImageButton)f.get(this);
			b.setChecked(passwordVisible);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
