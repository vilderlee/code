package com.vilderlee.design.commandchain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/26      Create this file
 * </pre>
 */
public abstract class BaseCommandChain implements CommandChain{

    protected List<Command> commands = new ArrayList<>();

    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public boolean execute(Context context) throws Exception {
        return false;
    }
}
