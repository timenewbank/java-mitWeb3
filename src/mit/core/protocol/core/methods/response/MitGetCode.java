package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_getCode.
 */
public class MitGetCode extends Response<String> {
    public String getCode() {
        return getResult();
    }
}
