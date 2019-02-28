package com.vilderlee.spi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/25      Create this file
 * </pre>
 */
public class URLTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("dubbo://169.254.46.252:9999/cpcn.payment.fundoutcenter.api.rpc"
                + ".FundOutCenterTransferService?accepts=1000&anyhost=true&application=FundOutCenter&default.delay=-1&default.version=1.0.0&delay=-1&dubbo=2.0.1&executes=500&generic=false&interface=cpcn.payment.fundoutcenter.api.rpc.FundOutCenterTransferService&methods=tx2004&organization=cpcn&owner=FundOutCenter&pid=8512&revision=SNAPSHOT&side=provider&threadpool=cached&timeout=15000&timestamp=1551062098990&version=1.0.0");
        TimeUnit.SECONDS.sleep(1000000);
    }
}
