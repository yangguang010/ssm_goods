package cn.yangguang.ssm.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyangguang on 2017/11/6.
 */
public class WriteExcel {
    //导出表格的列名
    private String[] rowName;
    //每行作为一个Object对象
    private List<Object[]> dataList;

    //构造方法，传入要导出的数据
    public WriteExcel(String[] rowName, List<Object[]> dataList) {
        this.rowName = rowName;
        this.dataList = dataList;
    }


    /**
     * 导出数据
     */
    public InputStream export() {
        //声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        //声明一个单子并命名
        HSSFSheet sheet = workbook.createSheet("user_sheet1");

        //sheet样式的定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面】
        HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
        HSSFCellStyle style = this.getStyle(workbook);

        //定义所需列数
        int columnNum = rowName.length;
        HSSFRow rowRowName = sheet.createRow(0);

        //将列头设置到sheet的单元格中
        for(int i = 0; i < columnNum; i ++) {
            HSSFCell cellRowName = rowRowName.createCell(i);
           //cellRowName.setCellStyle(HSSFCell.CELL_TYPE_STRING);
            HSSFRichTextString text = new HSSFRichTextString(rowName[i]);
            cellRowName.setCellValue(text);
            cellRowName.setCellStyle(columnTopStyle);
        }

        //将查询出的数据设置到sheet对应的单元格中
        for(int i=0;i<dataList.size();i++){

            Object[] obj = dataList.get(i);//遍历每个对象
            HSSFRow row = sheet.createRow(i+1);//创建所需的行数
            for(int j=0; j<obj.length; j++){
                HSSFCell  cell = null;   //设置单元格的数据类型
                cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
                if(!"".equals(obj[j]) && obj[j] != null){
                    cell.setCellValue(obj[j].toString());						//设置单元格的值
                }
                cell.setCellStyle(style);									//设置单元格样式
            }
        }

        //让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < columnNum; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if(colNum == 0){
                sheet.setColumnWidth(colNum, (columnWidth-2) * 256);
            }else{
                sheet.setColumnWidth(colNum, (columnWidth+4) * 256);
            }
        }

        String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
        String headStr = "attachment; filename=\"" + fileName + "\"";
//				        response = getResponse();
//				        response.setContentType("APPLICATION/OCTET-STREAM");
//				        response.setHeader("Content-Disposition", headStr);
//				        OutputStream out = response.getOutputStream();
       /* try {
            FileOutputStream out=new FileOutputStream("C:\\test.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        ByteArrayOutputStream os=new ByteArrayOutputStream();
        try {
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] content=os.toByteArray();
        InputStream is=new ByteArrayInputStream(content);
        return is;
    }

    /*
     * 列头单元格样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
   * 列数据信息单元格样式
   */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }
    public static void main(String[] args) throws Exception {
        String[] rowsName = new String[]{"序号","状态","录入人","录入时间"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] obj1=new Object[4];
        obj1[0]="1";
        obj1[1]="ok";
        obj1[2]="hello";
        obj1[3]="wsz";
        dataList.add(obj1);
        Object[] obj2=new Object[4];
        obj2[0]="2";
        obj2[1]="dsa";
        obj2[2]="wolrd";
        obj2[3]="python";
        dataList.add(obj2);
        WriteExcel ex = new WriteExcel(rowsName, dataList);
        ex.export();
    }


}
