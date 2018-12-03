package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

/**
 * db_putHex.
 */
public class DbPutHex extends Response<Boolean> {

    public boolean valueStored() {
        return getResult();
    }
}
