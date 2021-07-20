package com.hcsummercamp.fdkdainaclient.Dao;

import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.CityOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.FloorOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.InquirePassedCity.MarketOutParam;
import com.hcsummercamp.fdkdainaclient.Entity.POJO.BaseBusinessInfo;
import org.springframework.stereotype.Repository;

import static com.hcsummercamp.fdkdainaclient.db.tables.BaseBusinessInfo.BASE_BUSINESS_INFO;

import java.util.List;

/**
 * @author ：YZJ
 * @date ：Created in 2021/7/20 10:37
 * @description：Dao
 * @modified By：
 * @version: 1.0$
 */
@Repository
public class base_business_info_Dao extends BasicDao{
    public List<FloorOutParam> findFloor(Long marketCode, Long cityCode){       //楼层查询
        return db.selectDistinct(BASE_BUSINESS_INFO.FLOOR_CODE,BASE_BUSINESS_INFO.FLOOR_NAME,BASE_BUSINESS_INFO.MARKET_CODE)
                .from(BASE_BUSINESS_INFO)
                .where(BASE_BUSINESS_INFO.MARKET_CODE.eq(marketCode).and(BASE_BUSINESS_INFO.CITY_CODE.eq(cityCode)))
                .fetchInto(FloorOutParam.class);
    }

    public List<MarketOutParam> findMarket(Long cityCode){  //市场查询
        List<MarketOutParam> res =  db.select(BASE_BUSINESS_INFO.CITY_CODE,BASE_BUSINESS_INFO.MARKET_CODE,BASE_BUSINESS_INFO.MARKET_CODE,
                BASE_BUSINESS_INFO.MARKET_NAME).from(BASE_BUSINESS_INFO)
                .where(BASE_BUSINESS_INFO.CITY_CODE.eq(cityCode)).groupBy(BASE_BUSINESS_INFO.MARKET_CODE,BASE_BUSINESS_INFO.MARKET_NAME)
                .fetchInto(MarketOutParam.class);
        for(MarketOutParam t : res){
            t.setFloorList(findFloor(t.getMarketCode(),cityCode));
            t.setMarketId(t.getMarketCode());
        }
        return res;
    }

    public List<CityOutParam> findCity(){       //城市查询 嵌套查询
        List<CityOutParam> res = db.selectDistinct(BASE_BUSINESS_INFO.CITY_CODE,BASE_BUSINESS_INFO.CITY_CODE,BASE_BUSINESS_INFO.CITY_NAME)
                .from(BASE_BUSINESS_INFO)
                .fetchInto(CityOutParam.class);
        for(CityOutParam t : res){
            t.setMarketList(findMarket(t.getCityCode()));
            t.setCityId(t.getCityCode());
        }
        return res;
    }

    public boolean BizExist(Long BizId){       //档口是否存在
        List<Integer> t = db.selectCount().from(BASE_BUSINESS_INFO)
                .where(BASE_BUSINESS_INFO.BUSINESS_CODE.eq(BizId)).fetchInto(Integer.class);
        return t.get(0) > 0;
    }

    public BaseBusinessInfo getInfo(Long BizId){
        return db.select().from(BASE_BUSINESS_INFO)
                .where(BASE_BUSINESS_INFO.BUSINESS_CODE.eq(BizId)).fetchInto(BaseBusinessInfo.class).get(0);
    }
}
