package domain.models.command;

import domain.models.command.interfaces.Command;

/**
 * Created by slavpetroff on 7/20/16.
 */
public abstract class AbstractCommand implements Command {

    private String[] arguments;

    protected AbstractCommand(String... arguments) {
        this.setArguments(arguments);
    }

    protected String[] getArguments() {
        return arguments;
    }

    protected void setArguments(String... arguments) {
        this.arguments = arguments;
    }

    @Override
    public abstract void execute(String... arguments);
}
