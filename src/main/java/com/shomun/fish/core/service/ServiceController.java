package com.shomun.fish.core.service;

import com.shomun.fish.core.exception.ApplicationException;
import com.shomun.fish.core.exception.SystemException;

public interface ServiceController {

	void init()throws SystemException,ApplicationException;
	
	void start()throws SystemException,ApplicationException;
	
	void stop()throws SystemException,ApplicationException;
}
