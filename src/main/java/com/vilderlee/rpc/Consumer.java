package com.vilderlee.rpc;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/21      Create this file
 * </pre>
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = (HelloService) ConsumerFactory.refer(HelloService.class);

        HelloRequest request = new HelloRequest();
        new Thread(new Runnable() {
            @Override public void run() {
                request.setAge(1);
                request.setName("lichao1");
                HelloResponse response= helloService.doBusiness(request);
                System.out.println(response.getResponseMsg());
            }
        }).start();


        new Thread(new Runnable() {
            @Override public void run() {
                request.setAge(2);
                request.setName("lichao2");
                HelloResponse response= helloService.doBusiness(request);
                System.out.println(response.getResponseMsg());
            }
        }).start();


        new Thread(new Runnable() {
            @Override public void run() {
                request.setAge(3);
                request.setName("lichao3");
                HelloResponse response= helloService.doBusiness(request);
                System.out.println(response.getResponseMsg());
            }
        }).start();

    }
}
