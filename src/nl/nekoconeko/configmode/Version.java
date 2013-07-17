/*
 * Copyright (c) 2013 Nick Douma < n . douma [at] nekoconeko . nl >
 *
 * This file is part of configmode.
 *
 * configmode is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * configmode is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with configmode. If not, see <http://www.gnu.org/licenses/>.
 */
package nl.nekoconeko.configmode;

public abstract class Version {
	/**
	 * Official name of the project
	 */
	public final String PROJECT_NAME = "configmode";
	/**
	 * Official release version of vcloud-login
	 */
	public final String RELEASE_VERSION = "0.0";
	/**
	 * Actual Git revision according to `git describe` during bumping
	 */
	public final String BUILD_VERSION = "000000";
}
