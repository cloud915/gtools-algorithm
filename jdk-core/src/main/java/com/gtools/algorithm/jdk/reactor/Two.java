package com.gtools.algorithm.jdk.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description 基本的NIO-Reactor模型，在One模型下，增加Reactor角色，负责监听事件，并分发处理
 * @Author ghy
 * @Date 2020/1/15 10:40
 */
public class Two {

    /**
     * 关于Reactor模式的一些概念：
     * 1、Reactor：负责响应IO事件，当检测到一个新的事件，将其发送给相应的Handler去处理
     * 2、Handler：负责处理非阻塞的行为，标识系统管理的资源，同时将Handler与事件绑定。
     *
     * Reactor为单个线程，需要处理accept连接，同时发送请求到处理器中
     * 由于只有单个线程，所以处理器中的业务需要能够快速处理完成。
     *
     * 改进：使用多线程处理业务逻辑，建Three
     *
     * 理解
     * 在Two这个示例中，虽然Reactor和Handler都实现了Runnable，但只是为了适应NIO的api
     * 在执行过程中，Reactor和Handler可能都是一一绑定的，进而导致Three中将Handler线程池化。
     */

    static class Reactor implements Runnable {
        final Selector selector;
        final ServerSocketChannel serverSocketChannel;

        Reactor(int port) throws IOException {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);//非阻塞
            SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);// 分步处理，接收Accept事件
            sk.attach(new Acceptor());// attach callback object,Acceptor,注册callback对象
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    selector.select();
                    Set selected = selector.selectedKeys();
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        dispatch((SelectionKey) it.next());// Reactor负责dispatch收到的事件
                    }
                    selected.clear();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void dispatch(SelectionKey key) {
            Runnable r = (Runnable) key.attachment();// 调用之前注册的callback对象
            if (r != null)
                r.run();
        }

        class Acceptor implements Runnable {

            @Override
            public void run() {
                try {
                    SocketChannel c = serverSocketChannel.accept();
                    if (c != null) {
                        new Handler(selector, c);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    final static class Handler implements Runnable {
        final SocketChannel socket;
        final SelectionKey sk;
        int MAXIN = 1024;
        int MAXOUT = 1024;
        ByteBuffer input = ByteBuffer.allocate(MAXIN);
        ByteBuffer output = ByteBuffer.allocate(MAXOUT);
        static final int READING = 0, SENDING = 1;
        int state = READING;

        public Handler(Selector sel, SocketChannel c) throws IOException {
            this.socket = c;
            c.configureBlocking(false);
            sk = socket.register(sel, 0);
            sk.attach(this);
            sk.interestOps(SelectionKey.OP_READ);
            sel.wakeup();
        }

        boolean inputIsComplete() {
            /* ... */
            return true;
        }

        boolean outputIsComplete() {
            /* ... */
            return true;
        }

        void process() {
        }

        @Override
        public void run() {
            try {
                if (state == READING) read();
                else if (state == SENDING) send();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void read() throws IOException {
            socket.read(input);
            if (inputIsComplete()) {
                process();
                state = SENDING;
                sk.interestOps(SelectionKey.OP_WRITE); // 第三步，接收wirte事件
            }
        }

        private void send() throws IOException {
            socket.write(output);
            if (outputIsComplete()) sk.channel();// write完，就结束了，关闭 select key
        }
    }

    //上面 的实现用Handler来同时处理Read和Write事件, 所以里面出现状态判断
    //我们可以用State-Object pattern来更优雅的实现
    /*class Handler2 {
        // ...
        public void run() { // initial state is reader
            socket.read(input);
            if (inputIsComplete()) {
                process();
                sk.attach(new Sender());  //状态迁移, Read后变成write, 用Sender作为新的callback对象
                sk.interest(SelectionKey.OP_WRITE);
                sk.selector().wakeup();
            }
        }
        class Sender implements Runnable {
            public void run(){ // ...
                socket.write(output);
                if (outputIsComplete()) sk.cancel();
            }
        }
    }*/


}
