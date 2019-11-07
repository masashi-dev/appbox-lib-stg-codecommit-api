package jp.co.fnj.storage.api.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * APIクライアント
 * 
 * @author yamauchi
 *
 */
@Slf4j
public final class AppboxPlatformApiClient {

    @Value("${appbox.platform.api.domain}")
    private String apiDomain;

    @Value("${appbox.platform.web.clientid}")
    private String clientId;

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * コンストラクタ
     * 
     * @param restTemplate
     */
    public AppboxPlatformApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //
    // /**
    // * PF-FNC-003:会員管理:会員情報取得
    // *
    // * @param authUser
    // * @param memberDetailsRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<MemberDetailsResponse> memberDetails(
    // StorageUser authUser,
    // MemberDetailsRequest memberDetailsRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain, AppboxPlatformApiInternalUrl.URL_MEMBERS);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // クエリパラメータの作成
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("memberId", memberDetailsRequest.getMemberId());
    //
    // // API実行
    // try {
    // HttpEntity<MemberDetailsRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity, MemberDetailsResponse.class,
    // params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    //
    // }
    //
    // /**
    // * PF-FNC-005:会員管理:会員情報更新
    // *
    // * @param authUser
    // * @param memberUpdateRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<MemberUpdateResponse> memberUpdate(
    // StorageUser authUser,
    // MemberUpdateRequest memberUpdateRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain, AppboxPlatformApiInternalUrl.URL_MEMBERS);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<MemberUpdateRequest> requestEntity = new HttpEntity<>(memberUpdateRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, MemberUpdateResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-007:会員管理:会員パスワード初期化
    // *
    // * @param authUser
    // * @param membersPasswordInitRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<MembersPasswordInitResponse> membersPasswordInit(
    // StorageUser authUser,
    // MembersPasswordInitRequest membersPasswordInitRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_MEMBERS_PASSWORD_INIT);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<MembersPasswordInitRequest> requestEntity = new
    // HttpEntity<>(membersPasswordInitRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.POST, requestEntity,
    // MembersPasswordInitResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-010:会員管理:会員デバイス情報の解除
    // *
    // * @param authUser
    // * @param membersDeviceReleaseRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<MembersDeviceReleaseResponse> membersDeviceRelease(
    // StorageUser authUser,
    // MembersDeviceReleaseRequest membersDeviceReleaseRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_MEMBERS_DEVICE);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<MembersDeviceReleaseRequest> requestEntity = new
    // HttpEntity<>(membersDeviceReleaseRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
    // MembersDeviceReleaseResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-013:会員管理:会員一覧取得
    // *
    // * @param authUser
    // * @param membersListRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<MembersListResponse> membersList(
    // StorageUser authUser,
    // MembersListRequest membersListRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_MEMBERS_LIST);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // クエリパラメータの作成
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("developerId", membersListRequest.getDeveloperId());
    // params.put("mansionId", membersListRequest.getMansionId());
    // params.put("roomId", membersListRequest.getRoomId());
    // params.put("lastName", membersListRequest.getLastName());
    // params.put("firstName", membersListRequest.getFirstName());
    // params.put("lastNameKana", membersListRequest.getLastNameKana());
    // params.put("firstNameKana", membersListRequest.getFirstNameKana());
    // params.put("birthday", membersListRequest.getBirthday());
    // params.put("email", membersListRequest.getEmail());
    // params.put("contactTel", membersListRequest.getContactTel());
    // params.put("buildingId", membersListRequest.getBuildingId());
    // params.put("roomName", membersListRequest.getRoomName());
    // params.put("roomMemberRelType", membersListRequest.getRoomMemberRelType());
    // params.put("pageNumber", membersListRequest.getPageNumber().toString());
    // params.put("dataCount", membersListRequest.getDataCount().toString());
    //
    //
    // // API実行
    // try {
    // HttpEntity<MembersListRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity, MembersListResponse.class,
    // params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-122:会員管理:デバイス一覧取得
    // *
    // * @param authUser
    // * @param membersDeviceListRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<MembersDeviceListResponse> membersDeviceList(
    // StorageUser authUser,
    // MembersDeviceListRequest membersDeviceListRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_MEMBERS_DEVICE_LIST);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("memberId", membersDeviceListRequest.getMemberId());
    //
    // // API実行
    // try {
    // HttpEntity<MembersDeviceListRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity, MembersDeviceListResponse.class,
    // params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-021:認証:認証
    // *
    // * @param authAuthorizeRequest
    // * @return
    // */
    // public HttpEntity<AuthAuthorizeResponse> authorize(AuthAuthorizeRequest authAuthorizeRequest) {
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_AUTH_AUTHORIZE);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newNoAuhtHeaders();
    //
    // // API実行
    // try {
    // HttpEntity<AuthAuthorizeRequest> requestEntity = new HttpEntity<>(authAuthorizeRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.POST, requestEntity, AuthAuthorizeResponse.class);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-024:認証:アクセストークン取得
    // *
    // * @param authUser
    // */
    // public void authToken(StorageUser authUser) {
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain, AppboxPlatformApiInternalUrl.URL_AUTH_TOKEN);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newNoAuhtHeaders();
    //
    // // リクエストボディの作成
    // AuthTokenRequest authTokenRequest = new AuthTokenRequest();
    // authTokenRequest.setTokenGrantType(TokenGrantType.REFRESH_TOKEN.getCode());
    // authTokenRequest.setRefreshToken(authUser.getRefreshToken());
    //
    // // API実行
    // try {
    // HttpEntity<AuthTokenRequest> requestEntity = new HttpEntity<>(authTokenRequest, headers);
    // HttpEntity<AuthTokenResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
    // requestEntity, AuthTokenResponse.class);
    //
    // // 認証情報を更新
    // authUser.setIdToken(responseEntity.getBody().getIdToken());
    // authUser.setAccessToken(responseEntity.getBody().getAccessToken());
    // authUser.setRefreshToken(responseEntity.getBody().getRefreshToken());
    //
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-022:認証:ログアウト
    // *
    // * @param authUser
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<AuthLogoutResponse> authLogout(StorageUser authUser) throws
    // AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_AUTH_LOGOUT);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<AuthLogoutRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity, AuthLogoutResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-222:認証:管理者ユーザー情報取得
    // *
    // * @param authUser
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<AuthMgraccountsUserinfoResponse> authMgraccountsUserinfo(StorageUser authUser)
    // throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_AUTH_MGRACCOUNTS_USERINFO);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<AuthMgraccountsUserinfoRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // AuthMgraccountsUserinfoResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-033:物件管理:デベロッパー一覧取得
    // *
    // * @param authUser
    // * @param propertiesDevelopersListRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<PropertiesDevelopersListResponse> propertiesDevelopersList(
    // StorageUser authUser,
    // PropertiesDevelopersListRequest propertiesDevelopersListRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_PROPERTIES_DEVELOPERS_LIST);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("developerNameJapanese", propertiesDevelopersListRequest.getDeveloperNameJapanese());
    // params.put("developerNameEnglish", propertiesDevelopersListRequest.getDeveloperNameEnglish());
    // params.put("usageFromDateTime", propertiesDevelopersListRequest.getUsageFromDateTime());
    // params.put("usageToDateTime", propertiesDevelopersListRequest.getUsageToDateTime());
    // params.put("companyName", propertiesDevelopersListRequest.getCompanyName());
    // params.put("companyPostalCode", propertiesDevelopersListRequest.getCompanyPostalCode());
    // params.put("companyState", propertiesDevelopersListRequest.getCompanyState());
    // params.put("companyCity", propertiesDevelopersListRequest.getCompanyCity());
    //
    // // API実行
    // try {
    // HttpEntity<PropertiesDevelopersListRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // PropertiesDevelopersListResponse.class, params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-034:物件管理:デベロッパー詳細取得
    // *
    // * @param authUser
    // * @param propertiesDevelopersDetailsRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<PropertiesDevelopersDetailsResponse> propertiesDevelopersdetails(
    // StorageUser authUser,
    // PropertiesDevelopersDetailsRequest propertiesDevelopersDetailsRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_PROPERTIES_DEVELOPERS);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("developerId", propertiesDevelopersDetailsRequest.getDeveloperId());
    //
    // // API実行
    // try {
    // HttpEntity<PropertiesDevelopersDetailsRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // PropertiesDevelopersDetailsResponse.class, params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-038:物件管理:マンション一覧取得
    // *
    // * @param authUser
    // * @param propertiesMansionsListRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<PropertiesMansionsListResponse> propertiesMansionsList(
    // StorageUser authUser,
    // PropertiesMansionsListRequest propertiesMansionsListRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_PROPERTIES_MANSIONS_LIST);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("developerId", propertiesMansionsListRequest.getDeveloperId());
    // params.put("mansionNameJapanese", propertiesMansionsListRequest.getMansionNameJapanese());
    // params.put("mansionNameEnglish", propertiesMansionsListRequest.getMansionNameEnglish());
    // params.put("usageFromDateTime", propertiesMansionsListRequest.getUsageFromDateTime());
    // params.put("usageToDateTime", propertiesMansionsListRequest.getUsageToDateTime());
    // params.put("postalCode", propertiesMansionsListRequest.getPostalCode());
    // params.put("state", propertiesMansionsListRequest.getState());
    // params.put("city", propertiesMansionsListRequest.getCity());
    // params.put("pageNumber", propertiesMansionsListRequest.getPageNumber().toString());
    // params.put("dataCount", propertiesMansionsListRequest.getDataCount().toString());
    //
    // // API実行
    // try {
    // HttpEntity<PropertiesMansionsListRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // PropertiesMansionsListResponse.class, params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    //
    // }
    //
    // /**
    // * PF-FNC-039:物件管理:マンション詳細取得
    // *
    // * @param authUser
    // * @param propertiesMansionsDetailsRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<PropertiesMansionsDetailsResponse> propertiesMansionsDetails(
    // StorageUser authUser,
    // PropertiesMansionsDetailsRequest propertiesMansionsDetailsRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_PROPERTIES_MANSIONS);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("mansionId", propertiesMansionsDetailsRequest.getMansionId());
    //
    // // API実行
    // try {
    // HttpEntity<PropertiesMansionsDetailsRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // PropertiesMansionsDetailsResponse.class, params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    //
    // }
    //
    // /**
    // * PF-FNC-041:物件管理:マンション更新
    // *
    // * @param authUser
    // * @param propertiesMansionsUpdateRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<PropertiesMansionsUpdateResponse> propertiesMansionsUpdate(
    // StorageUser authUser,
    // PropertiesMansionsUpdateRequest propertiesMansionsUpdateRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_PROPERTIES_MANSIONS);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<PropertiesMansionsUpdateRequest> requestEntity = new
    // HttpEntity<>(propertiesMansionsUpdateRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.PUT, requestEntity,
    // PropertiesMansionsUpdateResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-042:物件管理:マンション削除
    // *
    // * @param authUser
    // * @param propertiesMansionsDeleteRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<PropertiesMansionsDeleteResponse> propertiesMansionsDelete(
    // StorageUser authUser,
    // PropertiesMansionsDeleteRequest propertiesMansionsDeleteRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_PROPERTIES_MANSIONS);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<PropertiesMansionsDeleteRequest> requestEntity = new
    // HttpEntity<>(propertiesMansionsDeleteRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
    // PropertiesMansionsDeleteResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-086:外部サービス表示制御・コンテナ制御管理:外部サービス一覧取得
    // *
    // * @param authUser
    // * @param containerServicesListRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<ContainerServicesListResponse> containerServicesList(
    // StorageUser authUser,
    // ContainerServicesListRequest containerServicesListRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_CONTAINER_SERVICES_LIST);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("serviceType", containerServicesListRequest.getServiceType());
    // params.put("serviceName", containerServicesListRequest.getServiceName());
    // params.put("usageFromDateTime", containerServicesListRequest.getUsageFromDateTime());
    // params.put("usageToDateTime", containerServicesListRequest.getUsageToDateTime());
    // params.put("pfAuthUsedFlg", containerServicesListRequest.getPfAuthUsedFlg().toString());
    // params.put("pageNumber", containerServicesListRequest.getPageNumber().toString());
    // params.put("dataCount", containerServicesListRequest.getDataCount().toString());
    //
    // // API実行
    // try {
    // HttpEntity<ContainerServicesListRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // ContainerServicesListResponse.class, params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-087:外部サービス表示制御・コンテナ制御管理:外部サービス詳細取得
    // *
    // * @param authUser
    // * @param containerServicesDetailsRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<ContainerServicesDetailsResponse> containerServicesDetails(
    // StorageUser authUser,
    // ContainerServicesDetailsRequest containerServicesDetailsRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_CONTAINER_SERVICES);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // Map<String, String> params = new HashMap<String, String>();
    // params.put("serviceId", containerServicesDetailsRequest.getServiceId());
    //
    // // API実行
    // try {
    // HttpEntity<ContainerServicesDetailsRequest> requestEntity = new HttpEntity<>(headers);
    // return restTemplate.exchange(url, HttpMethod.GET, requestEntity,
    // ContainerServicesDetailsResponse.class, params);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-088:外部サービス表示制御・コンテナ制御管理:外部サービス登録
    // *
    // * @param authUser
    // * @param containerServicesRegistRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<ContainerServicesRegistResponse> containerServicesRegist(
    // StorageUser authUser,
    // ContainerServicesRegistRequest containerServicesRegistRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_CONTAINER_SERVICES);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<ContainerServicesRegistRequest> requestEntity = new
    // HttpEntity<>(containerServicesRegistRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.POST, requestEntity,
    // ContainerServicesRegistResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-089:外部サービス表示制御・コンテナ制御管理:外部サービス更新
    // *
    // * @param authUser
    // * @param containerServicesUpdateRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<ContainerServicesUpdateResponse> containerServicesUpdate(
    // StorageUser authUser,
    // ContainerServicesUpdateRequest containerServicesUpdateRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_CONTAINER_SERVICES);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<ContainerServicesUpdateRequest> requestEntity = new
    // HttpEntity<>(containerServicesUpdateRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.PUT, requestEntity,
    // ContainerServicesUpdateResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * PF-FNC-090:外部サービス表示制御・コンテナ制御管理:外部サービス削除
    // *
    // * @param authUser
    // * @param containerServicesDeleteRequest
    // * @return
    // * @throws AppboxPlatformApiClientException
    // */
    // public HttpEntity<ContainerServicesDeleteResponse> containerServicesDelete(
    // StorageUser authUser,
    // ContainerServicesDeleteRequest containerServicesDeleteRequest
    // ) throws AppboxPlatformApiClientException {
    //
    // // アクセストークンのチェック
    // checkAccessTokenAndUpdateToken(authUser);
    //
    // // URLの作成
    // final String url = String.format("%s%s", apiDomain,
    // AppboxPlatformApiInternalUrl.URL_CONTAINER_SERVICES);
    //
    // // リクエストヘッダーの作成
    // HttpHeaders headers = newAuhtHeaders(authUser);
    //
    // // API実行
    // try {
    // HttpEntity<ContainerServicesDeleteRequest> requestEntity = new
    // HttpEntity<>(containerServicesDeleteRequest, headers);
    // return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
    // ContainerServicesDeleteResponse.class);
    // } catch (HttpStatusCodeException ex) {
    // throw newAppboxPlatformApiClientException(ex);
    // } catch (Exception ex) {
    // // どうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException(String.format("api call failed.(%s)", url), ex);
    // }
    // }
    //
    // /**
    // * 認証が不要なAPIを呼び出すときのリクエストヘッダーを作成します。
    // *
    // * @return
    // */
    // private HttpHeaders newNoAuhtHeaders() {
    // HttpHeaders headers = new HttpHeaders();
    //
    // headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
    // headers.set(AppboxPlatformRequestCustomHeader.CLIENT_ID, clientId);
    //
    // return headers;
    // }
    //
    // /**
    // * 認証が必要なAPIを呼び出すときのリクエストヘッダーを作成します。
    // *
    // * @param authUser
    // * @return
    // */
    // private HttpHeaders newAuhtHeaders(StorageUser authUser) {
    // HttpHeaders headers = new HttpHeaders();
    //
    // headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
    // headers.set(AppboxPlatformRequestCustomHeader.ID_TOKEN, authUser.getIdToken());
    // headers.set(AppboxPlatformRequestCustomHeader.ACCESS_TOKEN, authUser.getAccessToken());
    //
    // return headers;
    // }
    //
    // /**
    // * アクセストークンの有効期限を確認して、有効期限切れであればトークンをリフレッシュします。
    // *
    // * @param authUser
    // */
    // private void checkAccessTokenAndUpdateToken(StorageUser authUser) {
    // // トークンの有効期限切れチェック
    // if (!isExpiresIn(authUser.getAccessToken())) {
    // // 有効期限が切れている場合は、リフレッシュトークンを使用して、トークンを再取得する。
    // authToken(authUser);
    // }
    // }
    //
    // /**
    // * アクセストークンの有効期限を確認します。
    // *
    // * @param accessToken
    // * @return
    // */
    // private boolean isExpiresIn(String accessToken) {
    //
    // // JWT形式のアクセストークンをデコードする。
    // DecodedJWT decodedAccessToken;
    // try {
    // decodedAccessToken = JWT.decode(accessToken);
    // } catch (JWTDecodeException e) {
    // log.info("access token decoding failed.");
    // throw new StorageRuntimeException("access token decoding failed.");
    // }
    //
    // // 10分早める
    // DateTime now = StorageWebUtil.getSystemDate().minusMinutes(10);
    //
    // // アクセストークンの有効期限を確認する。
    // if (now.toDate().after(decodedAccessToken.getExpiresAt())) {
    // // 有効期限切れ
    // return false;
    // } else {
    // // 有効期限内
    // return true;
    // }
    // }
    //
    // /**
    // * AppboxPlatformApiClientExceptionを作成します。
    // *
    // * @param ex
    // * @return
    // */
    // private AppboxPlatformApiClientException
    // newAppboxPlatformApiClientException(HttpStatusCodeException ex) {
    // AppboxPlatformApiErrorResponse errorResponse =
    // newAppboxPlatformApiErrorResponse(ex.getResponseBodyAsString());
    // return new AppboxPlatformApiClientException(ex.getMessage(), ex, ex.getStatusCode(),
    // errorResponse);
    // }
    //
    // /**
    // * エラーレスポンスのJSON文字列をAppboxPlatformApiErrorResponseに変換します。
    // *
    // * @param responseBodyAsString
    // * @return
    // */
    // private AppboxPlatformApiErrorResponse newAppboxPlatformApiErrorResponse(String
    // responseBodyAsString) {
    //
    // try {
    // return objectMapper.readValue(responseBodyAsString, AppboxPlatformApiErrorResponse.class);
    // } catch (Exception ex) {
    // // ここで例外出たらどうにもできないので、RunTimeExceptionをスローする
    // throw new StorageRuntimeException("Failed to deserialize error responseBodyAsString to
    // AppboxPlatformApiErrorResponse.", ex);
    // }
    // }

}
