package com.mvptest.view;

import com.mvptest.model.bean.UserBean;

public interface IUserLoginView {
	String getUserName();

	String getPassword();

	void clearUserName();

	void clearPassword();

	void showLoading();

	void hideLoading();

	void toMainActivity(UserBean userBean);

	void showFailedError();

}
