package jp.co.fnj.storage.constant;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
public final class StorageApiUrl {

	public static final String STORAGEACCESS = "/storageaccess";
	
	public String STORAGEACCESS() {
		return STORAGEACCESS;
	}
}
