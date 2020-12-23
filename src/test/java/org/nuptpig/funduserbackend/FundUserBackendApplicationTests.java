package org.nuptpig.funduserbackend;

import org.junit.jupiter.api.Test;
import org.nuptpig.funduserbackend.util.CommonResult;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FundUserBackendApplicationTests {

    protected <T> T getVo(ResponseEntity responseEntity){
        CommonResult commonResult = (CommonResult) responseEntity.getBody();
        return (T) commonResult.getData();
    }

    @Test
    void contextLoads() {
    }

}
