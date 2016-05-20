package com.mvptest.presenter;

import android.os.Handler;

import com.mvptest.model.bean.UserBean;
import com.mvptest.model.biz.IUserBiz;
import com.mvptest.model.biz.OnLoginListener;
import com.mvptest.model.biz.UserBiz;
import com.mvptest.view.IUserLoginView;

public class UserLoginPresenter {

	private IUserBiz userBiz;
	private IUserLoginView userLoginView;
	private Handler mHandler = new Handler();

	public UserLoginPresenter(IUserLoginView userLoginView) {
		this.userLoginView = userLoginView;
		userBiz = new UserBiz();
	}

	public void login() {
		userLoginView.showLoading();

		userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(),
				new OnLoginListener() {

					@Override
					public void loginSuccess(final UserBean userBean) {
						mHandler.post(new Runnable() {

							@Override
							public void run() {
								userLoginView.toMainActivity(userBean);
								userLoginView.hideLoading();
							}
						});
					}

					@Override
					public void loginFailed() {
						mHandler.post(new Runnable() {

							@Override
							public void run() {
								userLoginView.showFailedError();
								userLoginView.hideLoading();
							}
						});

					}
				});
	}

	public void clear() {
		userLoginView.clearUserName();
		userLoginView.clearPassword();
	}
}
