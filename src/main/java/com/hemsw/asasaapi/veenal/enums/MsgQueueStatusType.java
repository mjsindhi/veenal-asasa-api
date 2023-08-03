package com.hemsw.asasaapi.veenal.enums;

public enum MsgQueueStatusType
{
	WAITING("Waiting", 1),
	SENDING("Sending", 2),
	SENT_WHATSAPP("Sent (WhatsApp)", 3),
	SENT_SMS("Sent (SMS)", 4),
	NOT_SENT("Not Sent", 5);

	private final String name;
	private final int id;

	private MsgQueueStatusType(String name, int s)
	{
		this.name = name;
		id = s;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public static MsgQueueStatusType getByName(String name)
	{
		for (MsgQueueStatusType msgQueueStatusType : values())
		{
			if (msgQueueStatusType.name.equals(name))
			{
				return msgQueueStatusType;
			}
		}
		return null;
	}

}
