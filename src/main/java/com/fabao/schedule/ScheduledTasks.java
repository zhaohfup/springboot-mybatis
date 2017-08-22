package com.fabao.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by bst on 2017/8/22.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每15分钟检查修复好需要分配的案件
     */
    @Scheduled(cron = "0 */15 * * * ?")
    public void caseAllocation() {

    }
}
