package com.marcinorlowski.bettertextinputlayout.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.marcinorlowski.bettertextinputlayout.BetterTextInputLayout;
import com.marcinorlowski.bettertextinputlayout.demo.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.show).setOnClickListener(clickListener);
		findViewById(R.id.hide).setOnClickListener(clickListener);
	}

	protected View.OnClickListener clickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.show:
					((BetterTextInputLayout)findViewById(R.id.til)).showPassword();
					break;

				case R.id.hide:
					((BetterTextInputLayout)findViewById(R.id.til)).hidePassword();
					break;
			}
		}
	};
}
