package com.vilderlee.quartz.command;

import com.vilderlee.quartz.entity.ProcessControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/29      Create this file
 * </pre>
 */
@Service("check")
public class CheckAccount extends AbstractCommand {

    @Value("1")
    private int step;

    @Autowired
    @Qualifier(value = "collect")
    private AbstractCommand abstractCommand;



    @Override public void execute(int step) {

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (this.step != step) {
            super.setAbstractCommand(abstractCommand);
            super.abstractCommand.execute(step);
        } else {
            System.out.println("这里可以做啊");
        }
    }


}
