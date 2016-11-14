package com.example.ecgreb.mvpc;

import com.example.ecgreb.mvpc.presenter.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class LoginModule {
  @Provides @Singleton LoginPresenter providerLoginPresenter() {
    return LoginPresenter.getInstance();
  }
}
