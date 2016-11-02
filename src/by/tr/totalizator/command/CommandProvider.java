package by.tr.totalizator.command;

import java.util.HashMap;
import java.util.Map;

import by.tr.totalizator.command.impl.GoToGeneralCommand;
import by.tr.totalizator.command.impl.GoToRegistrationCommand;
import by.tr.totalizator.command.impl.LocalizeCommand;
import by.tr.totalizator.command.impl.LoginCommand;
import by.tr.totalizator.command.impl.LogoutCommand;
import by.tr.totalizator.command.impl.RegisterUserCommand;
import by.tr.totalizator.command.impl.ShowCouponMatchesCommand;
import by.tr.totalizator.command.impl.UnknownCommand;

public final class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new LoginCommand());
		commands.put(CommandName.LOGOUT, new LogoutCommand());
		commands.put(CommandName.GO_TO_REGISTRATION, new GoToRegistrationCommand());
		commands.put(CommandName.REGISTRATION, new RegisterUserCommand());
		commands.put(CommandName.RU, new LocalizeCommand());
		commands.put(CommandName.EN, new LocalizeCommand());
		commands.put(CommandName.SHOW_COUPON_MATCHES, new ShowCouponMatchesCommand());
		commands.put(CommandName.GO_TO_GENERAL, new GoToGeneralCommand());
		commands.put(CommandName.UNKNOWN_COMMAND, new UnknownCommand());

	}

	public Command getCommand(String commandName) {
		Command command = null;
		CommandName key = CommandName.UNKNOWN_COMMAND;

		commandName = commandName.replace('-', '_').toUpperCase();

		CommandName[] cn = CommandName.values();

		for (CommandName c : cn) {
			if (commandName.equals(c.toString())) {
				key = CommandName.valueOf(commandName);
				break;
			}
		}

		command = commands.get(key);

		return command;
	}
}
