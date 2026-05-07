///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//PREVIEW

void main(String... args) {
    try (var scope = new StructuredTaskScope<>()) {
        var task1 = scope.fork(() -> {
            IO.println("Task 1");
            //long running task such as a network call or a database query
            Thread.sleep(1000);
            return 1;
        });
        var task2 = scope.fork(() -> {
            IO.println("Task 2");
            Thread.sleep(1000);
            return 2;
        });
        scope.join();
        IO.println("Sum: " + (task1.get() + task2.get()));
        var task3 = scope.fork(() -> {
            IO.println("Task 3 runs after task 1 and task 2");
            return 3;
        });
        scope.join();
        IO.println("Sum: " + (task1.get() + task2.get() + task3.get()));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
