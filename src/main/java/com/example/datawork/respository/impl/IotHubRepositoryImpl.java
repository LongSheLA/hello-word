package com.example.datawork.respository.impl;

import com.example.datawork.entity.MessageEntity;
import com.example.datawork.respository.CustomIotHubRepository;
import com.example.datawork.utils.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author dongdong.jiang
 */
@Transactional(rollbackOn = Exception.class)
public class IotHubRepositoryImpl implements CustomIotHubRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MessageEntity> findMessageByNameOrTime(String name, String startTime, String endTime) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from s_iot_hub_test.t_message_entity where ");
        if(!StringUtils.isBlank(name)){
            sb.append("name = '").append(name).append("' and ");
        }
        if(!StringUtils.isBlank(startTime)){
            sb.append("ts >= '").append(startTime).append("' and ");
        }
        sb.append("ts < '").append(endTime).append("'");

        System.out.println(sb.toString());
        Query nativeQuery = entityManager.createNativeQuery(sb.toString(),MessageEntity.class);
        entityManager.close();
        return  nativeQuery.getResultList();
    }
}
