configmode - trying to make CLI argument parsing in Java a bit easier
---------------------------------------------------------------------

configmode is built upon the excellent Apache Commons CLI parser. I felt that this library was missing some kind of central definition of modes and relevant options, so I tried to extend it. It's probably not perfect, but it has suited me fine for all my Java CLI tools up until now.

Howto
-----

Create a new CLI parser for your Java project in a few easy steps:

* Extend nl.nekoconeko.configmode.Version, change the values, override the getters  and implement a getVersion().
* Extend nl.nekoconeko.configmode.ConfigModes, and implement a static constructor to set the various ConfigParameter and ConfigMode's:

```java
	static {
		// Set version information
		ConfigModes.setVersionInfo(Version.getVersion());

		// Define the various short and long options
		ConfigParameter config = new ConfigParameter("c", "config", true, "FILE", "Use a configuration file");
		ConfigParameter helpmode = new ConfigParameter("h", "help", true, "COMMAND", "Show help and examples");
		helpmode.setOptionalArg(true);
		ConfigParameter versionmode = new ConfigParameter("v", "version", false, "Show version information");
		...

		// Group all the mode selectors into a single OptionGroup
		OptionGroup modes = new OptionGroup();
		modes.setRequired(true);
		modes.addOption(helpmode);
		modes.addOption(versionmode);
		...

		// An OptionGroup is a mutually exclusive group of options, in this case a form of mode selector
		OptionGroup modes = new OptionGroup();
		modes.addOption(helpmode);
		modes.addOption(versionmode);

		// The 'ROOT' ConfigMode is the default mode when no mode is selected
		ConfigMode root = new ConfigMode();
		root.addOptionGroup(modes);

		// Define various other ConfigMode's and their ConfigParameters
		ConfigMode help = new ConfigMode();
		help.addRequiredOption(helpmode);

		ConfigMode version = new ConfigMode();
		version.addRequiredOption(versionmode);

		// Register the various ConfigModes globally, and give them identifiers
		ConfigModes.addMode("ROOT", root);
		ConfigModes.addMode("HELP", help);
		ConfigModes.addMode("VERSION", version);
	}
```

* Extend nl.nekoconeko.configmode.Configuration, and add methods to parse your flavour of config file
* Use `ConfigModes.getMode(string)` and `IgnorePosixParser.parse(mode, args)` to validate your input against the selected ConfigMode

Checkout https://github.com/Cysource/vsphere-client for a project that uses ConfigModes

License
-------

configmode is licensed under GPLv3.
