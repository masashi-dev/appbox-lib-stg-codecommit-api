package jp.co.fnj.storage.api.controller.externalfile;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.fnj.storage.api.constant.StorageApiUrl;
import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.logic.externalfile.ExternalFileDeleteLogic;
import jp.co.fnj.storage.api.logic.externalfile.ExternalFileGetLogic;
import jp.co.fnj.storage.api.logic.externalfile.ExternalFileRegistLogic;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileDeleteRequest;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileDeleteResponse;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileGetRequest;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileGetResponse;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileRegistRequest;
import jp.co.fnj.storage.api.model.externalfile.ExternalFileRegistResponse;

public class ExternalFileController {

	private static final String STORAGEACCESS = StorageApiUrl.STORAGEACCESS;

	@Autowired
	private ExternalFileGetLogic ExternalFileGetLogic;
	@Autowired
	private ExternalFileRegistLogic ExternalFileRegistLogic;
	@Autowired
	private ExternalFileDeleteLogic ExternalFileDeleteLogic;

	/**
	 * STORAGE-FNC-039 外部サービスファイルの取得
	 * 
	 * @param request
	 * @param response
	 * @param requestBody
	 * @return
	 * @throws StorageException
	 */
	@GetMapping(STORAGEACCESS)
	@ResponseBody
	public ResponseEntity<ExternalFileGetResponse> get(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ExternalFileGetRequest requestBody) throws StorageException {
		return ExternalFileGetLogic.execute(request, response, requestBody);
	}

	/**
	 * STORAGE-FNC-040 外部サービスファイルの登録
	 * 
	 * @param request
	 * @param response
	 * @param requestBody
	 * @return
	 * @throws StorageException
	 */
	@RequestMapping(method = POST, path = STORAGEACCESS)
	@ResponseBody
	public ResponseEntity<ExternalFileRegistResponse> regist(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ExternalFileRegistRequest requestBody) throws StorageException {
		return ExternalFileRegistLogic.execute(request, response, requestBody);
	}

	/**
	 * STORAGE-FNC-041 外部サービスファイルの削除
	 * 
	 * @param request
	 * @param response
	 * @param requestBody
	 * @return
	 * @throws StorageException
	 */
	@RequestMapping(method = DELETE, path = STORAGEACCESS)
	@ResponseBody
	public ResponseEntity<ExternalFileDeleteResponse> delete(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ExternalFileDeleteRequest requestBody) throws StorageException {
		return ExternalFileDeleteLogic.execute(request, response, requestBody);
	}
}