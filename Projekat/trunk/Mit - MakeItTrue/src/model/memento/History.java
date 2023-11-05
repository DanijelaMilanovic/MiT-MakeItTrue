package model.memento;

import java.util.ArrayList;
import java.util.List;

import model.AbstractExecutableCommand;
import model.Memento;

/**
 * 
 * Klasa koja pamti izvršene korake i uparuje Memento sa izvršenom Komandom
 *
 */
public class History {
	private List<Pair> history = new ArrayList<Pair>();
	private int virtualSize = 0;
	private boolean active = false;

	private class Pair {
		AbstractExecutableCommand command;
		Memento memento;

		Pair(AbstractExecutableCommand c, Memento m) {
			command = c;
			memento = m;
		}

		private AbstractExecutableCommand getCommand() {
			return command;
		}

		private Memento getMemento() {
			return memento;
		}
	}

	public void push(AbstractExecutableCommand c, Memento m) {
		if (virtualSize != history.size() && virtualSize > 0) {
			history = history.subList(0, virtualSize - 1);
		}
		history.add(new Pair(c, m));
		virtualSize = history.size();
		active = true;
	}

	public boolean undo() {
		Pair pair = getUndo();
		if (pair == null) {
			return false;
		}
		System.out.println("Undoing: " + pair.getCommand());
		pair.getMemento().restore();
		return true;
	}

	public boolean redo() {
		Pair pair = getRedo();
		if (pair == null) {
			return false;
		}
		System.out.println("Redoing: " + pair.getCommand());
		pair.getMemento().restore();
		pair.getCommand().execute();
		return true;
	}

	private Pair getUndo() {
		if (virtualSize == 0) {
			return null;
		}
		virtualSize = Math.max(0, virtualSize - 1);
		return history.get(virtualSize);
	}

	private Pair getRedo() {
 		if (virtualSize == history.size()) {
			return null;
		}
		virtualSize = Math.min(history.size(), virtualSize + 1);
		return history.get(virtualSize - 1);
	}

	public boolean isActive() {
		return active;
	}
}