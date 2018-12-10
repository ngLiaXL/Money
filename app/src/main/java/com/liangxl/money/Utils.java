package com.liangxl.money;

import java.io.OutputStream;

public class Utils {


    /**执行adb命令，需要已经为应用分配过root权限
     * @param adbCommand
     */
    public static void execAdb(String adbCommand) {
        OutputStream os = null;
        try {
            //获取与之相关的输出流
            os =  Runtime.getRuntime().exec("su").getOutputStream();
            os.write(adbCommand.getBytes());
            os.write(("exit\n").getBytes());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
            }
        }
    }

}
