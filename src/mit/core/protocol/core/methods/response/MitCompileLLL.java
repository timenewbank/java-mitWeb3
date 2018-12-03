package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_compileLLL.
 */
public class MitCompileLLL extends Response<String> {
    public String getCompiledSourceCode() {
        return getResult();
    }
}
