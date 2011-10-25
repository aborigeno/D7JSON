package net.aborigeno.android.json.dupal;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class FileFieldLoc {
	
	private int fid;
	private Long timestamp, filesize;
	private String filename,filemime, uri;
	public FileFieldLoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Long getFilesize() {
		return filesize;
	}
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilemime() {
		return filemime;
	}
	public void setFilemime(String filemime) {
		this.filemime = filemime;
	}
	public String getUri() {
		return uri;
	}	
	public String getFullUri(String location) {
		return uri.replace("public:/", location);
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public InputStream getInputStream(String baseUrl){
		InputStream content = null;
  	  try {
  	    HttpClient httpclient = new DefaultHttpClient();
  	    
  	    HttpResponse response = httpclient.execute(new HttpGet(getFullUri(baseUrl)));
  	    content = response.getEntity().getContent();
  	  } catch (Exception e) {
  	    Log.d("[GET REQUEST]", "Network exception "+e.getMessage());
  	    e.printStackTrace();
  	  }
  	    return content;
	}
	
	
}
