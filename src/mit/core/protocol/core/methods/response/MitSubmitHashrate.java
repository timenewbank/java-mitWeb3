package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_submitHashrate.
 */
public class MitSubmitHashrate extends Response<Boolean> {

    public boolean submissionSuccessful() {
        return getResult();
    }
}
