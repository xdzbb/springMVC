package com.mvc.util;

import java.io.BufferedInputStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class DFSTracker {
	private TrackerClient trackerClient;

	public DFSTracker() {
		// 连接超时的时限，单位为毫秒
		ClientGlobal.setG_connect_timeout(2000);
		// 网络超时的时限，单位为毫秒
		ClientGlobal.setG_network_timeout(30000);
		ClientGlobal.setG_anti_steal_token(false);
		// 字符集
		ClientGlobal.setG_charset("UTF-8");
		ClientGlobal.setG_secret_key(null);
		// HTTP访问服务的端口号
		ClientGlobal.setG_tracker_http_port(7271);
	}

	public TrackerClient getTrackerClient() {
		return trackerClient;
	}

	public void setTrackerClient(TrackerClient trackerClient) {
		this.trackerClient = trackerClient;
	}

	// 上传图片
	public String upload(FileItem fileItem) {
		String result = null;
		try {
			// 文件长度
			int fileLength = fileItem.getInputStream().available();
			// 上传的文件名
			String fileName = fileItem.getName().substring(0,
					fileItem.getName().lastIndexOf(".") - 1);
			// 上传的后缀名
			String fileExtName = fileItem.getName().substring(
					fileItem.getName().lastIndexOf(".") + 1);
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			StorageClient1 client = new StorageClient1(trackerServer, storageServer);
			NameValuePair[] metaList = new NameValuePair[3];
			metaList[0] = new NameValuePair("fileName", fileName);
			metaList[1] = new NameValuePair("fileExtName", fileExtName);
			metaList[2] = new NameValuePair("fileLength", String.valueOf(fileLength));
			byte[] fileBuf = fechFileToByetArray(fileItem.getInputStream());
			if (fileBuf != null) {
				result = client.upload_file1(fileBuf, fileExtName, metaList);
			}
			trackerServer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private byte[] fechFileToByetArray(InputStream is) throws Exception {
		// 把内容读取到内存中
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		int result = 0;
		byte[] buff = new byte[1024];
		BufferedInputStream bis = new BufferedInputStream(is);
		while ((result = bis.read(buff)) != -1) {
			bout.write(buff, 0, result);
		}
		return bout.toByteArray();

	}

	public void deleteFIleFromFastDfs(String path) {
		// 存在招商广告，则删除原来的招商广告,保存新的招商广告
		try {
			if (path != null && !"".equals(path)) {
				TrackerServer trackerServer = trackerClient.getConnection();
				StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
				StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
				storageClient1.delete_file1(path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	// 将本地文件上传到FastDFS中
	public String uploadLocalFileToDFS(String path) {
		if (path != null && !"".equals(path)) {
			try {
				TrackerServer trackerServer = trackerClient.getConnection();
				StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
				StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
				// 获取文件名
				String fileName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
				// 获取文件的扩展名
				String file_ext_name = path.substring(path.lastIndexOf(".") + 1);
				// 将文件变为文件流
				InputStream is = new FileInputStream(new File(path));
				NameValuePair[] metaList = new NameValuePair[3];
				metaList[0] = new NameValuePair("fileName", fileName);
				metaList[1] = new NameValuePair("fileExtName", file_ext_name);
				metaList[2] = new NameValuePair("fileLength", String.valueOf(is.available()));
				String file_id = storageClient1.upload_file1(path, file_ext_name, metaList);
				trackerServer.close();
				is.close();
				return file_id;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
