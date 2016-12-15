package com.whyalwaysmea.bigboom.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Long
 * on 2016/12/13.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife {
    String value() default "Application";
}
