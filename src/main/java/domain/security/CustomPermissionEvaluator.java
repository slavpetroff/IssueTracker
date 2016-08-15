package domain.security;

import domain.models.command.permissions.PermissionsCommandManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by slavpetroff on 7/20/16.
 */
@Component
@ComponentScan(basePackageClasses = PermissionsCommandManager.class)
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object domainObject, Object permission) {
        String[] permissions = (String[]) permission;

        switch (permissions[0]) {
            case "single":
                break;
            case "collection":
                break;
            default:
                return false;
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object perm) {
        return false;
    }
}

