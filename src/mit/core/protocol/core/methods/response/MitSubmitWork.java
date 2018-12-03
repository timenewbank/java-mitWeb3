package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_submitWork.
 */
public class MitSubmitWork extends Response<Boolean> {

    public boolean solutionValid() {
        return getResult();
    }
}
