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
import nl.nekoconeko.configmode.Version;
import org.apache.commons.cli.HelpFormatter;

public class ConfigModes {

	protected static Map<String, ConfigMode> modeMap = new HashMap<String, ConfigMode>();
	protected static Version version;

	protected static void addMode(String type, ConfigMode mode) {
		ConfigModes.getModes().put(type, mode);
	}
	
	protected static void addModes(Map<String, ConfigMode> modes) {
		for (String type : modes.keySet()) {
			ConfigModes.addMode(type, modes.get(type));
		}
	}

	protected static void removeMode(String type) {
		ConfigModes.getModes().remove(type);
	}

	protected static void setVersionInfo(Version version) {
		ConfigModes.version = version;
	}

	public static ConfigMode getMode(String mode) {
		return ConfigModes.modeMap.get(mode);
	}

	public static Map<String, ConfigMode> getModes() {
		return ConfigModes.modeMap;
	}

	public static ConfigMode getConsolidatedModes() {
		ConfigMode all = new ConfigMode();

		for (ConfigMode mode : ConfigModes.modeMap.values()) {
			for (ConfigParameter opt : mode.getAllOptions()) {
				opt.setRequired(false);
				all.addOption(opt);
			}
		}

		return all;
	}

	public static void printAllHelp() {
		HelpFormatter format = new HelpFormatter();

		for (String mode : ConfigModes.getModes().keySet()) {
			format.setSyntaxPrefix(String.format("%s mode: ", mode.toString()));
			format.printHelp(ConfigModes.version.PROJECT_NAME, ConfigModes.getMode(mode), true);
		}
	}

	public static void printConfigModeHelp(String mode) {
		HelpFormatter format = new HelpFormatter();
		if (mode.equalsIgnoreCase("root")) {
			format.setSyntaxPrefix(String.format("Usage for %s mode: ", mode.toString()));
		}
		format.printHelp(ConfigModes.version.PROJECT_NAME, ConfigModes.getMode(mode), true);
	}
}
