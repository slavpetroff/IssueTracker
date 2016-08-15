package domain.exception;

import domain.controller.AccessDeniedController;

/**
 * Created by slavpetroff on 7/21/16.
 */
public class CustomAccessDeniedException extends RuntimeException {

    private AccessDeniedController controller = new AccessDeniedController();

    public CustomAccessDeniedException() {
        controller.processTheError();
    }
}
