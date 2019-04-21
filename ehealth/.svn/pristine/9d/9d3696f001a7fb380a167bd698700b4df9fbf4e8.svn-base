// SMSLib for Java v3
// A Java API library for sending and receiving SMS via a GSM modem
// or other supported gateways.
// Web Site: http://www.smslib.org
//
// Copyright (C) 2002-2009, Thanasis Delenikas, Athens/GREECE.
// SMSLib is distributed under the terms of the Apache License version 2.0
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.smslib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * The class implements the central Queue Manager.
 *
 */
public class QueueManager
{
	HashMap<String, PriorityBlockingQueue<OutboundMessage>> queueMap;
	Service service;

	public QueueManager(Service service)
	{
		setQueueMap(new HashMap<String, PriorityBlockingQueue<OutboundMessage>>());
		setService(service);
	}

	public void init()
	{
	}

	public void done()
	{
	}

	public boolean queueMessage(OutboundMessage msg)
	{
		if (msg.getGatewayId().length() > 1) return (getGatewayQueue(msg.getGatewayId()).add(msg));
		else
		{
			AGateway gateway = getService().routeMessage(msg);
			if (gateway != null) return (getGatewayQueue(gateway.getGatewayId()).add(msg));
			else return false;
		}
	}

	public boolean removeMessage(OutboundMessage msg)
	{
		for (PriorityBlockingQueue<OutboundMessage> q : getQueueMap().values())
		{
			if (q.remove(msg)) return true;
		}
		return false;
	}

	public int getQueueLoad()
	{
		int load = 0;

		for (PriorityBlockingQueue<OutboundMessage> q : getQueueMap().values())
		{
			load += q.size();
		}
		return load;
	}

	public int getQueueLoad(String gatewayId)
	{
		if (getQueueMap().containsKey(gatewayId)) return getQueueMap().get(gatewayId).size();
		else return 0;
	}

	public int getQueueLoad(int priority)
	{
		int load = 0;

		for (PriorityBlockingQueue<OutboundMessage> q : getQueueMap().values())
		{
			ArrayList<OutboundMessage> msgList = new ArrayList<OutboundMessage>();
			q.drainTo(msgList);
			for (OutboundMessage msg : msgList)
				if (msg.getPriority() == priority) load ++;
		}
		return load;
	}

	public int getQueueLoad(String gatewayId, int priority)
	{
		int load = 0;

		if (getQueueMap().containsKey(gatewayId))
		{
			PriorityBlockingQueue<OutboundMessage> q = getQueueMap().get(gatewayId);
			ArrayList<OutboundMessage> msgList = new ArrayList<OutboundMessage>();
			q.drainTo(msgList);
			for (OutboundMessage msg : msgList)
				if (msg.getPriority() == priority) load ++;
			return load;
		}
		else return 0;
	}

	public void clearQueue(String gatewayId)
	{
		PriorityBlockingQueue<OutboundMessage> q = getQueueMap().get(gatewayId);
		if (q != null) q.clear();
	}

	public void clearQueues()
	{	
		for (PriorityBlockingQueue<OutboundMessage> q : getQueueMap().values())
		{
			q.clear();
		}
	}

	protected PriorityBlockingQueue<OutboundMessage> getGatewayQueue(String gatewayId)
	{
		PriorityBlockingQueue<OutboundMessage> q;

		if (getQueueMap().containsKey(gatewayId)) q = getQueueMap().get(gatewayId);
		else
		{
			q = new PriorityBlockingQueue<OutboundMessage>(50, new Comparator<OutboundMessage>()
				{
					public int compare(OutboundMessage x, OutboundMessage y)
					{
						int comp = y.getPriority() - x.getPriority();
						if (comp == 0) comp = x.getDate().compareTo(y.getDate());
						return comp;
					}
				}
			);
			getQueueMap().put(gatewayId, q);
		}
		return q;
	}

	protected HashMap<String, PriorityBlockingQueue<OutboundMessage>> getQueueMap()
	{
		return queueMap;
	}

	protected void setQueueMap(HashMap<String, PriorityBlockingQueue<OutboundMessage>> queueMap)
	{
		this.queueMap = queueMap;
	}

	protected Service getService()
	{
		return service;
	}

	protected void setService(Service service)
	{
		this.service = service;
	}
}
