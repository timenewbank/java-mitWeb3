package mit.core.protocol.core.methods.response;

import java.util.List;

import mit.core.protocol.core.Response;

/**
 * eth_getCompilers.
 */
public class MitGetCompilers extends Response<List<String>> {
    public List<String> getCompilers() {
        return getResult();
    }
}
