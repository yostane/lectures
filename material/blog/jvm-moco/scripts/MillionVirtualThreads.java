void main(String... args) {
    Set<Long> uniqueThreadNames = ConcurrentHashMap.newKeySet();
    for (int i = 0; i < 1_000_000; i++) {
        Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(1000);
                uniqueThreadNames.add(Thread.currentThread().threadId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    try {
        // Wait for all the virtual threads to finish
        Thread.sleep(10000);
    } catch (Exception e) {
        e.printStackTrace();
    }
    IO.println(uniqueThreadNames.size());
}
