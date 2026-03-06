///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+

void main(String... args) {
    // Platform (or OS) thread
    Thread.ofPlatform().start(() -> {
        IO.println(Thread.currentThread());
    });

    // Virtual thread
    Thread.ofVirtual().start(() -> {
        IO.println(Thread.currentThread());
    });

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e){

    }
}
