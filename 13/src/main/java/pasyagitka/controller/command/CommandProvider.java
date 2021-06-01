package pasyagitka.controller.command;

import org.apache.log4j.Logger;
import pasyagitka.controller.command.implementation.gotopage.GoToAboutPage;
import pasyagitka.controller.command.implementation.gotopage.GoToMainPage;

import java.util.EnumMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = Logger.getLogger(CommandProvider.class);

    private Map<CommandName, Command> commands = new EnumMap<>(CommandName.class);

    public CommandProvider() {
        commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
        commands.put(CommandName.GO_TO_ABOUT_PAGE, new GoToAboutPage());
        //commands.put(CommandName.ADD_PRODUCT, new AddProduct());
    }

    /**
     * The method takeCommand taking command from map by {@link CommandName} key
     *
     * @param name {@link String} command name
     * @return {@link Command} from map
     */
    public Command takeCommand(String name) {
        CommandName commandName = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.info("Not correct command");
            commandName = CommandName.GO_TO_ERROR_PAGE;
        }
        return commands.get(commandName);
    }
}