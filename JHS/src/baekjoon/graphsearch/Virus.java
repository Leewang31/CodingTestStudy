package baekjoon.graphsearch;

import java.util.*;

public class Virus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computerCount = scanner.nextInt();
        int network = scanner.nextInt();
        scanner.nextLine();

        Computer[] computers = new Computer[computerCount + 1];
        for (int i = 0; i <= computerCount; i++) {
            computers[i] = new Computer(i);
        }

        for (int i = 0; i < network; i++) {
            String[] linkedComputer = scanner.nextLine().split(" ");
            int firstComputer = Integer.parseInt(linkedComputer[0]);
            int secondComputer = Integer.parseInt(linkedComputer[1]);

            computers[firstComputer].linkedComputer.add(computers[secondComputer]);
            computers[secondComputer].linkedComputer.add(computers[firstComputer]);
        }

        Stack<Computer> stack = new Stack<>();
        stack.push(computers[1]);
        while (!stack.isEmpty()) {
            stack.pop().linkedComputer.stream()
                    .filter(Computer::notInfected)
                    .forEach(computer -> {
                        computer.infect();
                        stack.push(computer);
                    });
        }

        System.out.println(Arrays.stream(computers).filter(computer -> computer.hasVirus).count() - 1);
    }

    static class Computer {
        int number;
        boolean hasVirus = false;
        List<Computer> linkedComputer = new ArrayList<>();

        public Computer(int number) {
            this.number = number;
        }

        public void infect() {
            this.hasVirus = true;
        }

        public boolean notInfected() {
            return this.hasVirus;
        }
    }
}
