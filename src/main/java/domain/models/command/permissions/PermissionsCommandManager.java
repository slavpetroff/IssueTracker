package domain.models.command.permissions;

import domain.models.command.interfaces.Command;

/**
 * Created by slavpetroff on 7/20/16.
 */
public class PermissionsCommandManager implements domain.models.command.interfaces.CommandManager {

    private Command command;

    public PermissionsCommandManager(Command command) {
        this.setCommand(command);
    }

    public Command getCommand() {
        return command;
    }

    private void setCommand(Command command) {
        this.command = command;
    }
}
