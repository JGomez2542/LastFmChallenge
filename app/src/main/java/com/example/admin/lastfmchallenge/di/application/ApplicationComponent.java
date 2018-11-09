package com.example.admin.lastfmchallenge.di.application;

import com.example.admin.lastfmchallenge.di.activity.ActivityComponent;
import com.example.admin.lastfmchallenge.di.activity.ActivityModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, LiveDataModule.class, FragmentModule.class})
public interface ApplicationComponent {

    ActivityComponent newActivityComponent(ActivityModule activityModule);
}
