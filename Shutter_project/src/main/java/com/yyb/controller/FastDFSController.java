package com.yyb.controller;

import com.yyb.entity.RespBean;
import com.yyb.entity.RespStringBean;
import com.yyb.entity.RespTableBean;
import lombok.extern.log4j.Log4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@Log4j
public class FastDFSController {

    @Value("${http_imgUrl}")
    private String http_imgUrl = null;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespStringBean upload(@RequestParam MultipartFile file) {
        RespStringBean rsb = new RespStringBean();
        try {
            if(file.isEmpty()){
                rsb.setCode(RespStringBean.ERROR);
                rsb.setMsg("文件不能为空！");
            }else{
                //blog.csdn.net/moshowgame
                String conf_filename = this.getClass().getClassLoader().getResource("fdfs_client.conf").getPath().replaceAll("%20"," ");
                System.out.println(conf_filename);
                String tempFileName = file.getOriginalFilename();
                //fastDFS方式
                ClientGlobal.init(conf_filename);

                byte[] fileBuff = file.getBytes();
                String fileId = "";
                String fileExtName = tempFileName.substring(tempFileName.lastIndexOf("."));

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

                //上传文件，获得fileId
                fileId = client.upload_file1(fileBuff, fileExtName, metaList);
                //TODO 这里可以追加一些业务代码，例如上传成功后保存到upload_file表，统一进行上传文件管理之类
                rsb.setCode(RespStringBean.SUCCESS);
                rsb.setMsg("文件上传成功！");
                rsb.setData(http_imgUrl + fileId);
            }

        } catch (Exception e) {
            e.printStackTrace();
            rsb.setCode(RespStringBean.ERROR);
            rsb.setMsg("系统错误，文件上传失败！");
        }
        return rsb;
    }

}
