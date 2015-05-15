package com.offroader.ioc.annotation.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import android.view.View;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OREventBase(listenerType = View.OnKeyListener.class, listenerSetter = "setOnKeyListener", methodName = "onKey")
public @interface OROnKey {
	int[] value();
}
