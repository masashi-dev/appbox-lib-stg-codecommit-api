package jp.co.fnj.storage.api.controller.s3managedfileInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.fnj.storage.api.exception.StorageException;
import jp.co.fnj.storage.api.logic.S3UploadFileInfoRegistLogic;
import jp.co.fnj.storage.api.model.s3uploadfile.S3UploadFileInfoRegistRequest;
import jp.co.fnj.storage.api.model.s3uploadfile.S3UploadFileInfoRegistResponse;

public class S3ManagedFileInfoController {

	@Autowired
	private S3UploadFileInfoRegistLogic S3UploadFileInfoRegistLogic;

	/**
	 * STORAGE-FNC-039 外部サービスファイルの取得
	 * 
	 * @param request
	 * @param response
	 * @param requestBody
	 * @return
	 * @throws StorageException
	 */
	@GetMapping(value = "")
	@ResponseBody
	public ResponseEntity<S3UploadFileInfoRegistResponse> get(HttpServletRequest request, HttpServletResponse response,
			@RequestBody S3UploadFileInfoRegistRequest requestBody) throws StorageException {
		return S3UploadFileInfoRegistLogic.execute(request, response, requestBody);
	}
}