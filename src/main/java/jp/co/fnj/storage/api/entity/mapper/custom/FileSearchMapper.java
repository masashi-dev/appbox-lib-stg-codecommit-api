package jp.co.fnj.storage.api.entity.mapper.custom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileSearchMapper {

  /**
   * ファイルが属するフォルダの情報を取得する
   *
   */
  Integer selectFolder(String argFolderId);
}
