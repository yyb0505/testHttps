package com.yyb.util;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadFileUtil {

    private static String http_imgUrl = "http://192.168.64.134/";

    public static Map<String,Object> UploadFile(MultipartFile file) throws Exception {

        String conf_filename = UploadFileUtil.class.getClassLoader().getResource("fdfs_client.conf").getPath().replaceAll("%20", " ");
        System.out.println("-=-=-=-=-=-:"+conf_filename);
        ClientGlobal.init(conf_filename);

        byte[] fileBuff = file.getBytes();
        String tempFileName = file.getOriginalFilename();
        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);

        //建立连接
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = tracker.getStoreStorage(trackerServer);
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        //设置元信息
        NameValuePair[] metaList = new NameValuePair[3];
        metaList[0] = new NameValuePair("fileName", tempFileName);
        metaList[1] = new NameValuePair("fileExtName", fileExtName);
        metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
        String fileId  = client.upload_file1(fileBuff, fileExtName, metaList);

        Map map = new HashMap();
        map.put("path",http_imgUrl + fileId);
        map.put("size",file.getSize());
        map.put("type",fileExtName);

        return map;
    }

}
