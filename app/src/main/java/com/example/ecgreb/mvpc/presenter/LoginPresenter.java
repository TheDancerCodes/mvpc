package com.example.ecgreb.mvpc.presenter;

import com.example.ecgreb.mvpc.controller.LoginController;
import com.example.ecgreb.mvpc.model.AccountValidator;

public class LoginPresenter {
  private LoginController loginController;
  private AccountValidator accountValidator;

  private static LoginPresenter instance = new LoginPresenter();

  public static LoginPresenter getInstance() {
    return instance;
  }

  private LoginPresenter() {
  }

  public LoginPresenter register(LoginController loginController) {
    this.loginController = loginController;
    if (accountValidator != null) {
      loginController.showProgress(accountValidator.isValidating());
    }
    return this;
  }

  public void onLoginButtonClick(String username, String password) {
    loginController.showProgress(true);
    accountValidator = new AccountValidator();
    accountValidator.validate(username, password, new AccountValidator.Callback() {
      @Override public void onValidationComplete(boolean success) {
        loginController.showProgress(false);
        if (success) {
          loginController.showSuccess();
        } else {
          loginController.showError();
        }
      }
    });
  }
}
