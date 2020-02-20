package cn.sgwks.test;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * Tracker（集群）:调度（帮你找到有空闲的Storage）
 * Storage（集群）：文件存储（帮你保存文件或获取需要的文件）
 */
public class TestFastDFS {
    public static void main(String[] args) throws Exception {
        insert();
    }

    private static void insert() throws Exception {
        //1. 加载配置文件
        ClientGlobal.init("D:\\Text Work\\IDEA\\WorkSpace\\fastDFSDemo\\src\\main\\resources\\fdfs_client.conf");
        //2. 创建管理端对象
        TrackerClient trackerClient = new TrackerClient();
        //3. 通过管理端对象获取连接
        TrackerServer connection = trackerClient.getConnection();
        StorageClient1 storageClient = new StorageClient1(connection,null);
        //创建文件属性信息对象数组
//        NameValuePair[] meta_list = new NameValuePair[2];
//        meta_list[0] = new NameValuePair("name","华为手机");
//        meta_list[1] = new NameValuePair("money","$3999");
        NameValuePair[] meta_list = new NameValuePair[3];
        meta_list[0] = new NameValuePair("name","智能手环");
        meta_list[1] = new NameValuePair("color","black");
        meta_list[2] = new NameValuePair("brand","nokia");
        //5. 上传文件
        String path = storageClient.upload_file1("C:\\Users\\acer\\Pictures\\nokia.jpg","jpg",meta_list);
        System.out.println(path);//group1/M00/00/01/wKjIgF41fuqAT41AAAMUWy6v-y8284.jpg
    }

    /**
     * 删除图片
     * @throws Exception
     */
    private static void delete() throws Exception {
        //1. 加载配置文件
        ClientGlobal.init("D:\\Text Work\\IDEA\\WorkSpace\\fastDFSDemo\\src\\main\\resources\\fdfs_client.conf");
        //2. 创建管理端对象
        TrackerClient trackerClient = new TrackerClient();
        //3. 通过管理端对象获取连接
        TrackerServer connection = trackerClient.getConnection();
        StorageClient1 storageClient = new StorageClient1(connection,null);
        storageClient.delete_file1("group1/M00/00/01/wKjIgF41epKEVvPjAAAAADAbeFk310.png");
    }
}
