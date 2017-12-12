package com.code.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Upload {
    private MultipartFile file;

    public Upload(MultipartFile file) {
        this.file = file;
    }

    public Boolean save(String path, String fileName) {
        File targetFile = new File(Conf.UPLOAD_DIR + path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    /**
     * 返回相对路径,绝对路径
     *
     * @param path
     * @param fileName
     * @return
     */
    public Map<String, String> saveFile(String path, String fileName) {
        Map<String, String> map = new HashMap<>();
        String url = "";
        File targetFile = new File(Conf.UPLOAD_DIR + path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            url = "upload/" + path + fileName;
            //相对路径
            map.put("relativeUrl", url);
            //绝对路径
            map.put("absoluteUrl", targetFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 返回相对路径,绝对路径
     *
     * @param path
     * @param fileName
     * @return
     */
    public Map<String, String> saveFilePath(String path, String fileName) {
        Map<String, String> map = new HashMap<>();
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
            String absolutePath = targetFile.getAbsolutePath();
            //绝对路径
            map.put("absoluteUrl", absolutePath);
            map.put("fileName", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
