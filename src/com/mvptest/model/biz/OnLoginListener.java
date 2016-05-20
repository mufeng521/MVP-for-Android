package com.mvptest.model.biz;

import com.mvptest.model.bean.UserBean;

public interface OnLoginListener {

	void loginSuccess(UserBean userBean);

	void loginFailed();

}
