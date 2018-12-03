package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_sign.
 */
public class MitSign extends Response<String> {
    public String getSignature() {
        return getResult();
    }
}
