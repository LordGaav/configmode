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

import java.util.HashMap;
import java.util.Map;

public abstract class Configuration {

	private static Map<String, Object> configuration = new HashMap<String, Object>();

	protected static boolean has(String key) {
		return Configuration.configuration.containsKey(key);
	}

	protected static void set(String key, Object value) {
		Configuration.configuration.put(key, value);
	}

	protected static Object valueOrNull(String key) {
		if (Configuration.configuration.containsKey(key)) {
			return Configuration.configuration.get(key);
		} else {
			return null;
		}
	}

	public abstract String toString();

	public abstract String dumpToString();

	public abstract String dumpToString(String mode);

	public abstract String dumpToString(ConfigMode mode);
}
