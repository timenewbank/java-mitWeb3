package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_protocolVersion.
 */
public class MitProtocolVersion extends Response<String> {
    public String getProtocolVersion() {
        return getResult();
    }
}
