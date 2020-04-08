/*
 * Copyright 2015-2020 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.platform.launcher.core;

import org.junit.platform.engine.TestEngine;
import org.junit.platform.launcher.Launcher;

/**
 * @since 1.0
 */
public class LauncherFactoryForTestingPurposesOnly {

	public static Launcher createLauncher(TestEngine... engines) {
		return LauncherFactory.create(LauncherConfig.builder() //
				.enableTestEngineAutoRegistration(false) //
				.addTestEngines(engines) //
				.enableTestExecutionListenerAutoRegistration(false) //
				.build());
	}

}
