package org.yeyz.fourm.method;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import org.yeyz.fourm.dto.GitHubUser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class SendMethod {
	
	// 第三方post方法

	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	OkHttpClient client = new OkHttpClient();
	public String OkPost(String url, String data) {
		RequestBody body = RequestBody.create(data, JSON);
		Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return data;
	}
		
		
	//获取用户信息
	public GitHubUser getUser(String access_token) {

		// 和上面不同 获取用户信息 不需要 也不能有 body
		Request request = new Request.Builder()
				.url("https://api.github.com/user")
				.header("Authorization","token "+access_token)
				.build();
		try (Response response = client.newCall(request).execute()) {

			//不是 toString() , 是 string()
			String result = response.body().string();
			GitHubUser user = com.alibaba.fastjson.JSON.parseObject(result, GitHubUser.class);
			return user;
			 
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
