package com.vilderlee.thread.spring;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述:
 *
 * @package com.vilderlee.thread
 * @auther vilderlee
 * @date 2019-01-12 14:39
 */
public class ThreadTest implements Runnable {

        private Process process;
        private Instansce instansce;

        public ThreadTest(Process process) {
            this.process = process;
            instansce = Environment.context.getBean(Instansce.class);
        }

        @Override
        public void run() {
            instansce.process(process);
        }



    public static void main(String[] args) {

        Environment.init();

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int j = 0; j < 100; j++) {

            for (int i = 0; i < 3; i++) {

                Process process = new Process();
                process.setNum(i);
                ThreadTest threadTest = new ThreadTest(process);

                service.execute(threadTest);

            }
        }


        service.shutdown();
    }


}
