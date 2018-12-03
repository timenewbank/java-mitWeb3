package mit.core.protocol.core.methods.response;

import mit.core.protocol.core.Response;

public class MitSubscribe extends Response<String> {
    public String getSubscriptionId() {
        return getResult();
    }
}
