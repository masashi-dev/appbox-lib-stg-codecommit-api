package jp.co.fnj.storage.api.testutility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.core.io.ClassPathResource;

public class ExcelReader {

  public static List<String[]> load(String pathAndFile, String sheetName)
      throws EncryptedDocumentException, InvalidFormatException, IOException {

    System.out.println("load EXCEL.:" + pathAndFile);

    InputStream inputStream = new ClassPathResource(pathAndFile).getInputStream();
    Workbook workbook = WorkbookFactory.create(inputStream);

    // シートの取得
    Sheet sheet = workbook.getSheet(sheetName);

    // 行読み込み(1行目は見出し行とする）
    List<String[]> dataSet = new ArrayList<>();
    int lastRowNum = sheet.getLastRowNum();
    int lastCellNum = sheet.getRow(0).getLastCellNum();
    for (int rowIdx = 1; rowIdx < lastRowNum + 1; rowIdx++) {
      Row rowObj = sheet.getRow(rowIdx);
      String[] data = new String[lastCellNum];
      for (int colIdx = 0; colIdx < lastCellNum + 1; colIdx++) {
        Cell cellObj = rowObj.getCell(colIdx);
        if (cellObj == null) {
          continue;
        }

        CellType cellType = cellObj.getCellTypeEnum();
        if (cellType == CellType.BLANK) {
          data[colIdx] = "";
        } else if (cellType == CellType.BOOLEAN) {
          throw new RuntimeException("Boolean cell is unsupported");
        } else if (cellType == CellType.ERROR) {
          throw new RuntimeException("Error cell is unsupported");
        } else if (cellType == CellType.FORMULA) {
          throw new RuntimeException("Formula cell is unsupported");
        } else if (cellType == CellType.NUMERIC) {
          if (DateUtil.isCellDateFormatted(cellObj)) {
            data[colIdx] = String.valueOf(cellObj.getDateCellValue());
          } else {
            data[colIdx] = String.valueOf(cellObj.getNumericCellValue());
          }
        } else if (cellType == CellType.STRING) {
          data[colIdx] = cellObj.getStringCellValue();
        } else {
          throw new RuntimeException("Unknow type cell");
        }
      }
      dataSet.add(data);
    }
    return dataSet;
  }
}
