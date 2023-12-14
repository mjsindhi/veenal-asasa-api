package com.hemsw.asasaapi.veenal.helper;

import com.hemsw.asasaapi.veenal.dao.gen.UnitDao;
import com.hemsw.asasaapi.veenal.enums.UnitOperatorType;
import com.hemsw.asasaapi.veenal.model.gen.UnitModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;

public class UnitHelper
{

	@Autowired
	private static UnitDao unitDao;

	public static BigDecimal convert(BigDecimal srcQty, int srcUnitId, int destUnitId)
	{
		BigDecimal data = null;
		data = convertNonTx(srcQty, srcUnitId, destUnitId);
		return data;
	}

	public static BigDecimal convertNonTx(BigDecimal srcQty, int srcUnitId, int destUnitId)
	{
		BigDecimal destQty = null;

		if (srcUnitId == destUnitId)
		{
			destQty = srcQty;
		}
		else
		{

			UnitModel srcUnitModel = unitDao.getById(srcUnitId);
			UnitModel destUnitModel = unitDao.getById(destUnitId);

			// Km to meter | 1km = 1000 x m
			// cm to meter | 1cm = 1 / 100 m
			if (srcUnitModel.isDerived() && !destUnitModel.isDerived())
			{
				if (srcUnitModel.getUnitOperatorType() == UnitOperatorType.MULTIPLY)
				{
					destQty = srcQty.multiply(srcUnitModel.getNum());
				}
				else if (srcUnitModel.getUnitOperatorType() == UnitOperatorType.DIVIDE)
				{
					destQty = srcQty.divide(srcUnitModel.getNum(), 2, RoundingMode.HALF_UP);
				}
			}
			// meter to km | 1km = 1000 x m
			// meter to cm | 1cm = 1 / 100 m
			else if (!srcUnitModel.isDerived() && destUnitModel.isDerived())
			{
				if (destUnitModel.getUnitOperatorType() == UnitOperatorType.MULTIPLY)
				{
					destQty = srcQty.divide(destUnitModel.getNum(), 2, RoundingMode.HALF_UP);
				}
				else if (destUnitModel.getUnitOperatorType() == UnitOperatorType.DIVIDE)
				{
					destQty = srcQty.multiply(destUnitModel.getNum());
				}
			}
			else if (srcUnitModel.isDerived() && destUnitModel.isDerived())
			{
				// meter to kilo meter | 1Km = 1000 x m
				// meter to Million meter | 1Mm = 1 000 000 x m
				if (srcUnitModel.getUnitOperatorType() == UnitOperatorType.MULTIPLY
						&& destUnitModel.getUnitOperatorType() == UnitOperatorType.MULTIPLY)
				{
					destQty = srcQty.multiply(srcUnitModel.getNum())
							.divide(destUnitModel.getNum(), 2, RoundingMode.HALF_UP);
				}
				// meter to kilo meter | 1Km = 1000 x m
				// meter to centi meter | 1cm = 1 / 100 x m
				else if (srcUnitModel.getUnitOperatorType() == UnitOperatorType.MULTIPLY
						&& destUnitModel.getUnitOperatorType() == UnitOperatorType.DIVIDE)
				{
					destQty = srcQty.multiply(srcUnitModel.getNum())
							.multiply(destUnitModel.getNum());
				}
				// meter to centi meter | 1cm = 1 / 100 x m
				// meter to kilo meter | 1Km = 1000 x m
				else if (srcUnitModel.getUnitOperatorType() == UnitOperatorType.DIVIDE
						&& destUnitModel.getUnitOperatorType() == UnitOperatorType.MULTIPLY)
				{
					destQty = srcQty.divide(srcUnitModel.getNum().multiply(destUnitModel.getNum()), 2, RoundingMode.HALF_UP);
				}
				// meter to centi meter | 1cm = 1 / 100 x m
				// meter to mili meter | 1mm = 1 / 1000 x m
				else if (srcUnitModel.getUnitOperatorType() == UnitOperatorType.DIVIDE
						&& destUnitModel.getUnitOperatorType() == UnitOperatorType.DIVIDE)
				{
					destQty = srcQty.multiply(destUnitModel.getNum())
							.divide(srcUnitModel.getNum(), 2, RoundingMode.HALF_UP);
				}
			}
		}
		return destQty;
	}
}
