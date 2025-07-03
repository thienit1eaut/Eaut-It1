package listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

    private static int requestCount = 0;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {}

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        requestCount++;
        System.out.println("Số yêu cầu đã nhận được: " + requestCount);
    }
}
