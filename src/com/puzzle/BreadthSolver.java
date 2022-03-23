package com.puzzle;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthSolver extends AbstractSolver{

    private Queue<State> queue = new LinkedList<>();

    protected void addState(State s) {
        if (!queue.contains(s))
            queue.offer(s);
    }

    protected boolean hasElements() {
        return !queue.isEmpty();
    }

    protected State nextState() {
        return queue.remove();
    }

    protected void clearOpen() {
        queue.clear();
    }

}
