package com.jwebmp.interception.services;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.Set;

@SuppressWarnings("Convert2Diamond")
public interface JWebMPInterceptionBinder
{
	Key<Set<AjaxCallIntercepter>> AjaxCallInterceptorKey = Key.get(new TypeLiteral<Set<AjaxCallIntercepter>>() {});
	Key<Set<DataCallIntercepter>> DataCallInterceptorKey = Key.get(new TypeLiteral<Set<DataCallIntercepter>>() {});
	Key<Set<SiteCallIntercepter>> SiteCallInterceptorKey = Key.get(new TypeLiteral<Set<SiteCallIntercepter>>() {});
}
