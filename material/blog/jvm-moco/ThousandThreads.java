void main(String... args) {
    Set<Long> uniqueThreadNames = ConcurrentHashMap.newKeySet();
    for (int i = 0; i < 1000; i++) {
        new Thread(() -> {
            try {
                // Simulate IO request (database, HTTP call, ...)
                Thread.sleep(1000);
                uniqueThreadNames.add(Thread.currentThread().threadId());
                IO.println(uniqueThreadNames.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
