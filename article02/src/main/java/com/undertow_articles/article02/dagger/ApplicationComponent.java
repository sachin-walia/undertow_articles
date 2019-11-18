package com.undertow_articles.article02.dagger;

import com.undertow_articles.article02.handler.HealthHandler;
import dagger.Component;
import dagger.Module;

import javax.inject.Singleton;

/**
 * Created by Sachin Walia on 11/17/19.
 */
@Singleton
@Component(modules = {WebModule.class})
public interface ApplicationComponent {

    HealthHandler healthHandler();

}
