import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static int PORT = 8379;
    private static String IP = "127.0.0.1";

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        Socket socket = null;
        try {
            socket = new Socket(IP, PORT);
            //autoFlush: if true, the println,printf or format methods will flush the output buffer
            //使用printWriter将信息写到输出流中
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //由于autoFlush为true，printWriter使用println会在写入outputStream后立即flush，服务端会马上从inputStream中读到消息
            printWriter.println("客户端请求了服务器....");
            String response = bufferedReader.readLine();
            System.out.println("Client：" + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                socket = null;
            }
        }
    }
}
