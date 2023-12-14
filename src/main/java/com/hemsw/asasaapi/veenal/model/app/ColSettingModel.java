package com.hemsw.asasaapi.veenal.model.app;

import com.hemsw.asasaapi.veenal.enums.SortOrderEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Entity
@Table(name = "col_setting")
public class ColSettingModel
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "menu_id")
	private int menuId;

	@Column(name = "col_key")
	private String colKey;

	@Column(name = "col_name")
	private String colName;

	@Column(name = "is_visible")
	private boolean isVisible;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "is_order_by")
	private boolean isOrderBy;

	@Column(name = "order_by_type_id")
	private int orderByTypeId;

	@Column(name = "order_by_seq_no")
	private int orderBySeqNo;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getMenuId()
	{
		return menuId;
	}

	public void setMenuId(int menuId)
	{
		this.menuId = menuId;
	}

	public String getColKey()
	{
		return colKey;
	}

	public void setColKey(String colKey)
	{
		this.colKey = colKey;
	}

	public String getColName()
	{
		return colName;
	}

	public void setColName(String colName)
	{
		this.colName = colName;
	}

	public boolean isIsVisible()
	{
		return isVisible;
	}

	public void setIsVisible(boolean isVisible)
	{
		this.isVisible = isVisible;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public void setSeqNo(int seqNo)
	{
		this.seqNo = seqNo;
	}

	public boolean isIsOrderBy()
	{
		return isOrderBy;
	}

	public void setIsOrderBy(boolean isOrderBy)
	{
		this.isOrderBy = isOrderBy;
	}

	public int getOrderByTypeId()
	{
		return orderByTypeId;
	}

	public void setOrderByTypeId(int orderByTypeId)
	{
		this.orderByTypeId = orderByTypeId;
	}

	public int getOrderBySeqNo()
	{
		return orderBySeqNo;
	}

	public void setOrderBySeqNo(int orderBySeqNo)
	{
		this.orderBySeqNo = orderBySeqNo;
	}

	public SortOrderEnum getOrderByType()
	{
		for (SortOrderEnum orderByType : SortOrderEnum.values())
		{
			if (orderByType.getId() == this.orderByTypeId)
			{
				return orderByType;
			}
		}
		return null;
	}

}
