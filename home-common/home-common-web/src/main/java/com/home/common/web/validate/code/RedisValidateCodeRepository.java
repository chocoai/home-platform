package com.home.common.web.validate.code;

import com.home.common.core.constant.HomeConstant;
import com.home.common.web.validate.code.ValidateCode;
import com.home.common.web.validate.code.ValidateCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 将验证码存储到Redis中
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-24 18:05
 **/
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void save(String random, ValidateCode code) {
        redisTemplate.opsForValue().set(HomeConstant.VALIDATE_CODE_PREFIX + random, code, 30, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(String random) {
        Object code = redisTemplate.opsForValue().get(HomeConstant.VALIDATE_CODE_PREFIX + random);
        if (null == code) {
            return null;
        }
        return (ValidateCode) code;
    }

    @Override
    public void remove(String random) {
        redisTemplate.delete(HomeConstant.VALIDATE_CODE_PREFIX + random);
    }

}
