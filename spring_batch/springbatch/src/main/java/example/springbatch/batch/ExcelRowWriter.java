package example.springbatch.batch;

import example.springbatch.entity.BeforeEntity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRowWriter implements ItemStreamWriter<BeforeEntity> {

    private final String filePath;
    private Workbook workbook;
    private Sheet sheet;
    private int currentRowNumber;

    public ExcelRowWriter(String filePath) throws IOException {
        this.filePath = filePath;
        currentRowNumber = 0;
    }

    @Override
    public void write(Chunk<? extends BeforeEntity> chunk) throws Exception {
        for (BeforeEntity entity : chunk) {
            Row row = sheet.createRow(currentRowNumber++);
            row.createCell(0).setCellValue(entity.getUsername());
        }
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Sheet1");
    }

    @Override
    public void close() throws ItemStreamException {
        try(FileOutputStream fileOut = new FileOutputStream(filePath)){
            workbook.write(fileOut);
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try{
                workbook.close();
            }catch(Exception e){

                throw new ItemStreamException(e);
            }
        }
    }
}
