package mit.gmit;

import java.util.Arrays;
import java.util.Collections;

import rx.Observable;

import mit.core.protocol.Web3jService;
import mit.core.protocol.admin.JsonRpc2_0Admin;
import mit.core.protocol.admin.methods.response.BooleanResponse;
import mit.core.protocol.admin.methods.response.PersonalSign;
import mit.core.protocol.core.Request;
import mit.core.protocol.core.methods.response.MitSubscribe;
import mit.core.protocol.core.methods.response.MinerStartResponse;
import mit.core.protocol.websocket.events.PendingTransactionNotification;
import mit.core.protocol.websocket.events.SyncingNotfication;
import mit.gmit.response.PersonalEcRecover;
import mit.gmit.response.PersonalImportRawKey;

/**
 * JSON-RPC 2.0 factory implementation for Geth.
 */
public class JsonRpc2_0Gmit extends JsonRpc2_0Admin implements Gmit {

    public JsonRpc2_0Gmit(Web3jService web3jService) {
        super(web3jService);
    }
    
    @Override
    public Request<?, PersonalImportRawKey> personalImportRawKey(
            String keydata, String password) {
        return new Request<>(
                "personal_importRawKey",
                Arrays.asList(keydata, password),
                web3jService,
                PersonalImportRawKey.class);
    }

    @Override
    public Request<?, BooleanResponse> personalLockAccount(String accountId) {
        return new Request<>(
                "personal_lockAccount",
                Arrays.asList(accountId),
                web3jService,
                BooleanResponse.class);
    }

    @Override
    public Request<?, PersonalSign> personalSign(
            String message, String accountId, String password) {
        return new Request<>(
                "personal_sign",
                Arrays.asList(message,accountId,password),
                web3jService,
                PersonalSign.class);
    }

    @Override
    public Request<?, PersonalEcRecover> personalEcRecover(
            String hexMessage, String signedMessage) {
        return new Request<>(
                "personal_ecRecover",
                Arrays.asList(hexMessage,signedMessage),
                web3jService,
                PersonalEcRecover.class);
    }

    @Override
    public Request<?, MinerStartResponse> minerStart(int threadCount) {
        return new Request<>(
                "miner_start",
                Arrays.asList(threadCount),
                web3jService,
                MinerStartResponse.class);
    }

    @Override
    public Request<?, BooleanResponse> minerStop() {
        return new Request<>(
                "miner_stop",
                Collections.<String>emptyList(),
                web3jService,
                BooleanResponse.class);
    }

    public Observable<PendingTransactionNotification> newPendingTransactionsNotifications() {
        return web3jService.subscribe(
                new Request<>(
                        "mit_subscribe",
                        Arrays.asList("newPendingTransactions"),
                        web3jService,
                        MitSubscribe.class),
                "mit_unsubscribe",
                PendingTransactionNotification.class
        );
    }

    @Override
    public Observable<SyncingNotfication> syncingStatusNotifications() {
        return web3jService.subscribe(
                new Request<>(
                        "mit_subscribe",
                        Arrays.asList("syncing"),
                        web3jService,
                        MitSubscribe.class),
                "mit_unsubscribe",
                SyncingNotfication.class
        );
    }
}
