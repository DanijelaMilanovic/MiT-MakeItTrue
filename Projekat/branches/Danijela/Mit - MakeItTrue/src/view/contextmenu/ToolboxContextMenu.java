package view.contextmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import model.ExecutableCommand;

public class ToolboxContextMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.util.Collection<ExecutableCommand> executableCommand;

	private JCheckBoxMenuItem ANSIelements = null;
	private JCheckBoxMenuItem IECelements = null;

	public JMenuItem getANSIelements() {
		return ANSIelements;
	}

	public JMenuItem getIECelements() {
		return IECelements;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<ExecutableCommand> getExecutableCommand() {
		if (executableCommand == null)
			executableCommand = new java.util.HashSet<ExecutableCommand>();
		return executableCommand;
	}

	/** @pdGenerated default iterator getter */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorExecutableCommand() {
		if (executableCommand == null)
			executableCommand = new java.util.HashSet<ExecutableCommand>();
		return executableCommand.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newExecutableCommand
	 */
	@SuppressWarnings("rawtypes")
	public void setExecutableCommand(java.util.Collection<ExecutableCommand> newExecutableCommand) {
		removeAllExecutableCommand();
		for (java.util.Iterator iter = newExecutableCommand.iterator(); iter.hasNext();)
			addExecutableCommand((ExecutableCommand) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newExecutableCommand
	 */
	public void addExecutableCommand(ExecutableCommand newExecutableCommand) {
		if (newExecutableCommand == null)
			return;
		if (this.executableCommand == null)
			this.executableCommand = new java.util.HashSet<ExecutableCommand>();
		if (!this.executableCommand.contains(newExecutableCommand))
			this.executableCommand.add(newExecutableCommand);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldExecutableCommand
	 */
	public void removeExecutableCommand(ExecutableCommand oldExecutableCommand) {
		if (oldExecutableCommand == null)
			return;
		if (this.executableCommand != null)
			if (this.executableCommand.contains(oldExecutableCommand))
				this.executableCommand.remove(oldExecutableCommand);
	}

	/** @pdGenerated default removeAll */
	public void removeAllExecutableCommand() {
		if (executableCommand != null)
			executableCommand.clear();
	}

	public ToolboxContextMenu() {
		ButtonGroup buttonGroup = new ButtonGroup();

		ANSIelements = new JCheckBoxMenuItem("<html><b>ANSI</b></html>");
		ANSIelements.setState(true);
		add(ANSIelements);

		IECelements = new JCheckBoxMenuItem("<html><b>IEC</b></html");
		IECelements.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funkcija u implementaciji!!!", "Poruka",
						JOptionPane.INFORMATION_MESSAGE);
				ANSIelements.setState(true);
			}

		});
		add(IECelements);

		buttonGroup.add(ANSIelements);
		buttonGroup.add(IECelements);
		add(Box.createHorizontalGlue());
	}

}
