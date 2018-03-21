

## Socket Demo

每个branch分别以不同的方式实现socket通讯，包含server端和client端代码。

阻塞IO的分支： master,feature/threadpool

非阻塞IO的分支： feature/selector

### master

a very simple socket demo.

### feature/threadpool

server socket handle in a TreadPool.

### feature/selector

NIO example, register socketChannel on a selector