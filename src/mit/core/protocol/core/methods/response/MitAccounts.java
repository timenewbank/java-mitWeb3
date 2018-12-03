package mit.core.protocol.core.methods.response;

import java.util.List;

import mit.core.protocol.core.Response;

/**
 * eth_accounts.
 */
public class MitAccounts extends Response<List<String>> {
    public List<String> getAccounts() {
        return getResult();
    }
}
