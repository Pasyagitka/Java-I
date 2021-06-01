package pasyagitka.command;

import org.apache.log4j.Logger;
import pasyagitka.command.commands.GoToAboutPageCommand;
import pasyagitka.command.commands.GoToMainPageCommand;

import java.util.EnumMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = Logger.getLogger(CommandProvider.class);

    private Map<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    public CommandProvider() {
        commands.put(CommandType.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
        commands.put(CommandType.GO_TO_ABOUT_PAGE, new GoToAboutPageCommand());
        //commands.put(CommandName.ADD_PRODUCT, new AddProduct());
    }

    /**
     * The method takeCommand taking command from map by {@link CommandType} key
     *
     * @param name {@link String} command name
     * @return {@link Command} from map
     */
    public Command takeCommand(String name) {
        CommandType commandName = null;
        try {
            commandName = CommandType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.info("Not correct command");
            commandName = CommandType.GO_TO_ERROR_PAGE;
        }
        return commands.get(commandName);
    }
}