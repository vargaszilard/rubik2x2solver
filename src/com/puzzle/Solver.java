package com.puzzle;

import java.util.List;

public interface Solver {

    public List<State> solve(State initialState);

}
