package com.mvptest.view;

import com.mvptest.R;
import com.mvptest.model.bean.UserBean;
import com.mvptest.presenter.UserLoginPresenter;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;

public class LoginActivity extends Activity implements IUserLoginView,
		OnClickListener {
	private EditText userNameEt, passwordEt;
	private Button loginBtn, clearBtn;
	private ProgressBar pb;

	private UserLoginPresenter userLoginPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		userLoginPresenter = new UserLoginPresenter(this);
		initWidget();
	}

	/**
	 * ³õÊ¼»¯¿Ø¼þ
	 */
	private void initWidget() {
		userNameEt = (EditText) findViewById(R.id.name_et);
		passwordEt = (EditText) findViewById(R.id.password_et);

		loginBtn = (Button) findViewById(R.id.login_btn);
		clearBtn = (Button) findViewById(R.id.clear_btn);

		pb = (ProgressBar) findViewById(R.id.pb);

		loginBtn.setOnClickListener(this);
		clearBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_btn:
			userLoginPresenter.login();
			break;
		case R.id.clear_btn:
			userLoginPresenter.clear();
			break;
		}
	}

	@Override
	public String getUserName() {
		return userNameEt.getText().toString().trim();
	}

	@Override
	public String getPassword() {
		return passwordEt.getText().toString().trim();
	}

	@Override
	public void clearUserName() {
		userNameEt.setText("");
	}

	@Override
	public void clearPassword() {
		passwordEt.setText("");
	}

	@Override
	public void showLoading() {
		pb.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoading() {
		pb.setVisibility(View.GONE);
	}

	@Override
	public void toMainActivity(UserBean userBean) {
		Toast.makeText(LoginActivity.this, userBean.getUsername(),
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void showFailedError() {
		Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
	}
}
