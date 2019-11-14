package jp.co.fnj.storage.api.service.sortorder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jp.co.fnj.storage.api.entity.mapper.generat.TSortOrderMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TFileMapper;
import jp.co.fnj.storage.api.entity.mapper.generat.TFolderMapper;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.api.entity.model.generat.TSortOrderExample;
import jp.co.fnj.storage.api.entity.model.generat.TFile;
import jp.co.fnj.storage.api.entity.model.generat.TFileExample;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import jp.co.fnj.storage.api.model.sortorder.SortOrderLogicalNameSortRequest;
import jp.co.fnj.storage.api.model.sortorder.SortOrderLogicalNameSortResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 0~9並び替えAPIサービス.
 *
 * @param <REQUEST_BODY>
 * @param <RESPONSE>
 */
@Service
public class SortOrderLogicalNameSortService<REQUEST_BODY extends SortOrderLogicalNameSortRequest, RESPONSE extends SortOrderLogicalNameSortResponse> {

  /** ファイルテーブルマッパー */
  @Autowired
  TFileMapper tFileMapper;
  /** フォルダテーブルマッパー */
  @Autowired
  TFolderMapper tFolderMapper;
  /** 表示順テーブルマッパー */
  @Autowired
  TSortOrderMapper tSortOrderMapper;

  @Transactional(rollbackFor = Throwable.class)
  public void execute(HttpServletRequest request, HttpServletResponse response,
      REQUEST_BODY requestBody) {

    TSortOrderExample tSortOrderUpdate = new TSortOrderExample();
    tSortOrderUpdate.createCriteria().andParentFolderIdEqualTo(requestBody.getFolder_id());
    tSortOrderUpdate.setForUpdate(true);
    List<TSortOrder> tSortOrderExampleForUpdateList =
        tSortOrderMapper.selectByExample(tSortOrderUpdate);

    // フォルダIDをもとに、フォルダ配下のファイル情報(ファイルID、論理ファイル名)を取得する。
    TFileExample tFileExample = new TFileExample();
    tFileExample.createCriteria().andFolderIdEqualTo(requestBody.getFolder_id())
        .andDeleteFlgEqualTo(false);
    tFileExample.setForUpdate(true);
    List<TFile> listFileExample = tFileMapper.selectByExample(tFileExample);

    // フォルダIDをもとに、フォルダ配下のフォルダ情報(フォルダID、論理フォルダ名)を取得する。
    TFolderExample tFolderExample = new TFolderExample();
    tFolderExample.createCriteria().andParentFolderIdEqualTo(requestBody.getFolder_id())
        .andDeleteFlgEqualTo(false);
    tFolderExample.setForUpdate(true);
    List<TFolder> listFolderExample = tFolderMapper.selectByExample(tFolderExample);

    int numbering = listFileExample.size() + listFolderExample.size();
    List<LogicalNameSort> LogicalNameSortList = new ArrayList<>();

    for (TFile tmpRec : listFileExample) {
      LogicalNameSortList.add(new LogicalNameSort(tmpRec.getFileName(), tmpRec.getFileId(), 0));
    }

    for (TFolder tmpRec : listFolderExample) {
      LogicalNameSortList.add(new LogicalNameSort(tmpRec.getFolderName(), tmpRec.getFolderId(), 1));
    }

    // 論理名のunicode順でソートする
    Collections.sort(LogicalNameSortList, new Comparator<LogicalNameSort>() {
      public int compare(LogicalNameSort tmpRec1, LogicalNameSort tmpRec2) {
        return tmpRec1.getLogicalName().compareTo((tmpRec2.getLogicalName()));
      }
    });

    // ソート順で再付番し、更新処理を実施
    for (LogicalNameSort tmpRec : LogicalNameSortList) {

      if (tmpRec.getIdentifier() == 0) {

        // 識別子がファイルの場合

        TSortOrder tSortOrderFile =
            tSortOrderExampleForUpdateList.stream().filter(s -> s.getFileId() != null)
                .filter(s -> s.getFileId().equals(tmpRec.getId())).findFirst().get();
        // // 更新する項目を設定
        tSortOrderFile.setSortOrder(numbering * 2);
        tSortOrderFile.setUpdateUser("tetuser"); // TODO:未整備のため別途対応
        tSortOrderFile.setUpdateDate(LocalDateTime.now());
        tSortOrderMapper.updateByPrimaryKey(tSortOrderFile);

      } else if (tmpRec.getIdentifier() == 1) {

        // 識別子がフォルダの場合
        TSortOrder tSortOrderFolder =
            tSortOrderExampleForUpdateList.stream().filter(s -> s.getFolderId() != null)
                .filter(s -> s.getFolderId().equals(tmpRec.getId())).findFirst().get();

        // 更新する項目を設定
        tSortOrderFolder.setSortOrder(numbering * 2);
        tSortOrderFolder.setUpdateUser("tetuser"); // TODO:未整備のため別途対応
        tSortOrderFolder.setUpdateDate(LocalDateTime.now());
        tSortOrderMapper.updateByPrimaryKey(tSortOrderFolder);
      }
      numbering -= 1;
    }
    // レスポンス項目なし
    return;
  }

  @Data
  @AllArgsConstructor
  private class LogicalNameSort {

    // 論理ファイル名もしくは論理フォルダ名
    private String LogicalName;

    // ファイルIDもしくはフォルダID
    private String Id;

    // ファイル・フォルダ識別子(ファイル：0、フォルダ;1)
    private Integer Identifier;

  }
}
