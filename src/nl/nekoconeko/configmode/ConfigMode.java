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


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ConfigMode extends Options {
	private static final long serialVersionUID = 843228816664013345L;

	public ConfigMode() {
		super();
	}

	public void addRequiredOption(Option opt) {
		opt.setRequired(true);
		this.addOption(opt);
	}

	public void addRequiredOptions(List<? extends Option> opts) {
		for (Option option : opts) {
			this.addRequiredOption(option);
		}
	}

	public List<Option> getAllOptions() {
		List<Option> all = new ArrayList<Option>(this.getOptions().size());

		for (Object item : this.getOptions()) {
			all.add((Option) item);
		}

		return all;
	}

	public void addOptions(List<? extends Option> options) {
		for (Option opt : options) {
			this.addOption(opt);
		}
	}
}
