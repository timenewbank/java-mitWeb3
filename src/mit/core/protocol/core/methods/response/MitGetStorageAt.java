package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_getStorageAt.
 */
public class MitGetStorageAt extends Response<String> {
    public String getData() {
        return getResult();
    }
}
