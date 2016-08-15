package domain.models.command.interfaces;

/**
 * Created by slavpetroff on 7/20/16.
 */
public interface Command {
    void execute(String... arguments);
}
