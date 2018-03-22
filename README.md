

## Socket Demo

每个branch分别以不同的方式实现socket连接，包含server端和client端代码。

阻塞IO的分支： master,feature/threadpool

非阻塞IO的分支： feature/selector

异步非阻塞IO的分支： feature/asyncSocketChannel

### master

a very simple socket demo.

### feature/threadpool

server socket handled in a ThreadPool.

### feature/selector

NIO example, register socketChannel on a selector

### feature/asyncSocketChannel

AIO example(Asynchronous Non-Blocking IO).Build a server with AsynchronousChannelGroup ,handle by ServerCompletionHandler in a ThreadPool.