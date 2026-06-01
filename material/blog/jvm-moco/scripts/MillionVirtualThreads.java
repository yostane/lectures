void main(String... args) {
    Set<String> uniqueWorkers = ConcurrentHashMap.newKeySet();
    Set<String> uniqueThreadPools = ConcurrentHashMap.newKeySet();
    for (int i = 0; i < 1_000_000; i++) {
        Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(1000);
                var threadInfo = Thread.currentThread().toString();
                IO.println(threadInfo);
                // threadInfo will be something like VirtualThread[#(id)]/runnable@ForkJoinPool-(id)-worker-(id)
                var workerStartIndex = threadInfo.indexOf("ForkJoinPool");
                var workerName = threadInfo.substring(workerStartIndex);
                uniqueWorkers.add(workerName);
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
    IO.println(String.join("\n", uniqueWorkers));
}
