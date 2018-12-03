package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_uninstallFilter.
 */
public class MitUninstallFilter extends Response<Boolean> {
    public boolean isUninstalled() {
        return getResult();
    }
}
