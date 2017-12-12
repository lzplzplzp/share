package com.code.util;

import com.code.model.JxActivityUrl;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


public class ExcelUtils {

    public static final int CELL_TYPE_NUMBER = 0;
    public static final int CELL_TYPE_STRING = 1;
    public static final int CELL_TYPE_DATE = 3;
    public static final int CELL_TYPE_BOOLEAN = 4;

    private final static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
    /**
     * 导入，读入文件，导出一个list,list里面是一个map,map里面不计算
     *
     * @param inputStream
     * @param keyFileFileName
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static List<Map<String, String>> getFromExcel(InputStream inputStream, String keyFileFileName) throws Exception {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Workbook hssfworkbook = null;
        String xls = null;
        try {
            boolean isExcel2003 = true;
            if (isExcel2007(keyFileFileName)) {
                isExcel2003 = false;
            }
            if (isExcel2003) {
                hssfworkbook = new HSSFWorkbook(inputStream);
            } else {
                hssfworkbook = new XSSFWorkbook(inputStream);
            }

            Sheet hssfsheet = hssfworkbook.getSheetAt(0);
            Row rowTop = hssfsheet.getRow(0);
            for (int k = 1; k <= hssfsheet.getLastRowNum(); k++) {
                Row row = hssfsheet.getRow(k);
                Map<String, String> map = new HashMap<String, String>();

                int columnNum = row.getPhysicalNumberOfCells();
                for (int i = 0; i < columnNum; i++) {
                    String topXls = getCellValue(rowTop, i).trim();
                    xls = getCellValue(row, i).trim();
                    map.put(topXls, xls);
                }
                list.add(map);
            }
            //循环，去掉里面都是空值的
            for (Map<String, String> map : list) {
                boolean exist = false;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getValue())) {
                        exist = true;
                    }
                }
                if (exist) {
                    result.add(map);
                }
            }
        }finally {
            if(hssfworkbook!=null)
                hssfworkbook.close();
        }
        return result;
    }

    /**
     * 导入，读入文件，导出一个list,list里面是一个map,map里面不计算
     *
     * @param inputStream
     * @param keyFileFileName
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static List<Map<String, String>> getFromExcelNew(InputStream inputStream, String keyFileFileName) throws Exception {
        //List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Workbook hssfworkbook = null;
        String xls = null;
        try {
            boolean isExcel2003 = true;
            if (isExcel2007(keyFileFileName)) {
                isExcel2003 = false;
            }
            if (isExcel2003) {
                hssfworkbook = new HSSFWorkbook(inputStream);
            } else {
                hssfworkbook = new XSSFWorkbook(inputStream);
            }

            Sheet hssfsheet = hssfworkbook.getSheetAt(0);
            Row rowTop = hssfsheet.getRow(0);
            for (int k = 1; k <= hssfsheet.getLastRowNum(); k++) {
                Row row = hssfsheet.getRow(k);
                Map<String, String> map = new HashMap<String, String>();

                int columnNum = row.getPhysicalNumberOfCells();
                for (int i = 0; i < columnNum; i++) {
                    //String topXls = getCellValue(rowTop, i).trim();
                    xls = getCellValueNew(row, i).trim();
                    map.put(String.valueOf(i), xls);
                }
                list.add(map);
            }
        }finally {
            if(hssfworkbook!=null)
                hssfworkbook.close();
        }
        return list;
    }
    /**
     * 导入，读入文件，导出一个list,list里面是一个map,map里面不计算
     *
     * @param keyFileFileName
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static List<String> getFromExcel2Col(InputStream inputStream, String keyFileFileName) throws Exception {
        Workbook hssfworkbook = null;
    	try{
        	List<String> list = new ArrayList<String>();
        	
        	boolean isExcel2003 = true;
        	if (isExcel2007(keyFileFileName)) {
        		isExcel2003 = false;
        	}
        	if (isExcel2003) {
        		hssfworkbook = new HSSFWorkbook(inputStream);
        	} else {
        		hssfworkbook = new XSSFWorkbook(inputStream);
        	}
        	
        	Sheet hssfsheet = hssfworkbook.getSheetAt(0);
        	System.out.println(hssfsheet.getLastRowNum());
        	for (int k = 3; k <= hssfsheet.getLastRowNum(); k++) {
        		Row row = hssfsheet.getRow(k);
                String col1 = getCellValueTow(row, 0).trim();
                String col2 = getCellValueTow(row, 1).trim();
        		list.add(col1 + "," + col2);
        	}
        	return list;
    	}finally{
    		if(inputStream!=null){
    			inputStream.close();
    		}
            if(hssfworkbook!=null){
                hssfworkbook.close();
            }
    	}

    }
    @SuppressWarnings("resource")
    public static List<String> getFromExcel3Col(InputStream inputStream, String keyFileFileName) throws Exception {
    	//List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Workbook hssfworkbook = null;
    	try{
        	List<String> list = new ArrayList<String>();

        	String xls = null;
        	
        	boolean isExcel2003 = true;
        	if (isExcel2007(keyFileFileName)) {
        		isExcel2003 = false;
        	}
        	if (isExcel2003) {
        		hssfworkbook = new HSSFWorkbook(inputStream);
        	} else {
        		hssfworkbook = new XSSFWorkbook(inputStream);
        	}
        	
        	Sheet hssfsheet = hssfworkbook.getSheetAt(0);
        	System.out.println(hssfsheet.getLastRowNum());
        	for (int k = 1; k <= hssfsheet.getLastRowNum(); k++) {
        		Row row = hssfsheet.getRow(k);
        		Map<String, String> map = new HashMap<String, String>(4);
                String col1 = getCellValueTow(row, 0).trim();
                String col2 = getCellValueTow(row, 1).trim();
        		list.add(col1 + "," + col2);
        	}
        	return list;
    	}finally{
    		if(inputStream!=null){
    			inputStream.close();
    		}
            if(hssfworkbook!=null){
                hssfworkbook.close();
            }
    	}

    }
    @SuppressWarnings("resource")
    public static List<String> getFromExcel4Col(InputStream inputStream, String keyFileFileName) throws Exception {
    	//List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Workbook hssfworkbook = null;
    	try{
        	List<String> list = new ArrayList<String>();

        	String xls = null;
        	
        	boolean isExcel2003 = true;
        	if (isExcel2007(keyFileFileName)) {
        		isExcel2003 = false;
        	}
        	if (isExcel2003) {
        		hssfworkbook = new HSSFWorkbook(inputStream);
        	} else {
        		hssfworkbook = new XSSFWorkbook(inputStream);
        	}
        	
        	Sheet hssfsheet = hssfworkbook.getSheetAt(0);
        	System.out.println(hssfsheet.getLastRowNum());
        	for (int k = 0; k <= hssfsheet.getLastRowNum(); k++) {
        		Row row = hssfsheet.getRow(k);
        		Map<String, String> map = new HashMap<String, String>(4);
                String col1 = getCellValueTow(row, 0).trim();
                String col2 = getCellValueThree(row, 1).trim();
                String col3 = getCellValueTow(row, 2).trim();
                String col4 = getCellValueTow(row, 3).trim();
                String col5 = getCellValueTow(row, 4).trim();
                String col6 = getCellValueTow(row, 5).trim();
        		list.add(col1 + "," + col2+ "," + col3+ "," + col4+ "," + col5+ "," + col6);
        	}
        	return list;
    	}finally{
    		if(inputStream!=null){
    			inputStream.close();
    		}
            if(hssfworkbook!=null){
                hssfworkbook.close();
            }
    	}

    }
    /**
     * 导入，读入文件，导出一个map,map里为excel的表头
     *
     * @param inputStream
     * @param keyFileFileName
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static Map<String, String> getFromExcelTop(InputStream inputStream, String keyFileFileName) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
    	Workbook hssfworkbook=null;
    	String xls = null;
    	try {
            boolean isExcel2003 = true;
            if (isExcel2007(keyFileFileName)) {
                isExcel2003 = false;
            }
            if (isExcel2003) {
                hssfworkbook = new HSSFWorkbook(inputStream);
            } else {
                hssfworkbook = new XSSFWorkbook(inputStream);
            }

            Sheet hssfsheet = hssfworkbook.getSheetAt(0);
            Row rowTop = hssfsheet.getRow(1);


            int columnNum = rowTop.getLastCellNum();
            for (int i = 0; i < columnNum; i++) {
                //String topXls = getCellValue(rowTop, i).trim();
                xls = getCellValueNew(rowTop, i).trim();
                map.put(String.valueOf(i), xls);
            }
        } finally {
            if(inputStream!=null){
                inputStream.close();
            }
            if(hssfworkbook!=null){
                hssfworkbook.close();
            }
        }
        return map;
    }
    public static String getCellValue(Row row, int rowNum) throws Exception {
        String cellValue = "";
        Cell cell = row.getCell(rowNum);

        if (cell == null) {
            return cellValue;
        }

        if (cell != null) {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    //可能是时间
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellValue = DateUtils.getDayStr(date);
                    } else {
                        if (cell.getCellStyle().getDataFormatString().indexOf("%") != -1) {
                            cellValue = cell.getNumericCellValue() * 100 + "";
                        } else {
                            cellValue = cell.getNumericCellValue() + "";
                        }

                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    //cellValue = cell.getCellFormula() + "";
                    cellValue = cell.getNumericCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }
        }
        return cellValue;
    }

    public static String getCellValueNew(Row row, int rowNum) throws Exception {
        String cellValue = "";
        Cell cell = row.getCell(rowNum);

        if (cell == null) {
            return cellValue;
        }

        if (cell != null) {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    //可能是时间
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellValue = DateUtils.getDayStr(date);
                    } else {
                        double v= cell.getNumericCellValue();
                        if (cell.getCellStyle().getDataFormatString().indexOf("%") != -1) {
                            cellValue = cell.getNumericCellValue() * 100 + "";
                        } else {
                            if(v>0&&v<1)
                            {
                                //加息卷取小数
                                DecimalFormat df = new DecimalFormat("0.00");
                                cellValue = df.format(cell.getNumericCellValue());
                            }else
                            {
                                DecimalFormat df = new DecimalFormat("0");
                                cellValue = df.format(cell.getNumericCellValue());
                            }
                        }
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    //cellValue = cell.getCellFormula() + "";
                    cellValue = cell.getNumericCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }
        }
        return cellValue;
    }
    public static String getCellValueTow(Row row, int rowNum) throws Exception {
    	String cellValue = "";
    	Cell cell = row.getCell(rowNum);
    	
    	if (cell == null) {
    		return cellValue;
    	}
    	
    	if (cell != null) {
    		// 以下是判断数据的类型
    		switch (cell.getCellType()) {
    		case HSSFCell.CELL_TYPE_NUMERIC: // 数字
    			//可能是时间
    			if (HSSFDateUtil.isCellDateFormatted(cell)) {
    				Date date = cell.getDateCellValue();
    				cellValue = DateUtils.getDayStr(date);
    			} else {
    				if (cell.getCellStyle().getDataFormatString().indexOf("%") != -1) {
    					cellValue = cell.getNumericCellValue() * 100 + "";
    				} else {
    					DecimalFormat df = new DecimalFormat("0");
    					cellValue = df.format(cell.getNumericCellValue());
    					//cellValue = cell.getNumericCellValue() + "";
    				}
    			}
    			break;
    		case HSSFCell.CELL_TYPE_STRING: // 字符串
    			cellValue = cell.getStringCellValue();
    			break;
    		case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
    			cellValue = cell.getBooleanCellValue() + "";
    			break;
    		case HSSFCell.CELL_TYPE_FORMULA: // 公式
    			//cellValue = cell.getCellFormula() + "";
    			cellValue = cell.getNumericCellValue() + "";
    			break;
    		case HSSFCell.CELL_TYPE_BLANK: // 空值
    			cellValue = "";
    			break;
    		case HSSFCell.CELL_TYPE_ERROR: // 故障
    			cellValue = "非法字符";
    			break;
    		default:
    			cellValue = "未知类型";
    			break;
    		}
    	}
    	return cellValue;
    }
    public static String getCellValueThree(Row row, int rowNum) throws Exception {
    	String cellValue = "";
    	Cell cell = row.getCell(rowNum);
    	
    	if (cell == null) {
    		return cellValue;
    	}
    	
    	if (cell != null) {
    		// 以下是判断数据的类型
    		switch (cell.getCellType()) {
    		case HSSFCell.CELL_TYPE_NUMERIC: // 数字
				// 可能是时间
				DecimalFormat df = new DecimalFormat("0.00");
				cellValue = df.format(cell.getNumericCellValue());
				break;
    		case HSSFCell.CELL_TYPE_STRING: // 字符串
    			cellValue = cell.getStringCellValue();
    			break;
    		case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
    			cellValue = cell.getBooleanCellValue() + "";
    			break;
    		case HSSFCell.CELL_TYPE_FORMULA: // 公式
    			//cellValue = cell.getCellFormula() + "";
    			cellValue = cell.getNumericCellValue() + "";
    			break;
    		case HSSFCell.CELL_TYPE_BLANK: // 空值
    			cellValue = "";
    			break;
    		case HSSFCell.CELL_TYPE_ERROR: // 故障
    			cellValue = "非法字符";
    			break;
    		default:
    			cellValue = "未知类型";
    			break;
    		}
    	}
    	return cellValue;
    }
    /**
     * @描述：是否是2007的excel，返回true是2007 *
     * @参数：@param filePath　文件完整路径
     * @参数：@return
     * @返回值：boolean
     */

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * @描述：是否是2003的excel，返回true是2003
     * @参数：@param filePath　文件完整路径
     * @参数：@return
     * @返回值：boolean
     */

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");

    }

    /**
     * 通过数据在指定路径创建Excel
     *
     * @param list
     * @param path
     * @param fileName
     * @return
     */
    public static String CreateExcel(List<Map<String, String>> list, String path, String fileName) {
        if (StringUtils.isEmpty(path) || StringUtils.isEmpty(fileName))
            return "";
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            HSSFSheet sheet = workbook.createSheet("sheet1");

            //处理头部
            String[] headers = {"用户id", "用户手机号码", "用户姓名", "投资时间", "交易补偿类投资时间\n" +
                    "例：2016-12-7\n" +
                    "非必须", "活动名称", "奖品名称", "奖品数值\n" +
                    "红包：元\n" +
                    "加息券：百分比\n" +
                    "其他：个数，默认1", "是否是\n" +
                    "实物奖品\n" +
                    "是：1\n" +
                    "默认空白", "虚拟卡账户", "虚拟卡密码 ", "使用期限\n" +
                    "单位：天\n" +
                    "红包加息券时有用", "最小投资额度\n" +
                    "单位：元"};
            sheet.setDefaultColumnWidth(headers.length);
            int index = 0;
            HSSFRow row = sheet.createRow(index++);
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                //cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }


            for (int i = 0; i < list.size(); i++) {
                int cellIndex = 0;
                row = sheet.createRow(index++);
                //用户ID
                String userID = list.get(i).get("0");
                HSSFCell cell = row.createCell(cellIndex++);
                HSSFRichTextString richString = new HSSFRichTextString(userID);
                cell.setCellValue(richString);

                //用户手机号
                String userPhone = list.get(i).get("1");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(userPhone == null ? "" : userPhone);
                cell.setCellValue(richString);

                //用户姓名
                String userName = list.get(i).get("2");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(userName);
                cell.setCellValue(richString);
                //投资时间
                String investmentTime = list.get(i).get("3");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(investmentTime);
                cell.setCellValue(richString);
                //交易补偿类投资时间
                String compensateTime = list.get(i).get("4");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(compensateTime);
                cell.setCellValue(richString);
                //活动名称
                String activityName = list.get(i).get("5");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(activityName);
                cell.setCellValue(richString);
                //奖品名称
                String rewardTypeName = list.get(i).get("6");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(rewardTypeName);
                cell.setCellValue(richString);
                //奖品数值
                String rewardShare = list.get(i).get("7");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(rewardShare);
                cell.setCellValue(richString);
                //是否实物
                String is_real = list.get(i).get("8");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(is_real);
                cell.setCellValue(richString);
                //虚拟卡账户
                String cardNumber = list.get(i).get("9");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(cardNumber);
                cell.setCellValue(richString);
                //虚拟卡密码
                String cardPassword = list.get(i).get("10");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(cardPassword);
                cell.setCellValue(richString);
                //使用期限
                String timeLimit = list.get(i).get("11");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(timeLimit);
                cell.setCellValue(richString);
                //最小投资额度
                String investMinAmount = list.get(i).get("12");
                cell = row.createCell(cellIndex++);
                richString = new HSSFRichTextString(investMinAmount);
                cell.setCellValue(richString);
            }
        }finally {
            if(workbook!=null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "";
    }

    /**
     * 通过数据在指定路径创建Excel
     *
     * @param list
     * @param path
     * @param fileName
     * @return
     */
    public static String CreateExcelByJxActivityUrlList(List<JxActivityUrl> list, String path, String fileName) {
        if (StringUtils.isEmpty(path) || StringUtils.isEmpty(fileName))
            return "";
        XSSFWorkbook  workbook = new XSSFWorkbook ();
        FileOutputStream targetFile=null;
        String urlPrefix= CustomizedPropertyConfigurer.getContextProperty("jx.sms.url.prefix");
        try {
            XSSFSheet sheet = workbook.createSheet("sheet1");
            //处理头部
            String[] headers1 = {"活动ID", "批次号"};
            String[] headers2 = {"用户id", "用户手机号码", "生成链接"};
            int index = 0;
            //第一行   headers1
            XSSFRow row = sheet.createRow(index++);
            for (int i = 0; i < headers1.length; i++) {
                XSSFCell cell = row.createCell(i);
                //cell.setCellStyle(style);
                XSSFRichTextString text = new XSSFRichTextString(headers1[i]);
                cell.setCellValue(text);
            }
            //第二行   {"活动ID", "批次号"}  对应数据
            XSSFRow row2 = sheet.createRow(index++);
            //活动ID  由于 list 的每条数据的批次号与活动号都相同  所以取第一条即可
            String activityId = list.get(0).getActivityId()+"";
            XSSFCell activityIdCell = row2.createCell(0);
            XSSFRichTextString activityIdText = new XSSFRichTextString(activityId);
            activityIdCell.setCellValue(activityIdText);

            //批次号  由于 list 的每条数据的批次号与活动号都相同  所以取第一条即可
            String batchNum = list.get(0).getBatchNum()+"";
            XSSFCell batchNumCell = row2.createCell(1);
            XSSFRichTextString batchNumText = new XSSFRichTextString(batchNum);
            batchNumCell.setCellValue(batchNumText);

            //第三行   headers2
            XSSFRow row3 = sheet.createRow(index++);
            for (int i = 0; i < headers2.length; i++) {
                XSSFCell cell = row3.createCell(i);
                XSSFRichTextString text = new XSSFRichTextString(headers2[i]);
                cell.setCellValue(text);
            }
            // 循环list 将数据写入单元格
            for (int i = 0; i < list.size(); i++) {
                int cellIndex = 0;
                row = sheet.createRow(index++);
                //用户ID
                String userID = list.get(i).getUserId()+"";
                XSSFCell cell = row.createCell(cellIndex++);
                XSSFRichTextString richString = new XSSFRichTextString(userID);
                cell.setCellValue(richString);
                //用户手机号
                String userPhone = list.get(i).getPhone();
                cell = row.createCell(cellIndex++);
                richString = new XSSFRichTextString(userPhone == null ? "" : userPhone);
                cell.setCellValue(richString);
                //生成的链接
                String url = list.get(i).getUrl();
                cell = row.createCell(cellIndex++);
                richString = new XSSFRichTextString(urlPrefix+url);
                cell.setCellValue(richString);
            }
            //创建excel 空文件
            File file=new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            File f=new File(path,fileName);
            // 创建通道
            targetFile = new FileOutputStream(f);
            //写入数据
            workbook.write(targetFile);

        } catch (Exception e) {
            logger.error("文件写入数据失败 异常信息e:"+e);
        }finally {
            if(workbook!=null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    logger.error("workbook关闭异常",e);
                }
            }
            if(targetFile!=null){
                try {
                    targetFile.close();
                } catch (IOException e) {
                    logger.error("targetFile文件输出流关闭异常",e);
                }
            }
        }

        return "";
    }

}
