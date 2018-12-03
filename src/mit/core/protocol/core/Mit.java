package mit.core.protocol.core;

import java.math.BigInteger;

import mit.core.protocol.core.methods.request.ShhFilter;
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
import mit.core.protocol.core.methods.response.MitSyncing;
import mit.core.protocol.core.methods.response.MitTransaction;
import mit.core.protocol.core.methods.response.MitUninstallFilter;
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

/**
 * Core Ethereum JSON-RPC API.
 */
public interface Mit {
    Request<?, Web3ClientVersion> web3ClientVersion();

    Request<?, Web3Sha3> web3Sha3(String data);

    Request<?, NetVersion> netVersion();

    Request<?, NetListening> netListening();

    Request<?, NetPeerCount> netPeerCount();

    Request<?, MitProtocolVersion> mitProtocolVersion();

    Request<?, MitCoinbase> mitCoinbase();

    Request<?, MitSyncing> mitSyncing();

    Request<?, MitMining> mitMining();

    Request<?, MitHashrate> mitHashrate();

    Request<?, MitGasPrice> mitGasPrice();

    Request<?, MitAccounts> mitAccounts();

    Request<?, MitBlockNumber> mitBlockNumber();

    Request<?, MitGetBalance> mitGetBalance(
            String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, MitGetStorageAt> mitGetStorageAt(
            String address, BigInteger position,
            DefaultBlockParameter defaultBlockParameter);

    Request<?, MitGetTransactionCount> mitGetTransactionCount(
            String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, MitGetBlockTransactionCountByHash> mitGetBlockTransactionCountByHash(
            String blockHash);

    Request<?, MitGetBlockTransactionCountByNumber> mitGetBlockTransactionCountByNumber(
            DefaultBlockParameter defaultBlockParameter);

    Request<?, MitGetUncleCountByBlockHash> mitGetUncleCountByBlockHash(String blockHash);

    Request<?, MitGetUncleCountByBlockNumber> mitGetUncleCountByBlockNumber(
            DefaultBlockParameter defaultBlockParameter);

    Request<?, MitGetCode> mitGetCode(String address, DefaultBlockParameter defaultBlockParameter);

    Request<?, MitSign> mitSign(String address, String sha3HashOfDataToSign);

    Request<?, mit.core.protocol.core.methods.response.MitSendTransaction> mitSendTransaction(
            mit.core.protocol.core.methods.request.Transaction transaction);

    Request<?, mit.core.protocol.core.methods.response.MitSendTransaction> mitSendRawTransaction(
            String signedTransactionData);

    Request<?, mit.core.protocol.core.methods.response.MitCall> mitCall(
            mit.core.protocol.core.methods.request.Transaction transaction,
            DefaultBlockParameter defaultBlockParameter);

    Request<?, MitEstimateGas> mitEstimateGas(
            mit.core.protocol.core.methods.request.Transaction transaction);

    Request<?, MitBlock> mitGetBlockByHash(String blockHash, boolean returnFullTransactionObjects);

    Request<?, MitBlock> mitGetBlockByNumber(
            DefaultBlockParameter defaultBlockParameter,
            boolean returnFullTransactionObjects);

    Request<?, MitTransaction> mitGetTransactionByHash(String transactionHash);

    Request<?, MitTransaction> mitGetTransactionByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex);

    Request<?, MitTransaction> mitGetTransactionByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex);

    Request<?, MitGetTransactionReceipt> mitGetTransactionReceipt(String transactionHash);

    Request<?, MitBlock> mitGetUncleByBlockHashAndIndex(
            String blockHash, BigInteger transactionIndex);

    Request<?, MitBlock> mitGetUncleByBlockNumberAndIndex(
            DefaultBlockParameter defaultBlockParameter, BigInteger transactionIndex);

    Request<?, MitGetCompilers> mitGetCompilers();

    Request<?, MitCompileLLL> mitCompileLLL(String sourceCode);

    Request<?, MitCompileSolidity> mitCompileSolidity(String sourceCode);

    Request<?, MitCompileSerpent> mitCompileSerpent(String sourceCode);

    Request<?, MitFilter> mitNewFilter(mit.core.protocol.core.methods.request.EthFilter ethFilter);

    Request<?, MitFilter> mitNewBlockFilter();

    Request<?, MitFilter> mitNewPendingTransactionFilter();

    Request<?, MitUninstallFilter> mitUninstallFilter(BigInteger filterId);

    Request<?, MitLog> mitGetFilterChanges(BigInteger filterId);

    Request<?, MitLog> mitGetFilterLogs(BigInteger filterId);

    Request<?, MitLog> mitGetLogs(mit.core.protocol.core.methods.request.EthFilter ethFilter);

    Request<?, MitGetWork> mitGetWork();

    Request<?, MitSubmitWork> mitSubmitWork(String nonce, String headerPowHash, String mixDigest);

    Request<?, MitSubmitHashrate> mitSubmitHashrate(String hashrate, String clientId);

    Request<?, DbPutString> dbPutString(String databaseName, String keyName, String stringToStore);

    Request<?, DbGetString> dbGetString(String databaseName, String keyName);

    Request<?, DbPutHex> dbPutHex(String databaseName, String keyName, String dataToStore);

    Request<?, DbGetHex> dbGetHex(String databaseName, String keyName);

    Request<?, mit.core.protocol.core.methods.response.ShhPost> shhPost(
            mit.core.protocol.core.methods.request.ShhPost shhPost);

    Request<?, ShhVersion> shhVersion();

    Request<?, ShhNewIdentity> shhNewIdentity();

    Request<?, ShhHasIdentity> shhHasIdentity(String identityAddress);

    Request<?, ShhNewGroup> shhNewGroup();

    Request<?, ShhAddToGroup> shhAddToGroup(String identityAddress);

    Request<?, ShhNewFilter> shhNewFilter(ShhFilter shhFilter);

    Request<?, ShhUninstallFilter> shhUninstallFilter(BigInteger filterId);

    Request<?, ShhMessages> shhGetFilterChanges(BigInteger filterId);

    Request<?, ShhMessages> shhGetMessages(BigInteger filterId);
}
