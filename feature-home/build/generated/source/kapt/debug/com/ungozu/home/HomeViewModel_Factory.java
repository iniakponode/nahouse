package com.ungozu.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  @Override
  public HomeViewModel get() {
    return newInstance();
  }

  public static HomeViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HomeViewModel newInstance() {
    return new HomeViewModel();
  }

  private static final class InstanceHolder {
    private static final HomeViewModel_Factory INSTANCE = new HomeViewModel_Factory();
  }
}
