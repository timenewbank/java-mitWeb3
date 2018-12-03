package mit.gmit;

import rx.Observable;

import mit.core.protocol.Web3jService;
import mit.core.protocol.admin.Admin;
import mit.core.protocol.admin.methods.response.BooleanResponse;
import mit.core.protocol.admin.methods.response.PersonalSign;
import mit.core.protocol.core.Request;
import mit.core.protocol.core.methods.response.MinerStartResponse;
import mit.core.protocol.websocket.events.PendingTransactionNotification;
import mit.core.protocol.websocket.events.SyncingNotfication;
import mit.gmit.response.PersonalEcRecover;
import mit.gmit.response.PersonalImportRawKey;

/**
 * JSON-RPC Request object building factory for Geth. 
 */
public interface Gmit extends Admin {
    static Gmit build(Web3jService web3jService) {
        return new JsonRpc2_0Gmit(web3jService);
    }
        
    Request<?, PersonalImportRawKey> personalImportRawKey(String keydata, String password);

    Request<?, BooleanResponse> personalLockAccount(String accountId);
    
    Request<?, PersonalSign> personalSign(String message, String accountId, String password);
    
    Request<?, PersonalEcRecover> personalEcRecover(String message, String signiture);

    Request<?, MinerStartResponse> minerStart(int threadCount);

    Request<?, BooleanResponse> minerStop();

    /**
     * Creates an observable that emits a notification when a new transaction is added
     * to the pending state and is signed with a key that is available in the node.
     *
     * @return Observable that emits a notification when a new transaction is added
     *         to the pending state
     */
    Observable<PendingTransactionNotification> newPendingTransactionsNotifications();

    /**
     * Creates an observable that emits a notification when a node starts or stops syncing.
     * @return Observalbe that emits changes to syncing status
     */
    Observable<SyncingNotfication> syncingStatusNotifications();

}
