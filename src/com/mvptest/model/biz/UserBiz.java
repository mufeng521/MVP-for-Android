package com.mvptest.model.biz;

import com.mvptest.model.bean.UserBean;

public class UserBiz implements IUserBiz {

	@Override
	public void login(final String username, final String password,
			final OnLoginListener loginListener) {
		// ģ�����̺߳�ʱ����
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ģ���¼�ɹ�
				if ("mufeng".equals(username) && "123456".equals(password)) {
					UserBean user = new UserBean();
					user.setUsername(username);
					user.setPassword(password);
					loginListener.loginSuccess(user);
				} else {
					loginListener.loginFailed();
				}
			}
		}.start();
	}

}
