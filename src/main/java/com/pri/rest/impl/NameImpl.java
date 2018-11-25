/**
 * 
 */
package com.pri.rest.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.*;

import com.pri.rest.common.ApplicationConstants;
import com.pri.rest.vo.RequestVO;
import com.pri.rest.vo.ResponseVO;

/**
 * @author coder
 *
 */
public class NameImpl implements ApplicationConstants{

	public ResponseVO constructResponse(String request) {

		ResponseVO vo = new ResponseVO();

		String name = null;

		if (request != null) {
			
		try {
				name = constructRequestVo(request);
			} catch (JsonParseException e) {
				e.printStackTrace();
				vo.setStatus(EXCEPTION);
				vo.setMessage(EX_MSG1);
			} catch (JsonMappingException e) {
				e.printStackTrace();
				vo.setStatus(EXCEPTION);
				vo.setMessage(EX_MSG2);
			} catch (IOException e) {
				e.printStackTrace();
				vo.setStatus(EXCEPTION);
				vo.setMessage(EX_MSG3);
			}
		
		}
		
		if(name==null) {
			
			vo.setStatus(FAILUTRE);
			vo.setMessage(FAILURE_MSG);

		} else {
			
			vo.setStatus(SUCCESS);
			vo.setMessage(SUCCESS_MSG);
			
			long time = System.currentTimeMillis();

			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
			Date resultdate = new Date(time);
			String date = sdf.format(resultdate);
			
			if (StringUtils.isNotBlank(name)) {
				vo.setName(name);
			}

			if (resultdate != null) {
				vo.setTime(date);
			}
		}

		return vo;
	}

	private String constructRequestVo(String request) throws JsonParseException, JsonMappingException, IOException  {
		
		if(StringUtils.isNotBlank(request)) {
			
			ObjectMapper mapper = new ObjectMapper();
			
			RequestVO root = mapper.readValue(request, RequestVO.class);
			
			if(root!=null) {
				System.out.println(root.toString()+" root"+root.getName());
			}else {
				System.out.println("NUll--------");
			}
			
			return root.getName();
			
		}else {
			
			return FAILUTRE;
		}
		
	}

	public ResponseVO constructResponse(RequestVO request) {
		
		ResponseVO vo = new ResponseVO();
		
		if(request==null) {
			
			vo.setStatus(FAILUTRE);
			vo.setMessage(FAILURE_MSG);

		} else {
			
			vo.setStatus(SUCCESS);
			vo.setMessage(SUCCESS_MSG);
			
			long time = System.currentTimeMillis();

			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
			Date resultdate = new Date(time);
			String date = sdf.format(resultdate);
			
			if (StringUtils.isNotBlank(request.getName())) {
				vo.setName(request.getName());
			}
			if (resultdate != null) {
				vo.setTime(date);
			}
		}

		return vo;
	}

}

