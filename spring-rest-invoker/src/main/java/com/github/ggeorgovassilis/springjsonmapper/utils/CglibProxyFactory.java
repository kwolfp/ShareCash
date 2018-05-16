package com.github.ggeorgovassilis.springjsonmapper.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;

/**
 * Implements opaque proxies with cglib
 * 
 * @author george georgovassilis
 *
 */
public class CglibProxyFactory implements ProxyFactory {

	protected Class<?> baseClass = Object.class;
	protected ClassLoader classLoader;

	@Override
	public Object createProxy(ClassLoader classLoader, final Class<?>[] interfaces,
			final InvocationHandler callback) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(baseClass);
		if (classLoader == null)
			classLoader = Thread.currentThread().getContextClassLoader();
		enhancer.setClassLoader(classLoader);
		enhancer.setCallback(new net.sf.cglib.proxy.InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return callback.invoke(proxy, method, args);
			}
		});
		enhancer.setInterfaces(interfaces);
		return enhancer.create();
	}

	@Override
	public void setProxyTargetClass(Class<?> c) {
		this.baseClass = c;
	}

	@Override
	public void setProxyTargetClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

}
