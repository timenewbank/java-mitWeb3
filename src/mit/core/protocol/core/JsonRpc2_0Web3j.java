package mit.core.protocol.core;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import rx.Observable;

import mit.core.protocol.Web3j;
import mit.core.protocol.Web3jService;
import mit.core.protocol.core.methods.request.ShhFilter;
import mit.core.protocol.core.methods.request.ShhPost;
import mit.core.protocol.core.methods.request.Transaction;
import mit.core.protocol.core.methods.response.DbGetHex;
import mit.core.protocol.core.methods.response.DbGetString;
import mit.core.protocol.core.methods.response.DbPutHex;
import mit.core.protocol.core.methods.response.DbPutString;
import mit.core.protocol.core.methods.response.MitAccounts;
import mit.core.protocol.core.methods.response.MitBlock;
import mit.core.protocol.core.methods.response.MitBlockNumber;
import mit.core.protocol.core.methods.response.MitCoinbase;
import mit.core.protocol.core.methods.response.MitCompileLLL;
import mit.core.protocol.core.methods.response.MitCompileSerpent;
import mit.core.protocol.core.methods.response.MitCompileSolidity;
import mit.core.protocol.core.methods.response.MitEstimateGas;
import mit.core.protocol.core.methods.response.MitFilter;
import mit.core.protocol.core.methods.response.MitGasPrice;
import mit.core.protocol.core.methods.response.MitGetBalance;
import mit.core.protocol.core.methods.response.MitGetBlockTransactionCountByHash;
import mit.core.protocol.core.methods.response.MitGetBlockTransactionCountByNumber;
import mit.core.protocol.core.methods.response.MitGetCode;
import mit.core.protocol.core.methods.response.MitGetCompilers;
import mit.core.protocol.core.methods.response.MitGetStorageAt;
import mit.core.protocol.core.methods.response.MitGetTransactionCount;
import mit.core.protocol.core.methods.response.MitGetTransactionReceipt;
import mit.core.protocol.core.methods.response.MitGetUncleCountByBlockHash;
import mit.core.protocol.core.methods.response.MitGetUncleCountByBlockNumber;
import mit.core.protocol.core.methods.response.MitGetWork;
import mit.core.protocol.core.methods.response.MitHashrate;
import mit.core.protocol.core.methods.response.MitLog;
import mit.core.protocol.core.methods.response.MitMining;
import mit.core.protocol.core.methods.response.MitSign;
import mit.core.protocol.core.methods.response.MitSubmitHashrate;
import mit.core.protocol.core.methods.response.MitSubmitWork;
import mit.core.protocol.core.methods.response.MitSubscribe;
import mit.core.protocol.core.methods.response.MitSyncing;
import mit.core.protocol.core.methods.response.MitTransaction;
import mit.core.protocol.core.methods.response.MitUninstallFilter;
import mit.core.protocol.core.methods.response.Log;
import mit.core.protocol.core.methods.response.MitProtocolVersion;
import mit.core.protocol.core.methods.response.NetListening;
import mit.core.protocol.core.methods.response.NetPeerCount;
import mit.core.protocol.core.methods.response.NetVersion;
import mit.core.protocol.core.methods.response.ShhAddToGroup;
import mit.core.protocol.core.methods.response.ShhHasIdentity;
import mit.core.protocol.core.methods.response.ShhMessages;
import mit.core.protocol.core.methods.response.ShhNewFilter;
import mit.core.protocol.core.methods.response.ShhNewGroup;
import mit.core.protocol.core.methods.response.ShhNewIdentity;
import mit.core.protocol.core.methods.response.ShhUninstallFilter;
import mit.core.protocol.core.methods.response.ShhVersion;
import mit.core.protocol.core.methods.response.Web3ClientVersion;
import mit.core.protocol.core.methods.response.Web3Sha3;
import mit.core.protocol.rx.JsonRpc2_0Rx;
import mit.core.protocol.websocket.events.LogNotification;
import mit.core.protocol.websocket.events.NewHeadsNotification;
import mit.core.utils.Async;
import mit.utils.Numeric;

/**
 * JSON-RPC 2.0 factory implementation.
 */
public class JsonRpc2_0Web3j implements Web3j {

    public static final int DEFAULT_BLOCK_TIME = 15 * 1000;

    protected final Web3jService web3jService;
    private final JsonRpc2_0Rx web3jRx;
    private final long blockTime;
    private final ScheduledExecutorService scheduledExecutorService;

    public JsonRpc2_0Web3j(Web3jService web3jService) {
        this(web3jService, DEFAULT_BLOCK_TIME, Async.defaultExecutorService());
    }

    public JsonRpc2_0Web3j(
            Web3jService web3jService, long pollingInterval,
            ScheduledExecutorService scheduledExecutorService) {
        this.web3jService = web3jService;
        this.web3jRx = new JsonRpc2_0Rx(this, scheduledExecutorService);
        this.blockTime = pollingInterval;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    @Override
    public Request<?, Web3ClientVersion> web3ClientVersion() {
        return new Request<>(
                "web3_clientVersion",
                Collections.<String>emptyList(),
                web3jService,
                Web3ClientVersion.class);
    }

    @Override
    public Request<?, Web3Sha3> web3Sha3(String data) {
        return new Request<>(
                "web3_sha3",
                Arrays.asList(data),
                web3jService,
                Web3Sha3.class);
    }

    @Override
    public Request<?, NetVersion> netVersion() {
        return new Request<>(
                "net_version",
                Collections.<String>emptyList(),
                web3jService,
                NetVersion.class);
    }

    @Override
    public Request<?, NetListening> netListening() {
        return new Request<>(
                "net_listening",
                Collections.<String>emptyList(),
                web3jService,
                NetListening.class);
    }

    @Override
    public Request<?, NetPeerCount> netPeerCount() {
        return new Request<>(
                "net_peerCount",
                Collections.<String>emptyList(),
                web3jService,
                NetPeerCount.class);
    }

    @Override
    public Request<?, MitProtocolVersion> mitProtocolVersion() {
        return new Request<>(
                "mit_protocolVersion",
                Collections.<String>emptyList(),
                web3jService,
                MitProtocolVersion.class);
    }

    @Override
    public Request<?, MitCoinbase> mitCoinbase() {
        return new Request<>(
                "mit_coinbase",
                Collections.<String>emptyList(),
                web3jService,
                MitCoinbase.class);
    }

    @Override
    public Request<?, MitSyncing> mitSyncing() {
        return new Request<>(
                "mit_syncing",
                Collections.<String>emptyList(),
                web3jService,
                MitSyncing.class);
    }

    @Override
    public Request<?, MitMining> mitMining() {
        return new Request<>(
                "mit_mining",
                Collections.<String>emptyList(),
                web3jService,
                MitMining.class);
    }

    @Override
    public Request<?, MitHashrate> mitHashrate() {
        return new Request<>(
                "mit_hashrate",
                Collections.<String>emptyList(),
                web3jService,
                MitHashrate.class);
    }

    @Override
    public Request<?, MitGasPrice> mitGasPrice() {
        return new Request<>(
                "mit_gasPrice",
                Collections.<String>emptyList(),
                web3jService,
                MitGasPrice.class);
    }

    @Override
    public Request<?, MitAccounts> mitAccounts() {
        return new Request<>(
                "mit_accounts",
                Collections.<String>emptyList(),
                web3jService,
                MitAccounts.class);
    }

    @Override
    public Request<?, MitBlockNumber> mitBlockNumber() {
        return new Request<>(
                "mit_blockNumber",
                Collections.<String>emptyList(),
                web3jService,
                MitBlockNumber.class);
    }

    @Override
    public Request<?, MitGetBalance> mitGetBalance(
            String address, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_getBalance",
                Arrays.asList(address, defaultBlockParameter.getValue()),
                web3jService,
                MitGetBalance.class);
    }

    @Override
    public Request<?, MitGetStorageAt> mitGetStorageAt(
            String address, BigInteger position, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_getStorageAt",
                Arrays.asList(
                        address,
                        Numeric.encodeQuantity(position),
                        defaultBlockParameter.getValue()),
                web3jService,
                MitGetStorageAt.class);
    }

    @Override
    public Request<?, MitGetTransactionCount> mitGetTransactionCount(
            String address, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_getTransactionCount",
                Arrays.asList(address, defaultBlockParameter.getValue()),
                web3jService,
                MitGetTransactionCount.class);
    }

    @Override
    public Request<?, MitGetBlockTransactionCountByHash> mitGetBlockTransactionCountByHash(
            String blockHash) {
        return new Request<>(
                "mit_getBlockTransactionCountByHash",
                Arrays.asList(blockHash),
                web3jService,
                MitGetBlockTransactionCountByHash.class);
    }

    @Override
    public Request<?, MitGetBlockTransactionCountByNumber> mitGetBlockTransactionCountByNumber(
            DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_getBlockTransactionCountByNumber",
                Arrays.asList(defaultBlockParameter.getValue()),
                web3jService,
                MitGetBlockTransactionCountByNumber.class);
    }

    @Override
    public Request<?, MitGetUncleCountByBlockHash> mitGetUncleCountByBlockHash(String blockHash) {
        return new Request<>(
                "mit_getUncleCountByBlockHash",
                Arrays.asList(blockHash),
                web3jService,
                MitGetUncleCountByBlockHash.class);
    }

    @Override
    public Request<?, MitGetUncleCountByBlockNumber> mitGetUncleCountByBlockNumber(
            DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_getUncleCountByBlockNumber",
                Arrays.asList(defaultBlockParameter.getValue()),
                web3jService,
                MitGetUncleCountByBlockNumber.class);
    }

    @Override
    public Request<?, MitGetCode> mitGetCode(
            String address, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_getCode",
                Arrays.asList(address, defaultBlockParameter.getValue()),
                web3jService,
                MitGetCode.class);
    }

    @Override
    public Request<?, MitSign> mitSign(String address, String sha3HashOfDataToSign) {
        return new Request<>(
                "mit_sign",
                Arrays.asList(address, sha3HashOfDataToSign),
                web3jService,
                MitSign.class);
    }

    @Override
    public Request<?, mit.core.protocol.core.methods.response.MitSendTransaction>
    mitSendTransaction(
            Transaction transaction) {
        return new Request<>(
                "mit_sendTransaction",
                Arrays.asList(transaction),
                web3jService,
                mit.core.protocol.core.methods.response.MitSendTransaction.class);
    }

    @Override
    public Request<?, mit.core.protocol.core.methods.response.MitSendTransaction>
    mitSendRawTransaction(
            String signedTransactionData) {
        return new Request<>(
                "mit_sendRawTransaction",
                Arrays.asList(signedTransactionData),
                web3jService,
                mit.core.protocol.core.methods.response.MitSendTransaction.class);
    }

    @Override
    public Request<?, mit.core.protocol.core.methods.response.MitCall> mitCall(
            Transaction transaction, DefaultBlockParameter defaultBlockParameter) {
        return new Request<>(
                "mit_call",
                Arrays.asList(transaction, defaultBlockParameter),
                web3jService,
                mit.core.protocol.core.methods.response.MitCall.class);
    }

    @Override
    public Request<?, MitEstimateGas> mitEstimateGas(Transaction transaction) {
        return new Request<>(
                "mit_estimateGas",
                Arrays.asList(transaction),
                web3jService,
                MitEstimateGas.class);
    }

    @Override
    public Request<?, MitBlock> mitGetBlockByHash(
            String blockHash, boolean returnFullTransactionObjects) {
        return new Request<>(
                "mit_getBlockByHash",
                Arrays.asList(
                        blockHash,
                        returnFullTransactionObjects),
                web3jService,
                MitBlock.class);
    }

    @Override
    public Request<?, MitBlock> mitGetBlockByNumber(
            DefaultBlockParameter defaultBlockParameter,
            boolean returnFullTransactionObjects) {
        return new Request<>(
                "mit_getBlockByNumber",
                Arrays.asList(
                        defaultBlockParameter.getValue(),
                        returnFullTransactionObjects),
                web3jService,
                MitBlock.class);
    }

    @Override
    public Request<?, MitTransaction> mitGetTransactionByHash(String transactionHash) {
        return new Request<>(
                "mit_getTransactionByHash",
                Arrays.asList(transactionHash),
                web3jService,
                MitTransaction.class);
    }

    @Override
    public Request<?, MitTransaction> mitGetTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex) {
        return new Request<>(
                "mit_getTransactionByBlockHashAndIndex",
                Arrays.asList(
                        blockHash,
                        Numeric.encodeQuantity(transactionIndex)),
                web3jService,
                MitTransaction.class);
    }

    @Override
    public Request<?, MitTransaction> mitGetTransactionByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex) {
        return new Request<>(
                "mit_getTransactionByBlockNumberAndIndex",
                Arrays.asList(
                        defaultBlockParameter.getValue(),
                        Numeric.encodeQuantity(transactionIndex)),
                web3jService,
                MitTransaction.class);
    }

    @Override
    public Request<?, MitGetTransactionReceipt> mitGetTransactionReceipt(String transactionHash) {
        return new Request<>(
                "mit_getTransactionReceipt",
                Arrays.asList(transactionHash),
                web3jService,
                MitGetTransactionReceipt.class);
    }

    @Override
    public Request<?, MitBlock> mitGetUncleByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex) {
        return new Request<>(
                "mit_getUncleByBlockHashAndIndex",
                Arrays.asList(
                        blockHash,
                        Numeric.encodeQuantity(transactionIndex)),
                web3jService,
                MitBlock.class);
    }

    @Override
    public Request<?, MitBlock> mitGetUncleByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger uncleIndex) {
        return new Request<>(
                "mit_getUncleByBlockNumberAndIndex",
                Arrays.asList(
                        defaultBlockParameter.getValue(),
                        Numeric.encodeQuantity(uncleIndex)),
                web3jService,
                MitBlock.class);
    }

    @Override
    public Request<?, MitGetCompilers> mitGetCompilers() {
        return new Request<>(
                "mit_getCompilers",
                Collections.<String>emptyList(),
                web3jService,
                MitGetCompilers.class);
    }

    @Override
    public Request<?, MitCompileLLL> mitCompileLLL(String sourceCode) {
        return new Request<>(
                "mit_compileLLL",
                Arrays.asList(sourceCode),
                web3jService,
                MitCompileLLL.class);
    }

    @Override
    public Request<?, MitCompileSolidity> mitCompileSolidity(String sourceCode) {
        return new Request<>(
                "mit_compileSolidity",
                Arrays.asList(sourceCode),
                web3jService,
                MitCompileSolidity.class);
    }

    @Override
    public Request<?, MitCompileSerpent> mitCompileSerpent(String sourceCode) {
        return new Request<>(
                "mit_compileSerpent",
                Arrays.asList(sourceCode),
                web3jService,
                MitCompileSerpent.class);
    }

    @Override
    public Request<?, MitFilter> mitNewFilter(
            mit.core.protocol.core.methods.request.EthFilter ethFilter) {
        return new Request<>(
                "mit_newFilter",
                Arrays.asList(ethFilter),
                web3jService,
                MitFilter.class);
    }

    @Override
    public Request<?, MitFilter> mitNewBlockFilter() {
        return new Request<>(
                "mit_newBlockFilter",
                Collections.<String>emptyList(),
                web3jService,
                MitFilter.class);
    }

    @Override
    public Request<?, MitFilter> mitNewPendingTransactionFilter() {
        return new Request<>(
                "mit_newPendingTransactionFilter",
                Collections.<String>emptyList(),
                web3jService,
                MitFilter.class);
    }

    @Override
    public Request<?, MitUninstallFilter> mitUninstallFilter(BigInteger filterId) {
        return new Request<>(
                "mit_uninstallFilter",
                Arrays.asList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                MitUninstallFilter.class);
    }

    @Override
    public Request<?, MitLog> mitGetFilterChanges(BigInteger filterId) {
        return new Request<>(
                "mit_getFilterChanges",
                Arrays.asList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                MitLog.class);
    }

    @Override
    public Request<?, MitLog> mitGetFilterLogs(BigInteger filterId) {
        return new Request<>(
                "mit_getFilterLogs",
                Arrays.asList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                MitLog.class);
    }

    @Override
    public Request<?, MitLog> mitGetLogs(
            mit.core.protocol.core.methods.request.EthFilter ethFilter) {
        return new Request<>(
                "mit_getLogs",
                Arrays.asList(ethFilter),
                web3jService,
                MitLog.class);
    }

    @Override
    public Request<?, MitGetWork> mitGetWork() {
        return new Request<>(
                "mit_getWork",
                Collections.<String>emptyList(),
                web3jService,
                MitGetWork.class);
    }

    @Override
    public Request<?, MitSubmitWork> mitSubmitWork(
            String nonce, String headerPowHash, String mixDigest) {
        return new Request<>(
                "mit_submitWork",
                Arrays.asList(nonce, headerPowHash, mixDigest),
                web3jService,
                MitSubmitWork.class);
    }

    @Override
    public Request<?, MitSubmitHashrate> mitSubmitHashrate(String hashrate, String clientId) {
        return new Request<>(
                "mit_submitHashrate",
                Arrays.asList(hashrate, clientId),
                web3jService,
                MitSubmitHashrate.class);
    }

    @Override
    public Request<?, DbPutString> dbPutString(
            String databaseName, String keyName, String stringToStore) {
        return new Request<>(
                "db_putString",
                Arrays.asList(databaseName, keyName, stringToStore),
                web3jService,
                DbPutString.class);
    }

    @Override
    public Request<?, DbGetString> dbGetString(String databaseName, String keyName) {
        return new Request<>(
                "db_getString",
                Arrays.asList(databaseName, keyName),
                web3jService,
                DbGetString.class);
    }

    @Override
    public Request<?, DbPutHex> dbPutHex(String databaseName, String keyName, String dataToStore) {
        return new Request<>(
                "db_putHex",
                Arrays.asList(databaseName, keyName, dataToStore),
                web3jService,
                DbPutHex.class);
    }

    @Override
    public Request<?, DbGetHex> dbGetHex(String databaseName, String keyName) {
        return new Request<>(
                "db_getHex",
                Arrays.asList(databaseName, keyName),
                web3jService,
                DbGetHex.class);
    }

    @Override
    public Request<?, mit.core.protocol.core.methods.response.ShhPost> shhPost(ShhPost shhPost) {
        return new Request<>(
                "shh_post",
                Arrays.asList(shhPost),
                web3jService,
                mit.core.protocol.core.methods.response.ShhPost.class);
    }

    @Override
    public Request<?, ShhVersion> shhVersion() {
        return new Request<>(
                "shh_version",
                Collections.<String>emptyList(),
                web3jService,
                ShhVersion.class);
    }

    @Override
    public Request<?, ShhNewIdentity> shhNewIdentity() {
        return new Request<>(
                "shh_newIdentity",
                Collections.<String>emptyList(),
                web3jService,
                ShhNewIdentity.class);
    }

    @Override
    public Request<?, ShhHasIdentity> shhHasIdentity(String identityAddress) {
        return new Request<>(
                "shh_hasIdentity",
                Arrays.asList(identityAddress),
                web3jService,
                ShhHasIdentity.class);
    }

    @Override
    public Request<?, ShhNewGroup> shhNewGroup() {
        return new Request<>(
                "shh_newGroup",
                Collections.<String>emptyList(),
                web3jService,
                ShhNewGroup.class);
    }

    @Override
    public Request<?, ShhAddToGroup> shhAddToGroup(String identityAddress) {
        return new Request<>(
                "shh_addToGroup",
                Arrays.asList(identityAddress),
                web3jService,
                ShhAddToGroup.class);
    }

    @Override
    public Request<?, ShhNewFilter> shhNewFilter(ShhFilter shhFilter) {
        return new Request<>(
                "shh_newFilter",
                Arrays.asList(shhFilter),
                web3jService,
                ShhNewFilter.class);
    }

    @Override
    public Request<?, ShhUninstallFilter> shhUninstallFilter(BigInteger filterId) {
        return new Request<>(
                "shh_uninstallFilter",
                Arrays.asList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                ShhUninstallFilter.class);
    }

    @Override
    public Request<?, ShhMessages> shhGetFilterChanges(BigInteger filterId) {
        return new Request<>(
                "shh_getFilterChanges",
                Arrays.asList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                ShhMessages.class);
    }

    @Override
    public Request<?, ShhMessages> shhGetMessages(BigInteger filterId) {
        return new Request<>(
                "shh_getMessages",
                Arrays.asList(Numeric.toHexStringWithPrefixSafe(filterId)),
                web3jService,
                ShhMessages.class);
    }

    @Override
    public Observable<NewHeadsNotification> newHeadsNotifications() {
        return web3jService.subscribe(
                new Request<>(
                        "mit_subscribe",
                        Collections.singletonList("newHeads"),
                        web3jService,
                        MitSubscribe.class),
                "mit_unsubscribe",
                NewHeadsNotification.class
        );
    }

    @Override
    public Observable<LogNotification> logsNotifications(
            List<String> addresses, List<String> topics) {

        Map<String, Object> params = createLogsParams(addresses, topics);

        return web3jService.subscribe(
                new Request<>(
                        "mit_subscribe",
                        Arrays.asList("logs", params),
                        web3jService,
                        MitSubscribe.class),
                "mit_unsubscribe",
                LogNotification.class
        );
    }

    private Map<String, Object> createLogsParams(List<String> addresses, List<String> topics) {
        Map<String, Object> params = new HashMap<>();
        if (!addresses.isEmpty()) {
            params.put("address", addresses);
        }
        if (!topics.isEmpty()) {
            params.put("topics", topics);
        }
        return params;
    }

    @Override
    public Observable<String> mitBlockHashObservable() {
        return web3jRx.ethBlockHashObservable(blockTime);
    }

    @Override
    public Observable<String> mitPendingTransactionHashObservable() {
        return web3jRx.ethPendingTransactionHashObservable(blockTime);
    }

    @Override
    public Observable<Log> mitLogObservable(
            mit.core.protocol.core.methods.request.EthFilter ethFilter) {
        return web3jRx.ethLogObservable(ethFilter, blockTime);
    }

    @Override
    public Observable<mit.core.protocol.core.methods.response.Transaction>
            transactionObservable() {
        return web3jRx.transactionObservable(blockTime);
    }

    @Override
    public Observable<mit.core.protocol.core.methods.response.Transaction>
            pendingTransactionObservable() {
        return web3jRx.pendingTransactionObservable(blockTime);
    }

    @Override
    public Observable<MitBlock> blockObservable(boolean fullTransactionObjects) {
        return web3jRx.blockObservable(fullTransactionObjects, blockTime);
    }

    @Override
    public Observable<MitBlock> replayBlocksObservable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock,
            boolean fullTransactionObjects) {
        return web3jRx.replayBlocksObservable(startBlock, endBlock, fullTransactionObjects);
    }

    @Override
    public Observable<MitBlock> replayBlocksObservable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock,
            boolean fullTransactionObjects, boolean ascending) {
        return web3jRx.replayBlocksObservable(startBlock, endBlock,
                fullTransactionObjects, ascending);
    }

    @Override
    public Observable<mit.core.protocol.core.methods.response.Transaction>
            replayTransactionsObservable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        return web3jRx.replayTransactionsObservable(startBlock, endBlock);
    }

    @Override
    public Observable<MitBlock> catchUpToLatestBlockObservable(
            DefaultBlockParameter startBlock, boolean fullTransactionObjects,
            Observable<MitBlock> onCompleteObservable) {
        return web3jRx.catchUpToLatestBlockObservable(
                startBlock, fullTransactionObjects, onCompleteObservable);
    }

    @Override
    public Observable<MitBlock> catchUpToLatestBlockObservable(
            DefaultBlockParameter startBlock, boolean fullTransactionObjects) {
        return web3jRx.catchUpToLatestBlockObservable(startBlock, fullTransactionObjects);
    }

    @Override
    public Observable<mit.core.protocol.core.methods.response.Transaction>
            catchUpToLatestTransactionObservable(DefaultBlockParameter startBlock) {
        return web3jRx.catchUpToLatestTransactionObservable(startBlock);
    }

    @Override
    public Observable<MitBlock> catchUpToLatestAndSubscribeToNewBlocksObservable(
            DefaultBlockParameter startBlock, boolean fullTransactionObjects) {
        return web3jRx.catchUpToLatestAndSubscribeToNewBlocksObservable(
                startBlock, fullTransactionObjects, blockTime);
    }

    @Override
    public Observable<mit.core.protocol.core.methods.response.Transaction>
            catchUpToLatestAndSubscribeToNewTransactionsObservable(
            DefaultBlockParameter startBlock) {
        return web3jRx.catchUpToLatestAndSubscribeToNewTransactionsObservable(
                startBlock, blockTime);
    }

    @Override
    public void shutdown() {
        scheduledExecutorService.shutdown();
        try {
            web3jService.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close web3j service", e);
        }
    }
}
