package org.wirvscvirus.expertexchange.service.boot.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author bahlef
 */
public class SessionListener implements HttpSessionListener {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// session timeout = 12h
		event.getSession().setMaxInactiveInterval(12 * 60 * 60);
	}
}
