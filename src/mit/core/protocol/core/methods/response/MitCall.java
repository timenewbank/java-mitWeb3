package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_call.
 */
public class MitCall extends Response<String> {
    public String getValue() {
        return getResult();
    }
}
