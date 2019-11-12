package service;

import config.TestConfig;
import dao.impl.BossImpl;
import entity.BusinesspointAndNum;
import entity.Piao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})

public class TestBossService {
    @Autowired
    private BossImpl boss;

    @Test
    public void bosstest() {
        List<BusinesspointAndNum> businesspointAndNums = boss.searchBuAndNum("2019");
        System.out.println(businesspointAndNums);

    }
}
