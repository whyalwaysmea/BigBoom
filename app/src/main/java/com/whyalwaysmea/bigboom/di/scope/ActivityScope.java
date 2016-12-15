package com.whyalwaysmea.bigboom.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Long
 * on 2016/12/13.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
