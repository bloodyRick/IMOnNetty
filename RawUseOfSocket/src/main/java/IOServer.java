import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author by woyuan  2022/2/25
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8000);
        //起一个新线程，接收连接
        new Thread(()->{
            while (true) {
                try {
                    //阻塞的方式获得新连接
                    Socket socket = serverSocket.accept();

                    //每个连接创建一个新线程，处理数据
                    new Thread(()->{
                        int len;
                        try {
                            byte[] data = new byte[1024];
                            InputStream is = socket.getInputStream();

                            while ((len = is.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
