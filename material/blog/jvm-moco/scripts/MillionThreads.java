void main() {
    for (int i = 0; i < 1_000_000; i++) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
