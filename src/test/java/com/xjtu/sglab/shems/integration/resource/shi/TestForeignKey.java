package com.xjtu.sglab.shems.integration.resource.shi;

import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

import com.google.gson.Gson;
import com.xjtu.sglab.shems.dao.IBoxDAO;
import com.xjtu.sglab.shems.dao.IRoomDAO;
import com.xjtu.sglab.shems.entity.Lamp;
import com.xjtu.sglab.shems.entity.LampStatus;
import com.xjtu.sglab.shems.util.GsonJsonProvider;
import com.xjtu.sglab.shems.util.GsonUtil;

public class TestForeignKey {
	
	@Resource
    IBoxDAO BoxDAO;
	@Resource
	IRoomDAO RoomDAO;
	@Resource
	LampStatus LampStatusDAO;
	private static final String LOCAL_HOST_IP="192.168.1.6";
	private static final String LOOP_IP="localhost";
	private static final String REMOTE_HOST_IP="202.117.14.247";
//	private static final String HOST_IP = REMOTE_HOST_IP;    //远程用
	private static final String HOST_IP = LOOP_IP;           //本机测试用

	@Test
	public void testSaveLampInfo() throws JsonGenerationException,JsonMappingException, IOException {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(GsonJsonProvider.class);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client
				.target("http://"+HOST_IP+":8080/smarthome/appliance/lamp");
		Builder request = webTarget.request();
		
		int lampid = 1;	
		LampStatus lampStatus = new LampStatus();
		lampStatus.setIsControlledByUser(true);
		lampStatus.setLampStatus(2);
//		Lamp lamp = new Lamp();
//		lamp.setLampId(lampid);
//		lampStatus.setLamp(lamp);
		lampStatus.setIsAlreadyControlled(true);
		lampStatus.setLampStatusRecordTime(new Timestamp(System.currentTimeMillis()));
		
     	Gson gson = GsonUtil.create();
		String tmpstr = gson.toJson(lampStatus, LampStatus.class);
		System.out.println(tmpstr);	
		Response response = request.post(Entity.entity(lampStatus,
				MediaType.APPLICATION_JSON));
		String str = response.readEntity(String.class);
		System.out.println(str);
}
}
