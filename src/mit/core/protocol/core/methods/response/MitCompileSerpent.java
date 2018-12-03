package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * eth_compileSerpent.
 */
public class MitCompileSerpent extends Response<String> {
    public String getCompiledSourceCode() {
        return getResult();
    }
}
