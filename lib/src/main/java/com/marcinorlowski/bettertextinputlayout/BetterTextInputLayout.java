package com.marcinorlowski.bettertextinputlayout;

/**
 * BetterTextInputLayout Widget
 * <p>
 * BetterTextInputLayout is subclass of TextInputLayout that adds public methods to manipulate
 * password visibility of underlying EditText directly from code
 * <p>
 * Marcin Orlowski <mail{#}marcinorlowski.com>
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Method;

import androidx.appcompat.widget.TintTypedArray;

@SuppressLint ("RestrictedApi")
public class BetterTextInputLayout extends TextInputLayout {

	public BetterTextInputLayout(Context context) {
		super(context, null);
	}

	public BetterTextInputLayout(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
	}

	public BetterTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

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
		if ((et != null) && (callHasPasswordTransformation())) {
			et.setTransformationMethod(PasswordTransformationMethod.getInstance());
			passwordVisibilityToggleRequested(true);
		}
	}


	/**
	 * Masks EditText content (if it was visible)
	 */
	public void hidePassword() {
		EditText et = getEditText();
		if ((et != null) && (!callHasPasswordTransformation())) {
			et.setTransformationMethod(null);
			passwordVisibilityToggleRequested(true);
		}
	}

	/**
	 * Toggles visibility of EditText content
	 */
	public void togglePassword() {
		passwordVisibilityToggleRequested(true);
	}

	public boolean callHasPasswordTransformation() {
		boolean result = false;
		try {
			Method m = getClass().getSuperclass().getDeclaredMethod("hasPasswordTransformation", new Class<?>[] {});
			m.setAccessible(true);
			result = (boolean)m.invoke(this, (Object[])null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
