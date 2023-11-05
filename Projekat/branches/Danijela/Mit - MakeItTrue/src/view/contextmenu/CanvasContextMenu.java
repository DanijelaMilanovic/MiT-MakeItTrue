package view.contextmenu;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.ExecutableCommand;

public class CanvasContextMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.util.Collection<ExecutableCommand> executableCommand;

	private JMenuItem isjecanjeElemenata = null;
	private JMenuItem kopiranjeElemenata = null;
	private JMenuItem lijepljenjeElemenata = null;
	private JCheckBoxMenuItem mrezaZaCrtanje = null;
	private JMenuItem rotiranjeElementa = null;
	private JMenuItem horPoravnanjeElemenata = null;
	private JMenuItem verPoravnanjeElemenata = null;
	private JMenuItem spajanjeElemenata = null;
	private JMenuItem brisanjeElementa = null;
	private JMenuItem povratakNaPrethodniKorak = null;
	private JMenuItem povratakNaPonisteniKorak = null;

	public JMenuItem getIsjecanjeElemenata() {
		return isjecanjeElemenata;
	}

	public JMenuItem getKopiranjeElemenata() {
		return kopiranjeElemenata;
	}

	public JMenuItem getLijepljenjeElemenata() {
		return lijepljenjeElemenata;
	}

	public JCheckBoxMenuItem getMrezaZaCrtanje() {
		return mrezaZaCrtanje;
	}

	public JMenuItem getRotiranjeElementa() {
		return rotiranjeElementa;
	}

	public JMenuItem getHorPoravnanjeElemenata() {
		return horPoravnanjeElemenata;
	}

	public JMenuItem getVerPoravnanjeElemenata() {
		return verPoravnanjeElemenata;
	}

	public JMenuItem getSpajanjeElemenata() {
		return spajanjeElemenata;
	}

	public JMenuItem getBrisanjeElementa() {
		return brisanjeElementa;
	}

	public JMenuItem getPovratakNaPrethodniKorak() {
		return povratakNaPrethodniKorak;
	}

	public JMenuItem getPovratakNaPonisteniKorak() {
		return povratakNaPonisteniKorak;
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

	public CanvasContextMenu() {

		isjecanjeElemenata = new JMenuItem("Isjecanje");
		isjecanjeElemenata.setMnemonic(KeyEvent.VK_X);
		isjecanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/cut.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(isjecanjeElemenata);

		kopiranjeElemenata = new JMenuItem("Kopiranje");
		kopiranjeElemenata.setMnemonic(KeyEvent.VK_C);
		kopiranjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/copy.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(kopiranjeElemenata);

		lijepljenjeElemenata = new JMenuItem("Lijepljenje");
		lijepljenjeElemenata.setMnemonic(KeyEvent.VK_V);
		lijepljenjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/paste.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(lijepljenjeElemenata);
		addSeparator();

		mrezaZaCrtanje = new JCheckBoxMenuItem("Mreža za crtanje");
		mrezaZaCrtanje.setState(true);
		mrezaZaCrtanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/grid.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(mrezaZaCrtanje);
		addSeparator();

		rotiranjeElementa = new JMenuItem("Rotiranje elementa");
		rotiranjeElementa.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rotate.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(rotiranjeElementa);

		horPoravnanjeElemenata = new JMenuItem("Horizontalno poravnanje elemenata");
		horPoravnanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/horizontal_aligh.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(horPoravnanjeElemenata);

		verPoravnanjeElemenata = new JMenuItem("Vertikalno poravnanje elemenata");
		verPoravnanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/vertical_align.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(verPoravnanjeElemenata);

		spajanjeElemenata = new JMenuItem("Spajanje elemenata");
		spajanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/merge_elements.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(spajanjeElemenata);

		brisanjeElementa = new JMenuItem("Brisanje elemenata");
		brisanjeElementa.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_element.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(brisanjeElementa);
		addSeparator();

		povratakNaPrethodniKorak = new JMenuItem("Povratak na prethodni korak");
		povratakNaPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/undo.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(povratakNaPrethodniKorak);

		povratakNaPonisteniKorak = new JMenuItem("Povratak na poništeni korak");
		povratakNaPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/redo.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(povratakNaPonisteniKorak);
	}

}
